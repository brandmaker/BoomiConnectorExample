
package com.brandmaker.soap.jobmanager;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "DseWebServiceFault", targetNamespace = "http://brandmaker.com/webservices/dse/v2/")
public class DseWebServiceFault_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private DseWebServiceFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public DseWebServiceFault_Exception(String message, DseWebServiceFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public DseWebServiceFault_Exception(String message, DseWebServiceFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.brandmaker.soap.jobmanager.DseWebServiceFault
     */
    public DseWebServiceFault getFaultInfo() {
        return faultInfo;
    }

}