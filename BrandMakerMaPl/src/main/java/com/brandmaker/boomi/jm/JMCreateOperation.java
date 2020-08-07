package com.brandmaker.boomi.jm;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.boomi.connector.api.ObjectData;
import com.boomi.connector.api.OperationResponse;
import com.boomi.connector.api.ResponseUtil;
import com.boomi.connector.api.UpdateRequest;
import com.boomi.connector.util.BaseUpdateOperation;
import com.brandmaker.soap.jobmanager.DescriptionDto;
import com.brandmaker.soap.jobmanager.DsePortTypeV2;
import com.brandmaker.soap.jobmanager.Result;
import com.brandmaker.soap.jobmanager.VariableDto;
import com.brandmaker.util.XmlUtils;

/**
 * Update / Create Jobs in Job Manager
 * 
 * @author axel.amthor
 *
 */
public class JMCreateOperation extends BaseUpdateOperation {

	private static final Logger Logger = java.util.logging.Logger.getLogger(JMCreateOperation.class.getName());
	
	public JMCreateOperation(JMConnection conn) {
		super(conn);
	}

	/**
	 * Method will be called for Create and Update Operations
	 */
	@Override
	protected void executeUpdate(UpdateRequest request, OperationResponse response) {
		Logger.severe("In JM executeUpdate");
		
		try {
			
			/*
			 * Get the data objects
			 */
			Iterator<ObjectData> odIterator = request.iterator();
			
			if ( !odIterator.hasNext() )
			{
				/*
				 * If we do not have at least one data object, exit with error
				 */
				ResponseUtil.addCombinedFailure(response, request, "No input data given");
			}
			
			/*
			 * Iterate over input objects
			 */
			while (odIterator.hasNext() )  {
				
				ObjectData data = odIterator.next();
				
				/*
				 * Get an input stream for this object. This is retrieving the objects data and
				 * might be large, see JavaDoc for this method!
				 */
				InputStream is = data.getData();
				
				/*
				 * Unmarshal the stream and convert into a PoJo (DescriptionDto in this case)
				 */
				JAXBContext jaxbContext = JAXBContext.newInstance(DescriptionDto.class.getPackage().getName());  
			    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
			        
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				dbf.setNamespaceAware(true);
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document doc = db.parse(is);
				Element root = doc.getDocumentElement();
			    
			    
				JAXBElement<DescriptionDto> dto = jaxbUnmarshaller.unmarshal(root, DescriptionDto.class);
				
				/*
				 * close stream (crucial!)
				 */
				is.close();

				List<VariableDto> variables = dto.getValue().getVariable();
				for ( VariableDto variable : variables ) {
					Logger.severe("Variable: " + variable.getTechnicalName() + " = " + variable.getValue() );
				}
				
				DsePortTypeV2 port = JMHelpers.initJobManagerAndLogin(getContext());
				
				if ( port != null ) {
					Result r = port.createV2(dto.getValue());
					
					if ( r.isSuccess() ) {
						String resultString = XmlUtils.pojoToXmlString(r, "com.brandmaker.soap.jobmanager.Result");
						ResponseUtil.addSuccess(response, data, null, ResponseUtil.toPayload(resultString) );
					}
					else {
						ResponseUtil.addFailure(response, data, r.getException());
					}
					return;
				}
				
				ResponseUtil.addFailure(response, data, "501");
			}
		} catch (IOException | JAXBException | ParserConfigurationException | SAXException | TransformerException e) {
			Logger.log(Level.SEVERE, "Error", e );
		} 
		
	}

	@Override
    public JMConnection getConnection() {
        return (JMConnection) super.getConnection();
    }
}