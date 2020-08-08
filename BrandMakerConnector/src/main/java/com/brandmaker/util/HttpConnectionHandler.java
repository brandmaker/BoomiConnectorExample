package com.brandmaker.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HttpConnectionHandler
{

	private static final Logger Logger = java.util.logging.Logger.getLogger(HttpConnectionHandler.class.getName());
	
	public static final int HTTP_CHUNKSIZE = 1*1024*1024; //100*1024*1024; 100 MB is too large?
	protected CookieManager cmgr = new CookieManager();

	public HttpURLConnection openUrlConnection(String uri, Map<String,Map>addcookies) throws MalformedURLException, IOException, URISyntaxException
	{
		return openUrlConnection(uri, "GET", addcookies);
	}
	/**
	 * <p>Open a URL connection and follow redirects to the final destination:
	 *
	 * <p>As the ...ty API makes redirects, we can not pass the URI directly to the parser
	 * but need to open a stream which follows the redirects.
	 *
	 * @param uri
	 * @param conn
	 * @return open HttpURLConnection object or null in case of error
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public HttpURLConnection openUrlConnection(String uri, String method, Map<String,Map>addcookies) throws MalformedURLException, IOException, URISyntaxException
	{
		HttpURLConnection conn = null;

		boolean follow = true;
		while ( follow )
		{
			conn = connectUri(uri, method);

			if ( addcookies != null )
			{
				for ( String name : addcookies.keySet() )
				{
					Map<String,String>cookie = addcookies.get(name);
					cmgr.setCookieValue(conn, name, cookie.get(name));
				}
			}
//			Logger.log(Level.INFO, "SET " + cmgr.toString() );
			cmgr.setCookies(conn);

			conn.connect();
			cmgr.storeCookies(conn);
//			Logger.log(Level.INFO, "Stored: " + cmgr.toString());

			int status = conn.getResponseCode();
			if (status != HttpURLConnection.HTTP_OK)
			{
				if (status == HttpURLConnection.HTTP_MOVED_TEMP
					|| status == HttpURLConnection.HTTP_MOVED_PERM
						|| status == HttpURLConnection.HTTP_SEE_OTHER)
				{
					uri = conn.getHeaderField("Location");
					conn.disconnect();
				}
				else
				{
					Logger.log(Level.SEVERE, "Error on connect:" + status );
					throw new IOException("Error on connect:" + status);
				}
			}
			else
				follow = false;
		}

//		Logger.log(Level.INFO, "GET: " + cmgr.toString() );

		return conn;
	}

	public HttpConnectionHandler() {

	}
	
	public byte[] getResponse(String method, String serviceUrl, String raw, HashMap<String, String> headers) throws FileNotFoundException, UnsupportedEncodingException, MalformedURLException, IOException 
	{
		HttpURLConnection conn = connectUri(serviceUrl, method );
		conn.setUseCaches(false);
		
		if ( headers != null ) {
			for ( Entry<String, String> entry : headers.entrySet() ) {
				conn.setRequestProperty(entry.getKey(), entry.getValue()); 
			}
		}
		
		if ( raw != null && raw.length() > 0 ) {
			conn.setRequestProperty("Content-Type", "application/json"); 
			conn.setRequestProperty("charset", "utf-8");
			conn.setRequestProperty("Content-Length", ""+raw.length() );
			try(DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
			   wr.write( raw.getBytes() );
			}
		}
		byte[] response = getRequestResponseBytes(conn);
		return response;
	}
	
	public byte[] getResponse(String method, String serviceUrl, HashMap<String, String> body, HashMap<String, String> headers) throws UnsupportedEncodingException, MalformedURLException, IOException 
	{
		byte[] postData = null;
		
		if ( body != null && body.size() > 0 )
			postData = getDataString(body).getBytes( StandardCharsets.UTF_8 );
		
		HttpURLConnection conn = connectUri(serviceUrl, method );
		conn.setUseCaches(false);
		
		if ( headers != null ) {
			for ( Entry<String, String> entry : headers.entrySet() ) {
				conn.setRequestProperty(entry.getKey(), entry.getValue()); 
			}
		}
		
		if ( postData != null ) {
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8"); 
			conn.setRequestProperty("Content-Length", Integer.toString(postData.length ));
			try(DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
			   wr.write( postData );
			}
		}
		byte[] response = getRequestResponseBytes(conn);
		return response;
	}
	
	public String getDataString(HashMap<String, String> params) throws UnsupportedEncodingException{
	    StringBuilder result = new StringBuilder();
	    boolean first = true;
	    for(Map.Entry<String, String> entry : params.entrySet()){
	        if (first)
	            first = false;
	        else
	            result.append("&");    
	        result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
	        result.append("=");
	        result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
	    }    
	    return result.toString();
	}

	public HttpURLConnection connectUri(String url, String method) throws MalformedURLException, IOException {
		URL mpUrl = new URL(url);
//		Logger.log(Level.INFO, "MP open: " + url);

		HttpURLConnection.setFollowRedirects(true);
		HttpURLConnection  conn = (HttpURLConnection)mpUrl.openConnection();

//		Logger.log(Level.INFO, "MP open: 2");
		HttpURLConnection.setFollowRedirects(true);
		conn.setInstanceFollowRedirects(true);

//		Logger.log(Level.INFO, "MP open: 3");
		// MediaPool is dead slow on "large amounts" of exported assets.
		// "Large" means more than 500 ...
		conn.setReadTimeout(1000*60*12); // 12 Minutes to wait for data
		conn.setConnectTimeout(1000*60*6); // 6 Minutes to wait for connection

//		Logger.log(Level.INFO, "MP open: 4");
		conn.setDoOutput(true);
		conn.setDoInput(true);

//		Logger.log(Level.INFO, "MP open: 5");
		conn.setRequestMethod(method);
		conn.setRequestProperty("Connection", "close");
		conn.setRequestProperty("User-Agent", "Digital/Marketing/Center - https://www.brandmaker.com");

//		Logger.log(Level.INFO, "MP open: 6");
		return conn;
	}

	public HttpURLConnection connectUri(String url) throws MalformedURLException, IOException {
		return 	connectUri(url, "GET");
	}

	public InputStream getRequestInputStream(HttpURLConnection conn) {
		String error;
		try
		{
			conn.connect();
			return (conn.getInputStream());
		}
		catch ( IOException ioe )
		{
			InputStream err = conn.getErrorStream();
			if ( err != null )
			{
				error = readErrorResponse(new BufferedReader(new InputStreamReader(err)));
				Logger.log(Level.SEVERE, "Error Response: " + error );
	//			ioe.printStackTrace();
			}
			else
				Logger.log(Level.SEVERE, "Connection error" );
		}
		return null;
	}
	
	private byte[] lastErrorResponse = null;
	private int lastStatus = 0;

	public byte[] getRequestResponseBytes(HttpURLConnection conn) throws IOException, FileNotFoundException
	{
		byte[] response = null;
		String error;
		try
		{
			conn.connect();
			response = getRequestResponseBytes(conn.getInputStream());
			conn.disconnect();
		}
		catch ( IOException ioe )
		{
			InputStream err = conn.getErrorStream();
			if ( err != null )
			{
				error = readErrorResponse(new BufferedReader(new InputStreamReader(err)));
				setLastStatus(conn.getResponseCode());
//				Logger.log(Level.SEVERE, "Error Response: " + error );
			}
			else
				Logger.log(Level.SEVERE, "Connection error" );
			
			throw ioe;
		}
		return response;
	}

	public String getRequestResponseString(HttpURLConnection conn) {
		String response = null;
		try
		{
			conn.connect();
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			response = getRequestResponseString(rd);
			conn.disconnect();
		}
		catch ( IOException ioe )
		{
			InputStream err = conn.getErrorStream();
			if ( err != null )
			{
				response = readErrorResponse(new BufferedReader(new InputStreamReader(err)));
				Logger.log(Level.SEVERE, "Error Response: " + response );
	//			ioe.printStackTrace();
			}
			else
				Logger.log(Level.SEVERE, "Connection error" );
		}
		return response;
	}

	public String readErrorResponse(BufferedReader rd) {
		String response = null;
		try
		{
			response = getRequestResponseString(rd);
			setLastErrorResponse(response.getBytes());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return response;
	}

	public ByteArrayOutputStream getRequestResponseByteStream(InputStream is) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] byteChunk = new byte[4096*2];
		int n;

		while ((n = is.read(byteChunk)) > 0) {
			baos.write(byteChunk, 0, n);
		}
//		Logger.log(Level.SEVERE, "got " + baos.size()/(1024.0*1024.0) + " MB" );
		
		return baos;
	}

	public byte[] getRequestResponseBytes(InputStream is) throws IOException {
		return getRequestResponseByteStream(is).toByteArray();
	}

	public String getRequestResponseString(BufferedReader rd) throws IOException {
		String line;
		String response = "";
//		Logger.log(Level.SEVERE, "read response");
		while ((line = rd.readLine()) != null) {
//			Logger.log(Level.SEVERE, "read " + line);
		    response += line;
		}
		rd.close();
		return response;
	}
	
	public byte[] getLastErrorResponse() {
		return lastErrorResponse;
	}
	
	public void setLastErrorResponse(byte[] lastErrorResponse) {
		this.lastErrorResponse = lastErrorResponse;
	}
	
	public int getLastStatus() {
		return lastStatus;
	}
	
	public void setLastStatus(int lastStatus) {
		this.lastStatus = lastStatus;
	}

}