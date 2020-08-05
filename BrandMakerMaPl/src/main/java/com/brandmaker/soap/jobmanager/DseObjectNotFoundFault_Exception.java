
package com.brandmaker.soap.jobmanager;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "DseObjectNotFoundFault", targetNamespace = "http://brandmaker.com/webservices/dse/")
public class DseObjectNotFoundFault_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private DseObjectNotFoundFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public DseObjectNotFoundFault_Exception(String message, DseObjectNotFoundFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public DseObjectNotFoundFault_Exception(String message, DseObjectNotFoundFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.brandmaker.soap.jobmanager.DseObjectNotFoundFault
     */
    public DseObjectNotFoundFault getFaultInfo() {
        return faultInfo;
    }

}