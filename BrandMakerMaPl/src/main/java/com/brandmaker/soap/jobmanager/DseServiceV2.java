
package com.brandmaker.soap.jobmanager;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "DseServiceV2", targetNamespace = "http://brandmaker.com/webservices/dse/v2/", wsdlLocation = "https://is-dev2.brandmaker.com/webservices/dse/v2/?wsdl")
public class DseServiceV2
    extends Service
{

    private final static URL DSESERVICEV2_WSDL_LOCATION;
    private final static WebServiceException DSESERVICEV2_EXCEPTION;
    private final static QName DSESERVICEV2_QNAME = new QName("http://brandmaker.com/webservices/dse/v2/", "DseServiceV2");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://is-dev2.brandmaker.com/webservices/dse/v2/?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        DSESERVICEV2_WSDL_LOCATION = url;
        DSESERVICEV2_EXCEPTION = e;
    }

    public DseServiceV2() {
        super(__getWsdlLocation(), DSESERVICEV2_QNAME);
    }

    public DseServiceV2(WebServiceFeature... features) {
        super(__getWsdlLocation(), DSESERVICEV2_QNAME, features);
    }

    public DseServiceV2(URL wsdlLocation) {
        super(wsdlLocation, DSESERVICEV2_QNAME);
    }

    public DseServiceV2(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, DSESERVICEV2_QNAME, features);
    }

    public DseServiceV2(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DseServiceV2(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns DsePortTypeV2
     */
    @WebEndpoint(name = "DsePortV2")
    public DsePortTypeV2 getDsePortV2() {
        return super.getPort(new QName("http://brandmaker.com/webservices/dse/v2/", "DsePortV2"), DsePortTypeV2.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DsePortTypeV2
     */
    @WebEndpoint(name = "DsePortV2")
    public DsePortTypeV2 getDsePortV2(WebServiceFeature... features) {
        return super.getPort(new QName("http://brandmaker.com/webservices/dse/v2/", "DsePortV2"), DsePortTypeV2.class, features);
    }

    private static URL __getWsdlLocation() {
        if (DSESERVICEV2_EXCEPTION!= null) {
            throw DSESERVICEV2_EXCEPTION;
        }
        return DSESERVICEV2_WSDL_LOCATION;
    }

}