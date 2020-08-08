package com.brandmaker.boomi.mapl;

import java.util.logging.Logger;

import com.boomi.connector.api.BrowseContext;
import com.boomi.connector.api.PropertyMap;
import com.brandmaker.rest.mapl.MapsRestWrapper;

public class MapsHelpers {

	private static final Logger Logger = java.util.logging.Logger.getLogger(MapsHelpers.class.getName());
	
	/**
	 * Init the Marketing Planner REST wrapper and login to with the credentials from the connector context. 
	 * The returned token and refresh token is stored within the Connector cache for further invocations.
	 * 
	 * @return
	 */
	public static MapsRestWrapper initRestWrapperAndLogin(BrowseContext context) {
		PropertyMap props = context.getConnectionProperties();
		
		String serviceUrl = props.getProperty("url");
		String login = props.getProperty("login");
		String password = props.getProperty("password");
		
		Logger.severe("Login to " + serviceUrl + " with " + login + " / " + password);
		
		/*
		 * we need to pass in the connector cache for the credentials (tokens) to be persisted there
		 */
		MapsRestWrapper restWrapper = new MapsRestWrapper(serviceUrl, context.getConnectorCache());
		
		/*
		 * the "startLogin" method checks for cached credentials and if not available, starts the JWT login!
		 */
		boolean loggedIn = restWrapper.startLogin(login, password);
		Logger.severe("success: " + Boolean.toString(loggedIn));
		
		if ( loggedIn )
			return restWrapper;
		else
			return null;
	}

}
