
package com.brandmaker.soap.jobmanager;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for workflowStepAssignmentDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="workflowStepAssignmentDto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="workflowStep" type="{http://brandmaker.com/webservices/dse/v2/}innerWorkflowStepDto" minOccurs="0"/>
 *         &lt;element name="candidates" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="userArea" type="{http://brandmaker.com/webservices/dse/v2/}userAreaDto" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "workflowStepAssignmentDto", propOrder = {
    "workflowStep",
    "candidates"
})
public class WorkflowStepAssignmentDto {

    protected InnerWorkflowStepDto workflowStep;
    protected WorkflowStepAssignmentDto.Candidates candidates;

    /**
     * Gets the value of the workflowStep property.
     * 
     * @return
     *     possible object is
     *     {@link InnerWorkflowStepDto }
     *     
     */
    public InnerWorkflowStepDto getWorkflowStep() {
        return workflowStep;
    }

    /**
     * Sets the value of the workflowStep property.
     * 
     * @param value
     *     allowed object is
     *     {@link InnerWorkflowStepDto }
     *     
     */
    public void setWorkflowStep(InnerWorkflowStepDto value) {
        this.workflowStep = value;
    }

    /**
     * Gets the value of the candidates property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowStepAssignmentDto.Candidates }
     *     
     */
    public WorkflowStepAssignmentDto.Candidates getCandidates() {
        return candidates;
    }

    /**
     * Sets the value of the candidates property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowStepAssignmentDto.Candidates }
     *     
     */
    public void setCandidates(WorkflowStepAssignmentDto.Candidates value) {
        this.candidates = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="userArea" type="{http://brandmaker.com/webservices/dse/v2/}userAreaDto" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "userArea"
    })
    public static class Candidates {

        protected List<UserAreaDto> userArea;

        /**
         * Gets the value of the userArea property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the userArea property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getUserArea().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link UserAreaDto }
         * 
         * 
         */
        public List<UserAreaDto> getUserArea() {
            if (userArea == null) {
                userArea = new ArrayList<UserAreaDto>();
            }
            return this.userArea;
        }

    }

}
