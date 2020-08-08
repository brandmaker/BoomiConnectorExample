package com.brandmaker.boomi;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerException;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.bm.maps.BMonthDTO;
import com.bm.maps.NodeDTO;
import com.bm.maps.TreeDTO;
import com.boomi.connector.api.BrowseContext;
import com.boomi.connector.api.ConnectionTester;
import com.boomi.connector.api.ConnectorException;
import com.boomi.connector.api.ContentType;
import com.boomi.connector.api.ObjectDefinition;
import com.boomi.connector.api.ObjectDefinitionRole;
import com.boomi.connector.api.ObjectDefinitions;
import com.boomi.connector.api.ObjectType;
import com.boomi.connector.api.ObjectTypes;
import com.boomi.connector.util.BaseBrowser;
import com.boomi.connector.util.BaseConnection;
import com.brandmaker.boomi.OperationsConstants.ConnectorOperations;
import com.brandmaker.boomi.jm.JMHelpers;
import com.brandmaker.boomi.mapl.MapsConnection;
import com.brandmaker.boomi.mapl.MapsHelpers;
import com.brandmaker.rest.mapl.MapsRestWrapper;
import com.brandmaker.soap.jobmanager.DescriptionDto;
import com.brandmaker.soap.jobmanager.DsePortTypeV2;
import com.brandmaker.util.XmlUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;

/**
 * Main boomi browser object. The actual browsing or operations are executed by the subclasses. 
 * Currently, Job Manager and Marketing Planner are supported - and only some few endpoints as examples.
 * 
 * @author axel.amthor
 *
 */
public class BrandMakerBrowser extends BaseBrowser implements ConnectionTester {

	private static final Logger Logger = java.util.logging.Logger.getLogger(BrandMakerBrowser.class.getName());
	
	@SuppressWarnings("unchecked")
	public BrandMakerBrowser(MapsConnection conn) {
    	
        super(conn);
        
    }

	/**
	 * Return the "Object Definitions" for he given boomi operation. 
	 * These are basically schema definitions of the provided result objects, either as JSN Schema or as XSD.
	 * These schemata then are parsed and stored as "Profiles" into boomi and can be used as data source descriptions.
	 * Unclear, why we have different namings here and why a "Profile" is based on an "Object Definition" provided by a "Browser". Anyway, here it is ...
	 * 
	 */
	@Override
	public ObjectDefinitions getObjectDefinitions(String objectTypeId, Collection<ObjectDefinitionRole> roles) {
		
		for ( ObjectDefinitionRole role : roles ) {
			Logger.severe(role.name());
		}
		
		ObjectDefinitions defs = new ObjectDefinitions();
		
		ConnectorOperations objectType = OperationsConstants.ConnectorOperations.valueOf(objectTypeId);
		
		/*
		 * The connector provides a list of all possible Object Types, regardless whether it's Job Manager or Marketing Planner or another BrandMaker Module.
		 * We could probably offer a drop-down list in the connection where the user can select the target module, pick that up by the given 
		 * "roles" parameter and provide a specific operations list for that module. As long as we only have very few endpoints implemented, this is regarded to not to be necessary.
		 * 
		 * Again: the naming is PitA: an ObjectType reflects to a "Profile"
		 * 
		 */
		switch ( objectType ) {
		
			case CREATEJOB:
				getXmlSchemaFromClass(defs, DescriptionDto.class);
				break;
				
			case TREES:
			case YEAR:
				getJsonSchemaFromClass(defs, TreeDTO[].class);
				break;
				
			case BUDGET:
				getJsonSchemaFromClass(defs, BMonthDTO.class);
				break;
				
			case NODE:
			default:
				getJsonSchemaFromClass(defs, NodeDTO[].class);
			
//				defs.getOperationFields().add(createListField());
			
		}
	    return defs;
		
	}

	/**
	 * Generate the XSD schema from given PoJo class (mostly some ...DTO)
	 * 
	 * @param defs boomi ObjectDefinition collection
	 * @param clazz the class to be serialized
	 */
	private void getXmlSchemaFromClass(ObjectDefinitions defs, Class<?> clazz) {

		
		try {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			
			XmlUtils.pojoToXSD(clazz, stream);
			
			String finalString = new String(stream.toByteArray());
			Logger.severe(finalString);
			
			ObjectDefinition def = new ObjectDefinition();
			def.setInputType(ContentType.XML);
		    def.setOutputType(ContentType.XML);
		    
		    Document xsdDoc = XmlUtils.convertStringToDocument(finalString);
		    Element start = xsdDoc.getDocumentElement();
	    	
			def.setSchema(start);
			def.setElementName("descriptionDto");
			
			defs.getDefinitions().add(def);
			
		} 
		catch (IOException | TransformerException | JAXBException e) {
			Logger.log(Level.SEVERE, "cannot get schena from " + clazz.getName(), e );
		}
		
		
	}

	/**
	 * Generate the JSON schema from given PoJo class (mostly some ...DTO)
	 * 
	 * @param defs boomi ObjectDefinition collection
	 * @param clazz the class to be serialized
	 */
	private void getJsonSchemaFromClass(ObjectDefinitions defs, Class<?> clazz) {
		
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
	*/
	
	/**
	 * Create a list of so called "Object Types". Actually, these are names for the provided data objects provided by the operation, which is called.
	 */
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
	 * Return the Marketing Planner Connection Object
	 */
	@Override
    public BaseConnection<BrowseContext> getConnection() {
        return super.getConnection();
    }

	/**
	 * test the connection to MArketing Planner and Job Manager. Currently, Marketing Planner and Job Manager have different login mechanics:
	 * Planner needs an access token which needs to be retrieved first (JWT)
	 * Job Manager wants HTTP Basic Authentication
	 */
	@Override
	public void testConnection() {
		
		try {
			MapsRestWrapper restWrapper = MapsHelpers.initRestWrapperAndLogin(getContext());
			
			Logger.log(Level.INFO, Arrays.toString(this.getContext().getConnectorCache().entrySet().toArray()));  
			
			if ( restWrapper == null ) {
				throw new ConnectorException("MaPl connection not established", new IOException("Connection Error"));
			}
			
			DsePortTypeV2 port = JMHelpers.initJobManagerAndLogin(this.getContext());
			
			if ( port == null )
				throw new ConnectorException("JM connection not established", new IOException("Connection Error"));
			
		} 
		catch ( Exception  e) {
			Logger.log(Level.SEVERE, "an error", e);
		}
		
 		
	}
	
}
