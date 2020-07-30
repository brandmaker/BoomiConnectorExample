package com.brandmaker.boomi.mapl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

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
import com.boomi.connector.api.ui.AllowedValue;
import com.boomi.connector.api.ui.BrowseField;
import com.boomi.connector.api.ui.DataType;
import com.boomi.connector.api.ui.DisplayType;
import com.boomi.connector.util.BaseBrowser;
import com.brandmaker.mapl.MapsRestWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;

public class BrandMakerMaPlBrowser extends BaseBrowser implements ConnectionTester {

	private static final Logger Logger = java.util.logging.Logger.getLogger(BrandMakerMaPlBrowser.class.getName());
	
	private MapsRestWrapper restWrapper = null;
	
	public static enum GetOperations {
		TREES("Get Years"),
		YEAR("Get running fiscal year"),
		NODE("Get Nodes"),
		BUDGET("Get Budgets"),
		
		;
		
		private final String operation;
		GetOperations (String GetOperations)
		{
			operation = GetOperations;
		}
		public String getOperation()
		{
			return operation;
		}
	};
	
    protected BrandMakerMaPlBrowser(BrandMakerMaPlConnection conn) {
    	
        super(conn);
    }

	@Override
	public ObjectDefinitions getObjectDefinitions(String objectTypeId, Collection<ObjectDefinitionRole> roles) {
		
		for ( ObjectDefinitionRole role : roles ) {
			Logger.severe(role.name());
		}
		
		ObjectDefinitions defs = new ObjectDefinitions();
		
		GetOperations objectType = GetOperations.valueOf(objectTypeId);
		
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
			defs.getOperationFields().add(createListField());
			
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
	private BrowseField createListField(){
	   BrowseField listField = new BrowseField();
	   // Mandatory to set an ID
	   listField.setId("listField");
	   // User Friendly Label, defaults to ID if not given.
	   listField.setLabel("List Field");
	   // Mandatory to set a DataType. This Data Type can also be String, Integer for Lists
	   listField.setType(DataType.STRING);

	   for(int i = 0; i< 4; i++){
	       AllowedValue allowedValue = new AllowedValue();
	       allowedValue.setLabel(String.valueOf(i));
	       allowedValue.setValue(String.valueOf(i));
	       listField.getAllowedValues().add(allowedValue);
	   }
	  
	   // Optional Help Text for the String Field
	   listField.setHelpText("List of String Fields");
	   // Optional Default Value for String Field, the default field must match one of the selectable fields. In this case the default will be 2.
	   listField.setDefaultValue("2");
	   // The display type can be of Radio Button or List, if not given, the default will be list.
	   listField.setDisplayType(DisplayType.LIST);
	   return listField;
	}
	
	@Override
	public ObjectTypes getObjectTypes() {
		
		ObjectTypes types = new ObjectTypes();
		ObjectType type;
		
		for ( GetOperations operationType : GetOperations.values() ) {
			type = new ObjectType();
			type.setId(operationType.toString());
			type.setLabel(operationType.getOperation());
			types.getTypes().add(type);
		}
		 
		return types;
	}

	public boolean initRestWrapperAndLogin() {
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
    public BrandMakerMaPlConnection getConnection() {
        return (BrandMakerMaPlConnection) super.getConnection();
    }

	@Override
	public void testConnection() {
		
		
		boolean r = this.initRestWrapperAndLogin();
		
		Logger.log(Level.INFO, Arrays.toString(this.getContext().getConnectorCache().entrySet().toArray()));  
		
		if ( !r ) {
			throw new ConnectorException("Connection not established", new IOException("Connection Error"));
		}
 		
	}
}