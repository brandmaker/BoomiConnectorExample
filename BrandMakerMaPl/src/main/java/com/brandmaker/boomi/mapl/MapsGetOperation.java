package com.brandmaker.boomi.mapl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.bm.maps.TreeDTO;
import com.boomi.connector.api.ConnectorException;
import com.boomi.connector.api.GetRequest;
import com.boomi.connector.api.ObjectIdData;
import com.boomi.connector.api.OperationResponse;
import com.boomi.connector.api.OperationStatus;
import com.boomi.connector.api.PropertyMap;
import com.boomi.connector.api.ResponseUtil;
import com.boomi.connector.util.BaseGetOperation;
import com.brandmaker.boomi.OperationsConstants;
import com.brandmaker.rest.mapl.MapsRestWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class MapsGetOperation extends BaseGetOperation {

	private static final Logger Logger = java.util.logging.Logger.getLogger(MapsGetOperation.class.getName());
	private MapsRestWrapper restWrapper;
	
    public MapsGetOperation(MapsConnection conn) {
        super(conn);
    }

	@Override
	protected void executeGet(GetRequest request, OperationResponse response) {
		
		ObjectIdData requestData = request.getObjectId();
		String objectId = requestData.getObjectId();
		String objectTypeId = getContext().getObjectTypeId();
		Logger.severe(">>>>>>>>>>>>> " + objectTypeId + " / " + objectId );
		
		/*
		 * different GET operations per each "objectTypeID"
		 */
		switch ( OperationsConstants.ConnectorOperations.valueOf(objectTypeId) )
		{
			case TREES:
				getTreeOperation(response, requestData);
				break;
				
			case YEAR:
				getCurrentYearOperation(response, requestData);
				break;
			
			case NODE:
				getNodeOperation(response, requestData);
				break;
				
			default:
				break;
		}
		
		
	}
	
	/**
	 * Get Nodes from the node tree. A tree ID should be set first and passed in as parameter.
	 * Furthermore, we need an external ID or a node ID in order to pick up a node. We cannot search for
	 * node types ...
	 * 
	 * @param response
	 * @param requestData
	 */
	private void getNodeOperation(OperationResponse response, ObjectIdData requestData) {
		
//		String gehtNichtMeldung = "{\"message\":\"MaPL currently is missing appropriate APIs to filter nodes intelligently.\"}";
//		ResponseUtil.addSuccess(response, requestData, String.valueOf(200),  ResponseUtil.toPayload(gehtNichtMeldung));
		
		
		restWrapper = MapsHelpers.initRestWrapperAndLogin(getContext());
		int httpStatusCode = 200;
		Logger.severe("Object ID     : " + requestData.getObjectId());
		Logger.severe("Dynamic props : " + requestData.getDynamicProperties().toString());
		Logger.severe("User def props: " + requestData.getUserDefinedProperties().toString());
		
		if ( restWrapper != null ) {
			JSONArray allNodes = new JSONArray();
			try {
				
				String additionalInfo = "?withAdditionalInfo=true";
				
				String treeId = requestData.getObjectId();
				
				Logger.severe("Find all nodes for tree ID " + treeId );
				
//				ResponseUtil.addSuccess(response, requestData, String.valueOf(httpStatusCode),  ResponseUtil.toPayload(allNodes.toString(4)));
//				return;
				
				String restPath = "/node/root/" + treeId + additionalInfo;
				
				Object result = restWrapper.httpGetRequest(restPath, new HashMap<String, String>());
				
				allNodes.put(result);
			
				getChildren(allNodes, treeId, (JSONObject)result, 0);
				Logger.severe("Found nodes: " + allNodes.length() );
				
				httpStatusCode = restWrapper.getHttpClient().getLastStatus();
				
				ResponseUtil.addSuccess(response, requestData, String.valueOf(httpStatusCode),  ResponseUtil.toPayload(allNodes.toString(4)));
				
			} catch (JSONException e) {
				Logger.log(Level.SEVERE, "An error", e);
				throw new ConnectorException(e);
			}
			
			
		} else {
			response.addResult(requestData, OperationStatus.FAILURE, null, "Authentication failed", null);
		}
		
	}

	/**
	 * Recursively retrieves all existing nodes and adds them to the given JSONArray
	 * 
	 * @param allNodes Array with all nodes
	 * @param parent current parent
	 * @throws JSONException 
	 */
	private void getChildren(JSONArray allNodes, String treeId, JSONObject parent, int level) throws JSONException {
		
		int length = 0;
		int offset = 0;
		int total = 0;
		
		do {
			
			String additionalInfo = "?withAdditionalInfo=true&offset=" + (offset+length);
			
			String restPath = "/node/child/" + parent.get("id") + "/from-tree/" + treeId + "/to-tree/" + treeId + additionalInfo;
			
			JSONObject result = (JSONObject)restWrapper.httpGetRequest(restPath, new HashMap<String, String>());
//			Logger.severe(result.toString(4));
			
			JSONArray nodes = result.getJSONArray("content");
			
			length = nodes.length();
			offset = result.getInt("offset");
			total = result.getInt("totalElements");
//			Logger.severe(String.valueOf(level) + ": got " + length + " nodes from " + offset + ", need " + total);
			
			// iterate over result, add to result array and dive into recursion
			for ( int n = 0; n < length; n++ ) {
				JSONObject nodeObject = nodes.getJSONObject(n);
				
				allNodes.put(nodeObject);
				
				boolean leaf = nodeObject.getBoolean("leaf");
				
				if ( ! leaf ) {
//					Logger.severe("Recursion on Level " + String.valueOf(level));
					getChildren(allNodes, treeId, nodeObject, level+1);
				}
			}
			
			// next pages on this level
			
		} while ( (offset + length) < total );
		
		
	}

	/**
	 * Get the list of years and find the current running year
	 * 
	 * @param response
	 * @param requestData
	 * @throws ConnectorException
	 */
	private void getCurrentYearOperation(OperationResponse response, ObjectIdData requestData) throws ConnectorException { 
		int httpStatusCode = 0;
		ArrayList<TreeDTO> currentYearList = new ArrayList<TreeDTO>();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar now = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
		int currentYear = now.get(Calendar.YEAR);
		
		Logger.severe("===============> Looking for current year: " + currentYear);
		
		Logger.severe(this.getContext().getObjectTypeId());
		restWrapper = MapsHelpers.initRestWrapperAndLogin(getContext());
		
		if ( restWrapper != null ) {
			
			TreeDTO[] loy = restWrapper.getListOfYears();
			httpStatusCode = restWrapper.getHttpClient().getLastStatus();
			
			for ( TreeDTO tree : loy ) {
				
				GregorianCalendar treeCalStart = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
				GregorianCalendar treeCalEnd = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
				treeCalStart.setTime(tree.getStartDate());
				treeCalEnd.setTime(tree.getEndDate());
				if ( treeCalStart.before(now) && treeCalEnd.after(now) ) {
					currentYearList.add(tree);
					Logger.severe("===============> Found " + tree.getName() + ": " + treeCalStart.get(Calendar.YEAR) + " - " + treeCalEnd.get(Calendar.YEAR) );
					break;
				}
			}
			
			if ( currentYearList != null && currentYearList.size() > 0 ) {
				
				ObjectMapper mapper = new ObjectMapper();
				mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
				mapper.setDateFormat(df);
				
				try {
					String jsonInString = mapper.writeValueAsString(currentYearList.toArray(new TreeDTO[currentYearList.size()]));
					Logger.severe(jsonInString);
					
					ResponseUtil.addSuccess(response, requestData, String.valueOf(httpStatusCode),  ResponseUtil.toPayload(jsonInString));
					
					return;
					
				} catch (JsonProcessingException e) {
					Logger.log(Level.SEVERE, "An error", e);
					throw new ConnectorException(e);
				}
			} else {
				response.addResult(requestData, OperationStatus.FAILURE, null, "No current running year found", null);
			}
			
			
		} else {
			response.addResult(requestData, OperationStatus.FAILURE, null, "Authentication failed", null);
		}
	}

	/**
	 * Get the list of "trees" which are the fiscal years of the client. We do not expect much data here, 20 years = 4 KB
	 * 
	 * @param response
	 * @param requestData
	 * @throws ConnectorException
	 */
	private void getTreeOperation(OperationResponse response, ObjectIdData requestData) throws ConnectorException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		int httpStatusCode = 200;
		
		Logger.severe(this.getContext().getObjectTypeId());
		restWrapper = MapsHelpers.initRestWrapperAndLogin(getContext());
		
		if ( restWrapper != null ) {
			TreeDTO[] loy = restWrapper.getListOfYears();
			httpStatusCode = restWrapper.getHttpClient().getLastStatus();
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
			mapper.setDateFormat(df);
			
			try {
				String jsonInString = mapper.writeValueAsString(loy);
//				Logger.severe(jsonInString);
				
				ResponseUtil.addSuccess(response, requestData, String.valueOf(httpStatusCode),  ResponseUtil.toPayload(jsonInString));
				
				return;
				
			} catch (JsonProcessingException e) {
				Logger.log(Level.SEVERE, "An error", e);
				throw new ConnectorException(e);
			}
		}
		else {
			response.addResult(requestData, OperationStatus.FAILURE, null, "Authentication failed", null);
		}
	}

	@Override
    public MapsConnection getConnection() {
        return (MapsConnection) super.getConnection();
    }
	
}