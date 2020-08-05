
package com.brandmaker.soap.jobmanager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for workflowTypeResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="workflowTypeResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="workflowType" type="{http://brandmaker.com/webservices/dse/v2/}workflowTypeDto" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "workflowTypeResult", propOrder = {
    "workflowType"
})
public class WorkflowTypeResult {

    protected WorkflowTypeDto workflowType;

    /**
     * Gets the value of the workflowType property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowTypeDto }
     *     
     */
    public WorkflowTypeDto getWorkflowType() {
        return workflowType;
    }

    /**
     * Sets the value of the workflowType property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowTypeDto }
     *     
     */
    public void setWorkflowType(WorkflowTypeDto value) {
        this.workflowType = value;
    }

}
