package com.brandmaker.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * CookieManager is a simple utilty for handling cookies when working with
 * java.net.URL and java.net.URLConnection objects.
 *
 * Cookies are backed up in a persistent store, wenever new cookies are stored
 * Instantiation will read in the cookie store from file again
 *
 * Multiple instantiation should be prevented, allthough, the store is static.
 *
 **/

public class CookieManager {

	private static final Logger Logger = java.util.logging.Logger.getLogger(CookieManager.class.getName());
	private static final String COOKIES_FILESTORE = "cookies.ser";

	private static Map store = null;

	private static final String SET_COOKIE = "Set-Cookie";
	private static final String COOKIE_VALUE_DELIMITER = ";";
	private static final String PATH = "path";
	private static final String EXPIRES = "expires";
	private static final String DATE_FORMAT = "EEE, dd-MMM-yyyy hh:mm:ss z";
	private static final String SET_COOKIE_SEPARATOR = "; ";
	private static final String COOKIE = "Cookie";

	private static final char NAME_VALUE_SEPARATOR = '=';
	private static final char DOT = '.';

	private DateFormat dateFormat;
	private Level debug = Level.INFO;

	public CookieManager() {

		if ( store == null )
		{
			initFromPersistantStore();
		}
		dateFormat = new SimpleDateFormat(DATE_FORMAT);
	}

	/**
	 * read in any persistant store or create a new one if not available
	 */
	private void initFromPersistantStore()
	{
		ObjectInputStream ois = null;
		try {
			FileInputStream fis = new FileInputStream(COOKIES_FILESTORE);
			ois = new ObjectInputStream(fis);
			store = (Map) ois.readObject();
			Logger.log(debug , "Persistent store now: " + store.toString());
			ois.close();
		}
		catch (ClassNotFoundException|StreamCorruptedException|FileNotFoundException e)
		{
			// we don't have a store or this is corrupted, create an empty one.
			store = new HashMap<String, Map>();
			Logger.log(debug, "New Cookie Store");
		} 
		catch (IOException e) 
		{
			store = new HashMap<String, Map<String, String>>();
			Logger.log(debug, "New Cookie Store");
		}
		finally {
			try {
				savePersistantStore();
			} catch (IOException e1) {
				Logger.log(Level.SEVERE, "cannot persist cookies", e1);
			}	
		}
		
		
	}

	public Map<String, Map> getCookies(URL url)
	{
		String domain = getDomainFromHost(url.getHost());

		return getDomainStore(domain);
	}


	public String getCookieValue(URL uri, String cookieName)
	{
		String domain = getDomainFromHost(uri.getHost());

		Map domainStore = getDomainStore(domain);
		Map<String,String>cookie = (Map) domainStore.get(cookieName);

		if ( cookie != null )
			return cookie.get(cookieName);

		return null;
	}

	public String getCookieValue(URLConnection conn, String cookieName)
	{
		return getCookieValue(conn.getURL(), cookieName);
	}

	public void setCookieValue(URL url, String cookieName, String cookieValue)
	{
		String domain = getDomainFromHost(url.getHost());
		Map domainStore = getDomainStore(domain);

		Map<String,String>cookie = (Map) domainStore.get(cookieName);
		if ( cookie == null )
			cookie = new HashMap();
		cookie.put(cookieName, cookieValue);
		domainStore.put(cookieName, cookie);
	}

	public void setCookieValue(URLConnection conn, String cookieName, String cookieValue)
	{
		setCookieValue(conn.getURL(), cookieName, cookieValue);
	}

	/**
	 * @param domain
	 * @return
	 */
	private Map getDomainStore(String domain) {
		Map domainStore;
		// now let's check the store to see if we have an entry for this domain
		if (store.containsKey(domain)) {
			// we do, so lets retrieve it from the store
			domainStore = (Map) store.get(domain);
		} else {
			// we don't, so let's create it and put it in the store
			domainStore = new HashMap();
			store.put(domain, domainStore);
		}
		return domainStore;
	}

	/**
	 * Retrieves and stores cookies returned by the host on the other side of
	 * the the open java.net.URLConnection.
	 *
	 * The connection MUST have been opened using the connect() method or a
	 * IOException will be thrown.
	 *
	 * @param conn
	 *            a java.net.URLConnection - must be open, or IOException will
	 *            be thrown
	 * @throws java.io.IOException
	 *             Thrown if conn is not open.
	 */
	public void storeCookies(URLConnection conn) throws IOException {

		// let's determine the domain from where these cookies are being sent
		String domain = getDomainFromHost(conn.getURL().getHost());

		Map domainStore; // this is where we will store cookies for this domain

		domainStore = getDomainStore(domain);

		// OK, now we are ready to get the cookies out of the URLConnection

		Map<String,List<String>> headers = conn.getHeaderFields();

		for ( String headerName : headers.keySet() )
		{
//			Logger.log("Header: " + headerName + " = " + conn.getHeaderField(headerName));

			if (headerName != null && headerName.equalsIgnoreCase(SET_COOKIE)) {
				Map cookie = new HashMap();
				StringTokenizer st = new StringTokenizer(conn.getHeaderField(headerName), COOKIE_VALUE_DELIMITER);

				// the specification dictates that the first name/value pair
				// in the string is the cookie name and value, so let's handle
				// them as a special case:

				if (st.hasMoreTokens()) {
					String token = st.nextToken();
					String name = token.substring(0, token.indexOf(NAME_VALUE_SEPARATOR));
					String value = token.substring(token.indexOf(NAME_VALUE_SEPARATOR) + 1, token.length());
					domainStore.put(name, cookie);
					cookie.put(name, value);
				}

				while (st.hasMoreTokens()) {
					String token = st.nextToken();
					if ( token != null && token.length() > 0 )
					{
						if ( token.contains(""+NAME_VALUE_SEPARATOR))
						{
							cookie.put(token.substring(0, token.indexOf(NAME_VALUE_SEPARATOR)).toLowerCase(),
								token.substring(token.indexOf(NAME_VALUE_SEPARATOR) + 1, token.length()));
						}
						else
							cookie.put(token, null);
					}
				}
			}
		}

		savePersistantStore();
	}

	/**
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void savePersistantStore() throws FileNotFoundException, IOException {
		FileOutputStream fos = new FileOutputStream(COOKIES_FILESTORE);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(store);
        oos.close();
	}

	/**
	 * Prior to opening a URLConnection, calling this method will set all
	 * unexpired cookies that match the path or subpaths for thi underlying URL
	 *
	 * The connection MUST NOT have been opened method or an IOException will be
	 * thrown.
	 *
	 * @param conn
	 *            a java.net.URLConnection - must NOT be open, or IOException
	 *            will be thrown
	 * @throws java.io.IOException
	 *             Thrown if conn has already been opened.
	 */
	public void setCookies(URLConnection conn) throws IOException {

		// let's determine the domain and path to retrieve the appropriate
		// cookies
		URL url = conn.getURL();
		String domain = getDomainFromHost(url.getHost());
		String path = url.getPath();

		Map domainStore = (Map) store.get(domain);
		if (domainStore == null)
			return;
		StringBuffer cookieStringBuffer = new StringBuffer();

		Iterator cookieNames = domainStore.keySet().iterator();
		while (cookieNames.hasNext()) {
			String cookieName = (String) cookieNames.next();
			Map cookie = (Map) domainStore.get(cookieName);
			// check cookie to ensure path matches and cookie is not expired
			// if all is cool, add cookie to header string
			if (comparePaths((String) cookie.get(PATH), path) && isNotExpired((String) cookie.get(EXPIRES))) {
				cookieStringBuffer.append(cookieName);

				String val = (String)cookie.get(cookieName);
				if ( val != null )
				{
					cookieStringBuffer.append("=");
					cookieStringBuffer.append(val);
				}
				if (cookieNames.hasNext())
					cookieStringBuffer.append(SET_COOKIE_SEPARATOR);
			}
		}
		Logger.log(debug, "SET: " + cookieStringBuffer);
		try {
			conn.setRequestProperty(COOKIE, cookieStringBuffer.toString());
		} catch (java.lang.IllegalStateException ise) {
			IOException ioe = new IOException("Illegal State! Cookies cannot be set on a URLConnection that is already connected. "
					+ "Only call setCookies(java.net.URLConnection) AFTER calling java.net.URLConnection.connect().");
			throw ioe;
		}
	}

	private static boolean onlyDomain = false;

	private String getDomainFromHost(String host) {
		if ( onlyDomain && host.indexOf(DOT) != host.lastIndexOf(DOT)) {
			return host.substring(host.indexOf(DOT) + 1);
		} else {
			return host;
		}
	}

	private boolean isNotExpired(String cookieExpires) {
		if (cookieExpires == null)
			return true;
		Date now = new Date();
		try {
			return (now.compareTo(dateFormat.parse(cookieExpires))) <= 0;
		} catch (java.text.ParseException pe) {
			pe.printStackTrace();
			return false;
		}
	}

	private boolean comparePaths(String cookiePath, String targetPath) {
		if (cookiePath == null) {
			return true;
		} else if (cookiePath.equals("/")) {
			return true;
		} else if (targetPath.regionMatches(0, cookiePath, 0, cookiePath.length())) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Returns a string representation of stored cookies organized by domain.
	 */

	@Override
	public String toString() {
		return store.toString();
	}
}
