
package com.brandmaker.soap.jobmanager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getForwardCandidatesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getForwardCandidatesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://brandmaker.com/webservices/dse/v2/}workflowStepAssignmentDto" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getForwardCandidatesResponse", propOrder = {
    "_return"
})
public class GetForwardCandidatesResponse {

    @XmlElement(name = "return", namespace = "http://brandmaker.com/webservices/dse/v2/")
    protected WorkflowStepAssignmentDto _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowStepAssignmentDto }
     *     
     */
    public WorkflowStepAssignmentDto getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowStepAssignmentDto }
     *     
     */
    public void setReturn(WorkflowStepAssignmentDto value) {
        this._return = value;
    }

}
