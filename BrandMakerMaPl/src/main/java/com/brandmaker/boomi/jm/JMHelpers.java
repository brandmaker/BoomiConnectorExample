package com.brandmaker.boomi.jm;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;

import javax.xml.ws.BindingProvider;

import org.apache.axis.utils.StringUtils;

import com.boomi.connector.api.BrowseContext;
import com.boomi.connector.api.ConnectorException;
import com.boomi.connector.api.PropertyMap;
import com.brandmaker.soap.jobmanager.DetailedDto;
import com.brandmaker.soap.jobmanager.DetailedList;
import com.brandmaker.soap.jobmanager.DsePortTypeV2;
import com.brandmaker.soap.jobmanager.DseServiceV2;

public class JMHelpers {

	private static final Logger Logger = java.util.logging.Logger.getLogger(JMHelpers.class.getName());
	
	/**
	 * Returns a JobManager SOAP service port
	 * 
	 * In order to test the connection and the validity of the given credentials, a search for "all jobs" with a limit to 1 is executed. 
	 * Even if there are no jobs at all, we expect to not to get an error. If the operation is not successful, we assume improper credentials and throw a ConnectorException
	 * 
	 * @param context operation context
	 * @return Job Manager soap service port or null in case of error
	 * @throws MalformedURLException
	 * @throws ConnectorException
	 */
	public static DsePortTypeV2 initJobManagerAndLogin(BrowseContext context) throws MalformedURLException, ConnectorException {
		
		PropertyMap props = context.getConnectionProperties();
		
		String serviceUrl = props.getProperty("url");
		String login = props.getProperty("login");
		String password = props.getProperty("password");
		
		DseServiceV2 dseService = new DseServiceV2(new URL( StringUtils.stripEnd(serviceUrl, "/") + "/webservices/dse/v2/") );
		
		DsePortTypeV2 port = dseService.getDsePortV2();
	
		BindingProvider prov = (BindingProvider)port;
		prov.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, login);
		prov.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, password);
		
		/*
		 * in order to test the connection, we just search for one job.
		 */
		DetailedList jobs = port.findAllJobs(false, 0, 1);
	
		if (jobs != null && jobs.isSuccess()) {
			List<DetailedDto> jobList = jobs.getDesriptions();
	
			for (DetailedDto jobDesc : jobList) {
				Logger.severe("found " + jobDesc.getTopicName() + " with id " + jobDesc.getId());
			}
			
			return port;
			
		} else {
			throw new ConnectorException("JM connection not established", new IOException("Connection Error"));
		}
	}

	

}
