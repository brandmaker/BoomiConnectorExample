package com.brandmaker.mapl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.bm.maps.BMonthDTO;
import com.bm.maps.KpiDTO;
import com.bm.maps.NodeDTO;
import com.bm.maps.SunkCostDTO;
import com.bm.maps.TreeDTO;
import com.bm.maps.base.AnnexPeriodViewBase;
import com.brandmaker.util.HttpConnectionHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author axel.amthor
 *
 */
public class MapsRestWrapper {
	
	private static final String REFRESH_TOKEN_EXPIRATION = "refreshTokenExpiration";

	private static final String ACCESS_TOKEN_EXPIRATION = "accessTokenExpiration";

	private static final String EXPIRE_REFRESH_TOKEN_DATE = "expireRefreshTokenDate";

	private static final String EXPIRE_ACCESS_TOKEN_DATE = "expireAccessTokenDate";

	private static final String REFRESH_TOKEN = "refreshToken";

	private static final String ACCESS_TOKEN = "accessToken";

	private static final Logger Logger = java.util.logging.Logger.getLogger(HttpConnectionHandler.class.getName());
	
	private final static String MAPS_REST_BASE = "/maps/rest/api/v3.6";
	
	private String serviceUrl;
	private HashMap<String, String> requestHeaders = new HashMap<String, String>();

	private String accessToken;

	private String refreshToken;

	private Long accessTokenExpiration;

	private Long refreshTokenExpiration;

	private ConcurrentMap<Object, Object> connectorCache;

	private HttpConnectionHandler httpClient;
	
	
	public MapsRestWrapper(String serviceUrl, ConcurrentMap<Object, Object> connectoreCache) {
		
		this.serviceUrl = serviceUrl.replaceAll("/*$", "");
		this.connectorCache = connectoreCache;
		this.httpClient = new HttpConnectionHandler();
		
		Logger.info( "instantiating stub for: " + serviceUrl);
	}

	public NodeDTO getNode(Long campaignId) {
		String url = serviceUrl +  MAPS_REST_BASE + "/node/" + campaignId;
		
		httpClient = new HttpConnectionHandler();
		
		try {
			byte[] response = httpClient.getResponse("GET", url, new HashMap<String, String>(), requestHeaders);
			
			if ( response != null && response.length > 0 ) {
				ObjectMapper mapper = new ObjectMapper();
				
				NodeDTO n = mapper.readValue(response, NodeDTO.class);
				
				return n;
			}
			
		} 
		catch (IOException e) {
			Logger.log(Level.SEVERE, "", e);
		}
		
		return null;
	}
	
	public BMonthDTO getBudgetsPlanned(Long campaignId, Long treeId) {
		String url = serviceUrl +  MAPS_REST_BASE + "/budget/node/" + campaignId + "/tree/" + treeId + "?field=month";
		Logger.info( "get budgets: " + url );
		
		httpClient = new HttpConnectionHandler();
		
		try {
			byte[] response = httpClient.getResponse("GET", url, new HashMap<String, String>(), requestHeaders);
			
			Logger.info( "budgets: " + new String(response) );
			
			if ( response != null && response.length > 0 ) {
				
				JSONObject wrapper = new JSONObject(new String(response));
				
				if ( wrapper.has("month") ) {
					
					String month = wrapper.getJSONObject("month").toString();
					Logger.info( "month: " + month );
					
					ObjectMapper mapper = new ObjectMapper();
				
					BMonthDTO n = mapper.readValue(month, BMonthDTO.class);
				
					return n;
				}
			}
			
		} 
		catch (IOException | JSONException e) {
			Logger.log(Level.SEVERE, "", e);
		}
		
		return null;
	}
	
	public Object httpGetRequest(String requestPath, HashMap<String, String> params) {
		Object responseObject = null;
		String url = serviceUrl + MAPS_REST_BASE + (requestPath.startsWith("/") ? requestPath : "/" + requestPath);
//		Logger.info( "Generic GET: " + url );
		
		httpClient = new HttpConnectionHandler();
		
		try {
			byte[] response = httpClient.getResponse("GET", url, params, requestHeaders);
			
			if ( response != null && response.length > 0 ) {
				String jsonResult = (new String(response, StandardCharsets.UTF_8)).trim();
//				Logger.severe( "response: " + jsonResult );
				
				if ( jsonResult.startsWith("{") )
						responseObject = new JSONObject(jsonResult);
				
				if ( jsonResult.startsWith("[") )
						responseObject = new JSONArray(jsonResult);
				
				return responseObject;
			}
			
		} 
		catch (IOException | JSONException e) {
			Logger.log(Level.SEVERE, "Some error: ", e);
		}
		
		return responseObject;
	}
	
	public KpiDTO getPlanKpi(Long nodeId, int kpiDefId) {
		
		String url = serviceUrl + MAPS_REST_BASE + "/kpi/node/" + nodeId;
		Logger.info( "get kpis: " + url );
		
		httpClient = new HttpConnectionHandler();
		
		try {
			byte[] response = httpClient.getResponse("GET", url, new HashMap<String, String>(), requestHeaders);
			Logger.info( "kpis: " + new String(response) );
			
			if ( response != null && response.length > 0 ) {
				ObjectMapper mapper = new ObjectMapper();
				
				KpiDTO[] n = mapper.readValue(response, KpiDTO[].class);
				
				for ( KpiDTO kpi : n ) {
					Logger.info( "Kpi " + kpi.getId() + " is Def " + kpi.getKpiDefinitionId() );
					if ( kpi.getKpiDefinitionId() == kpiDefId ) {
						return kpi;
					}
				}
			}
			
		} 
		catch (IOException e) {
			Logger.log(Level.SEVERE, "", e);
		}
		
		return null;
	}
	
	
	public boolean assignPlanKpi(KpiDTO kpiPlanWS) {

		try
		{
			ObjectMapper mapper = new ObjectMapper();
			
			String jsonString = mapper.writeValueAsString(kpiPlanWS);
			
			Logger.info( jsonString );
			
			httpClient = new HttpConnectionHandler();
			
			String url = serviceUrl + MAPS_REST_BASE + "/kpi/node/" + kpiPlanWS.getNodeId() + "/kpi-definition/" + kpiPlanWS.getKpiDefinitionId();
			
			byte[] response = httpClient.getResponse("POST", url, jsonString, requestHeaders);
			
			if ( response != null ) Logger.info( "kpi assigned: " + new String(response) );
			
			return true;
			
		}
		catch ( Exception e )
		{
			Logger.log(Level.SEVERE, "", e);
		}
		return false;
	}
	
	public boolean updatePlanKpi(KpiDTO kpiPlanWS) {
		
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			
			String jsonString = mapper.writeValueAsString(kpiPlanWS);
			
			Logger.info(  jsonString );
			
			httpClient = new HttpConnectionHandler();
			
			String url = serviceUrl + MAPS_REST_BASE + "/kpi/" + kpiPlanWS.getId();
			
			byte[] response = httpClient.getResponse("PUT", url, jsonString, requestHeaders);
			
			if ( response != null ) Logger.info( "kpi assigned: " + new String(response) );
			
			return true;
			
		}
		catch ( Exception e )
		{
			Logger.log(Level.SEVERE, "", e);
		}
		return false;
	}
	
	private SunkCostDTO postEstimate(Long campaignId, SunkCostDTO estimate) {
		
		httpClient = null;
		byte[] response = null;
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			
			String jsonString = mapper.writeValueAsString(estimate);
			
			JSONObject postData = new JSONObject(jsonString);
			String refDate  = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" )).format(new Date(postData.getLong("date")));
			postData.put("date", refDate);
			jsonString = postData.toString();
			
//			Logger.log(Logger.SEVERITYDEBUG,  jsonString );
			
			httpClient = new HttpConnectionHandler();
			
			String url = serviceUrl + MAPS_REST_BASE + "/sunk-cost/node/" + campaignId + "?forseResize=true"; // the param is actually misspelled!
			
			response = httpClient.getResponse("POST", url, jsonString, requestHeaders);
			
			if ( response != null ) Logger.info( "sunk cost created: " + new String(response) );
			
			SunkCostDTO responseObject = mapper.readValue(response, SunkCostDTO.class);
			
			return responseObject;
			
		}
		catch ( Exception e )
		{
			
			if ( httpClient != null ) {
				Logger.log(Level.SEVERE,  "MaPl API Error: " + httpClient.getLastStatus() + " - " + new String(httpClient.getLastErrorResponse()) );
			}
			else
				Logger.log(Level.SEVERE, "", e);
		}
		
		return null;
	}
	
	public Integer addEstimate(Long campaignId, SunkCostDTO estimate) {
		
		try
		{
			
			SunkCostDTO responseObject = postEstimate(campaignId, estimate);
			
			return responseObject != null ? responseObject.getId() : null;
			
		}
		catch ( Exception e )
		{
			Logger.log(Level.SEVERE, "", e);
		}
		
		return null;
	}
	
	public Integer updateEstimate(SunkCostDTO estimate, long campaignId) {
		
		
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			
			String jsonString = mapper.writeValueAsString(estimate);
			
			JSONObject postData = new JSONObject(jsonString);
			String refDate  = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" )).format(new Date(postData.getLong("date")));
			postData.put("date", refDate);
			jsonString = postData.toString();
			
			Logger.info(  jsonString );
			
			httpClient = new HttpConnectionHandler();
			
			String url = serviceUrl + MAPS_REST_BASE + "/sunk-cost/" + estimate.getId() + "?forseResize=true";  // the param is actually misspelled!
			
			try 
			{
				byte[] response = httpClient.getResponse("PUT", url, jsonString, requestHeaders);
				Logger.info( "sunk cost updated.");
				
			}
			catch ( FileNotFoundException e )
			{
				estimate = postEstimate(campaignId, estimate);
			}
			
			return estimate.getId();
			
		}
		catch ( Exception e )
		{
			Logger.log(Level.SEVERE, "", e);
		}
		
		return null;
	}
	
	public TreeDTO[] getListOfYears() {
		
		String url = serviceUrl + MAPS_REST_BASE + "/tree";
		
		httpClient = new HttpConnectionHandler();
		
		try {
			byte[] response = httpClient.getResponse("GET", url, new HashMap<String, String>(), requestHeaders);
			
			if ( response != null && response.length > 0 ) {
				ObjectMapper mapper = new ObjectMapper();
				
				TreeDTO[] n = mapper.readValue(response, TreeDTO[].class);
				
				return n;
			}
			
		} 
		catch (IOException e) {
			Logger.log(Level.SEVERE, "", e);
		}
		
		return null;
	}

	/**
	 * Get all timelines for a node in a given year 
	 * 
	 * @param cid node ID
	 * @param tid tree ID (year)
	 * @return
	 */
	public ArrayList<AnnexPeriodViewBase> getTimelines(Long cid, Long tid) {
		
		ArrayList<AnnexPeriodViewBase> timelineList = new  ArrayList<AnnexPeriodViewBase>();
		String url = serviceUrl + MAPS_REST_BASE + "/period/node/" + cid + "/tree/" + tid;
		Logger.info( "get periods: " + url );
		
		httpClient = new HttpConnectionHandler();
		
		try {
			byte[] response = httpClient.getResponse("GET", url, new HashMap<String, String>(), requestHeaders);
			Logger.info( "periods: " + new String(response) );
			
			if ( response != null && response.length > 0 ) {
				
				JSONObject wrapper = new JSONObject(new String(response));
				
				if ( wrapper.has("content") ) {
					
					String content = wrapper.getJSONArray("content").toString();
					
					ObjectMapper mapper = new ObjectMapper();
				
					AnnexPeriodViewBase[] n = mapper.readValue(content, AnnexPeriodViewBase[].class);
					
					for ( AnnexPeriodViewBase apvb : n ) {
						Logger.info( "period: " + apvb.getName() );
						timelineList.add(apvb);
					}
				}
			}
			
		} 
		catch (IOException | JSONException e) {
			Logger.log(Level.SEVERE, "", e);
		}
		
		return timelineList;
	}

	public void logout() {
		
	}

	
	/**
	 * Take a response byte array, parse as jeson, pick the tokens if valid and store persistently
	 * 
	 * @param response
	 * @throws JSONException
	 * @throws ParseException
	 */
	private void storeTokens(byte[] response) throws JSONException, ParseException 
	{
		JSONObject newTokens = response != null ? new JSONObject(new String(response)) : null;
		
		Logger.info( newTokens != null ? newTokens.toString(4) : "no response");
		
		if ( newTokens != null ) {
			accessToken = newTokens.getString(ACCESS_TOKEN);
			refreshToken = newTokens.getString(REFRESH_TOKEN);
			
			Date d = parseRFC3339Date(newTokens.getString(EXPIRE_ACCESS_TOKEN_DATE));
			accessTokenExpiration = d.getTime()/1000;
			
			d = parseRFC3339Date(newTokens.getString(EXPIRE_REFRESH_TOKEN_DATE));
			refreshTokenExpiration = d.getTime()/1000;
			
			connectorCache.put(ACCESS_TOKEN, accessToken);
			connectorCache.put(REFRESH_TOKEN, refreshToken);
			connectorCache.put(ACCESS_TOKEN_EXPIRATION, accessTokenExpiration);
			connectorCache.put(REFRESH_TOKEN_EXPIRATION, refreshTokenExpiration);
			
		}
	}
	
	/**
	 * Init the login flow with uid/pwd
	 * 
	 * @param uid
	 * @param pwd
	 * @param connectoreCache 
	 * @return
	 */
	public boolean startLogin( String uid, String pwd) {
		
		if ( !login() )
		{
			String url  =  serviceUrl + "/rest/sso/auth/user-tokens";
			
			HashMap<String, String> postDataMap = new HashMap<String, String>();
			postDataMap.put("login", uid);
			postDataMap.put("password",  pwd);
			
			httpClient = new HttpConnectionHandler();
			
			try {
				byte[] response = httpClient.getResponse("POST", url, postDataMap, null);
				
				Logger.info( new String(response) );
				
				storeTokens(response);
				
				/*
				 * set the authorization header for subsequent requests!
				 * Important if we authenticate for the first time
				 */
				this.requestHeaders.put("Authorization", "Bearer " + accessToken);
				
			} catch (JSONException | ParseException | IOException e) {
				Logger.log(Level.SEVERE, "", e);
				return false;
			}
			return true;
		}
		else
		{
			Logger.info( "Already logged in with valid tokens" );
			return true;
		}
	}
	
	/**
	 * check all tokens, refresh if necessary and set the authorization header accordingly
	 * 
	 * @return true on success, false otherwise
	 */
	public boolean login() {
		
		accessToken = (String) getCachedValue(ACCESS_TOKEN);
		refreshToken = (String) getCachedValue(REFRESH_TOKEN);
		accessTokenExpiration = (Long) getCachedValue(ACCESS_TOKEN_EXPIRATION);
		refreshTokenExpiration = (Long) getCachedValue(REFRESH_TOKEN_EXPIRATION);
		
		if ( accessToken != null && !accessToken.isEmpty() &&
				refreshToken != null && !refreshToken.isEmpty() &&
						accessTokenExpiration != null && accessTokenExpiration > 0 &&
								refreshTokenExpiration != null && refreshTokenExpiration > 0 
				)
		{
			try {
				
				JSONObject jwtPayload = decodeAccessToken(accessToken);
				Logger.info( jwtPayload.toString(4));
	
				accessTokenExpiration = jwtPayload.getLong("exp");
				
				long now = System.currentTimeMillis()/1000;
				Logger.info( accessTokenExpiration + " < " + now +  " = " + (accessTokenExpiration < now) );
				if ( accessTokenExpiration < now ) {
					
					Logger.info( refreshTokenExpiration + " = 0 or > " + now +  " = " + (refreshTokenExpiration == 0 || refreshTokenExpiration > now) );
					if ( refreshTokenExpiration == 0 || refreshTokenExpiration > now ) {
						Logger.info( "we need a refresher ....");
						
						HashMap<String, String> postDataMap = new HashMap<String, String>();
						postDataMap.put(ACCESS_TOKEN, accessToken);
						postDataMap.put(REFRESH_TOKEN,  refreshToken);
						
						httpClient = new HttpConnectionHandler();
						
						byte[] response = httpClient.getResponse("PUT", serviceUrl + "/rest/sso/auth/user-tokens/_update-access-token", postDataMap, null);
						
	//					JSONObject newTokens = response != null ? new JSONObject(new String(response)) : null;
						
						storeTokens(response);
						
					}
					else {
						Logger.log(Level.SEVERE, "All tokens expired");
						return false;
					}
				}
				this.requestHeaders.put("Authorization", "Bearer " + accessToken);
				return true;
			} 
			catch (JSONException e) {
				Logger.log(Level.SEVERE, "", e);
			} catch (MalformedURLException e) {
				Logger.log(Level.SEVERE, "", e);
			} catch (IOException e) {
				Logger.log(Level.SEVERE, "", e);
			} catch (IndexOutOfBoundsException e) {
				Logger.log(Level.SEVERE, "", e);
			} catch (ParseException e) {
				Logger.log(Level.SEVERE, "", e);
			}
		}
		return false;
	}

	private Object getCachedValue(String key) {
		if ( connectorCache.containsKey(key) ) 
			return connectorCache.get(key);
		else {
			Logger.info( "key not in connector cache: " + key);
			return null;
		}
	}
		

	private JSONObject decodeAccessToken(String accessToken) throws JSONException {
		String[] parts = accessToken.split("\\.");
		byte[] payload = Base64.getDecoder().decode(parts[1].getBytes());
		JSONObject jwtPayload = new JSONObject(new String(payload));
		return jwtPayload;
	}
	
	/**
	 * parse a non-well-formed Media Pool Date String
	 * 
	 * Media Pool and MaPl timestamps are like "2018-02-16T08:06:11+01:00" which cannot be parsed directly
	 * as the colon ':' leads to unexpected results
	 * 
	 * 
	 * 
	 * @param datestring
	 * @return
	 * @throws java.text.ParseException
	 * @throws IndexOutOfBoundsException
	 */
	public static java.util.Date parseRFC3339Date(String datestring) throws java.text.ParseException, IndexOutOfBoundsException {
		Date d = new Date();

		// if there is no time zone, we don't need to do any special parsing.
		if (datestring.endsWith("Z")) {
			try {
				SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"); // spec for RFC3339
				d = s.parse(datestring);
			} catch (java.text.ParseException pe) {// try again with optional
													// decimals
				SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'"); // spec for RFC3339 (with fractional seconds)
				s.setLenient(true);
				d = s.parse(datestring);
			}
			return d;
		}

		// step one, split off the timezone.

		if ( datestring.charAt(datestring.length()-6) == '-' || datestring.charAt(datestring.length()-6) == '+' )
		{
			char splitter = datestring.charAt(datestring.length()-6);
			String firstpart = datestring.substring(0, datestring.lastIndexOf(splitter));
			String secondpart = datestring.substring(datestring.lastIndexOf(splitter));

			// step two, remove the colon from the timezone offset
			secondpart = secondpart.substring(0, secondpart.indexOf(':')) + secondpart.substring(secondpart.indexOf(':') + 1);
			datestring = firstpart + secondpart;
		}
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");// spec for RFC3339
		try {
			d = s.parse(datestring);
		} catch (java.text.ParseException pe) {// try again with optional decimals
			s = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ"); // spec for RFC3339 (with  fractional seconds)
			s.setLenient(true);
			d = s.parse(datestring);
		}
		return d;
	}

	public HttpConnectionHandler getHttpClient() {
		return httpClient;
	}

}
