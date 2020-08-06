package com.brandmaker.boomi;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.wsdl.Port;
import javax.xml.ws.BindingProvider;

import org.apache.axis.utils.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.bm.maps.BMonthDTO;
import com.bm.maps.NodeDTO;
import com.bm.maps.TreeDTO;
import com.boomi.connector.api.ConnectionTester;
import com.boomi.connector.api.ConnectorException;
import com.boomi.connector.api.ContentType;
import com.boomi.connector.api.ObjectDefinition;
import com.boomi.connector.api.ObjectDefinitionRole;
import com.boomi.connector.api.ObjectDefinitions;
import com.boomi.connector.api.ObjectType;
import com.boomi.connector.api.ObjectTypes;
import com.boomi.connector.api.PropertyMap;
import com.boomi.connector.util.BaseBrowser;
import com.brandmaker.boomi.OperationsConstants.ConnectorOperations;
import com.brandmaker.boomi.mapl.MapsBrowser;
import com.brandmaker.boomi.mapl.MapsConnection;
import com.brandmaker.rest.mapl.MapsRestWrapper;
import com.brandmaker.soap.jobmanager.DetailedDto;
import com.brandmaker.soap.jobmanager.DetailedList;
import com.brandmaker.soap.jobmanager.DsePortTypeV2;
import com.brandmaker.soap.jobmanager.DseServiceV2;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;

public class BrandMakerBrowser extends BaseBrowser implements ConnectionTester {

private static final Logger Logger = java.util.logging.Logger.getLogger(MapsBrowser.class.getName());
	
	private MapsRestWrapper restWrapper = null;
	
	@SuppressWarnings("unchecked")
	public BrandMakerBrowser(MapsConnection conn) {
    	
        super(conn);
        
    }

	@Override
	public ObjectDefinitions getObjectDefinitions(String objectTypeId, Collection<ObjectDefinitionRole> roles) {
		
		for ( ObjectDefinitionRole role : roles ) {
			Logger.severe(role.name());
		}
		
		ObjectDefinitions defs = new ObjectDefinitions();
		
		ConnectorOperations objectType = OperationsConstants.ConnectorOperations.valueOf(objectTypeId);
		
		switch ( objectType ) {
		
			case TREES:
			case YEAR:
				getSchemaFromClass(defs, TreeDTO[].class);
				break;
				
			case BUDGET:
				getSchemaFromClass(defs, BMonthDTO.class);
				break;
				
			case NODE:
			default:
				getSchemaFromClass(defs, NodeDTO[].class);
			
//				defs.getOperationFields().add(createListField());
			
		}
	    return defs;
		
	}

	/**
	 * Generate the JSON schema from given PoJo class (mostly some ...DTO)
	 * 
	 * @param defs boomi ObjectDefinition collection
	 * @param clazz the class to be serialized
	 */
	private void getSchemaFromClass(ObjectDefinitions defs, Class<?> clazz) {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			
			ObjectDefinition def = new ObjectDefinition();
			ObjectMapper mapper = new ObjectMapper();
		    mapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
		    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
			mapper.setDateFormat(df);
			
		    JsonSchemaGenerator schemaGen = new JsonSchemaGenerator(mapper);
		    JsonSchema schema = schemaGen.generateSchema(clazz);
		
		    String schemaString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(schema);
		    
		    JSONObject schemaJson = new JSONObject(schemaString);
		    
		    def.setInputType(ContentType.JSON);
		    def.setOutputType(ContentType.JSON);
			def.setElementName("");
			def.setJsonSchema(schemaJson.toString(2));
			
			Logger.log(Level.SEVERE, schemaJson.toString(2) );
			
			
			defs.getDefinitions().add(def);
		
			
		} catch (JsonProcessingException | JSONException e) {
			Logger.log(Level.SEVERE, "cannot get schena from " + clazz.getName(), e );
		}
	}

	/**
	* Creates a selectable field input for the Operation.
	* @return BrowseField
	*/
//	private BrowseField createListField(){
//	   BrowseField listField = new BrowseField();
//	   // Mandatory to set an ID
//	   listField.setId("listField");
//	   // User Friendly Label, defaults to ID if not given.
//	   listField.setLabel("List Field");
//	   // Mandatory to set a DataType. This Data Type can also be String, Integer for Lists
//	   listField.setType(DataType.STRING);
//
//	   for(int i = 0; i< 4; i++){
//	       AllowedValue allowedValue = new AllowedValue();
//	       allowedValue.setLabel(String.valueOf(i));
//	       allowedValue.setValue(String.valueOf(i));
//	       listField.getAllowedValues().add(allowedValue);
//	   }
//	  
//	   // Optional Help Text for the String Field
//	   listField.setHelpText("List of String Fields");
//	   // Optional Default Value for String Field, the default field must match one of the selectable fields. In this case the default will be 2.
//	   listField.setDefaultValue("2");
//	   // The display type can be of Radio Button or List, if not given, the default will be list.
//	   listField.setDisplayType(DisplayType.LIST);
//	   return listField;
//	}
	
	@Override
	public ObjectTypes getObjectTypes() {
		
		ObjectTypes types = new ObjectTypes();
		ObjectType type;
		
		for ( ConnectorOperations operationType : OperationsConstants.ConnectorOperations.values() ) {
			type = new ObjectType();
			type.setId(operationType.toString());
			type.setLabel(operationType.getOperation());
			types.getTypes().add(type);
		}
		 
		return types;
	}

	/**
	 * Init the MaPl REST wrapper and login to MaPl with the credentials from the connector context
	 * 
	 * @return
	 */
	private boolean initRestWrapperAndLogin() {
		PropertyMap props = this.getContext().getConnectionProperties();
		
		String serviceUrl = props.getProperty("url");
		String login = props.getProperty("login");
		String password = props.getProperty("password");
		
		Logger.severe("Login to " + serviceUrl + " with " + login + " / " + password);
		
		/*
		 * we need to pass in the connector cache for the credentials (tokens) to be persisted there
		 */
		restWrapper = new MapsRestWrapper(serviceUrl, this.getContext().getConnectorCache());
		
		/*
		 * the "startLogin" method checks for cached credentials and if not available, starts the JWT login!
		 */
		boolean loggedIn = restWrapper.startLogin(login, password);
		Logger.severe("success: " + Boolean.toString(loggedIn));
		
		return loggedIn;
	}

	@Override
    public MapsConnection getConnection() {
        return (MapsConnection) super.getConnection();
    }

	/**
	 * test the connection to MaPl and to JM
	 */
	@Override
	public void testConnection() {
		
		
		boolean r = this.initRestWrapperAndLogin();
		
		Logger.log(Level.INFO, Arrays.toString(this.getContext().getConnectorCache().entrySet().toArray()));  
		
		if ( !r ) {
			throw new ConnectorException("MaPl connection not established", new IOException("Connection Error"));
		}
		
		try {
			
			PropertyMap props = this.getContext().getConnectionProperties();
			
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
			
			if ( jobs != null && jobs.isSuccess() ) {
				List<DetailedDto> jobList = jobs.getDesriptions();
				
				for ( DetailedDto jobDesc : jobList ) {
					Logger.severe("found " + jobDesc.getTopicName() + " with id " + jobDesc.getId());
				}
			}
			else {
				throw new ConnectorException("JM connection not established", new IOException("Connection Error"));
			}
			
		} 
		catch (MalformedURLException e) {
			Logger.log(Level.SEVERE, "an error", e);
		}
		
 		
	}

}
