
package com.brandmaker.soap.jobmanager;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for workflowStepDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="workflowStepDto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userGroups" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="userGroup" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="stepNumber" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="rejectToStep" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="repeatPreviousApprovals" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="downloadAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="subStep" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="rejectToStepMandatory" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="duration" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="manPower" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "workflowStepDto", propOrder = {
    "userGroups"
})
public class WorkflowStepDto {

    protected WorkflowStepDto.UserGroups userGroups;
    @XmlAttribute(name = "id")
    protected Integer id;
    @XmlAttribute(name = "stepNumber")
    protected Integer stepNumber;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "rejectToStep")
    protected Integer rejectToStep;
    @XmlAttribute(name = "repeatPreviousApprovals")
    protected Boolean repeatPreviousApprovals;
    @XmlAttribute(name = "downloadAllowed")
    protected Boolean downloadAllowed;
    @XmlAttribute(name = "subStep")
    protected Boolean subStep;
    @XmlAttribute(name = "rejectToStepMandatory")
    protected Boolean rejectToStepMandatory;
    @XmlAttribute(name = "duration")
    protected Integer duration;
    @XmlAttribute(name = "manPower")
    protected Integer manPower;

    /**
     * Gets the value of the userGroups property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowStepDto.UserGroups }
     *     
     */
    public WorkflowStepDto.UserGroups getUserGroups() {
        return userGroups;
    }

    /**
     * Sets the value of the userGroups property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowStepDto.UserGroups }
     *     
     */
    public void setUserGroups(WorkflowStepDto.UserGroups value) {
        this.userGroups = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the stepNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStepNumber() {
        return stepNumber;
    }

    /**
     * Sets the value of the stepNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStepNumber(Integer value) {
        this.stepNumber = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the rejectToStep property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRejectToStep() {
        return rejectToStep;
    }

    /**
     * Sets the value of the rejectToStep property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRejectToStep(Integer value) {
        this.rejectToStep = value;
    }

    /**
     * Gets the value of the repeatPreviousApprovals property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRepeatPreviousApprovals() {
        return repeatPreviousApprovals;
    }

    /**
     * Sets the value of the repeatPreviousApprovals property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRepeatPreviousApprovals(Boolean value) {
        this.repeatPreviousApprovals = value;
    }

    /**
     * Gets the value of the downloadAllowed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDownloadAllowed() {
        return downloadAllowed;
    }

    /**
     * Sets the value of the downloadAllowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDownloadAllowed(Boolean value) {
        this.downloadAllowed = value;
    }

    /**
     * Gets the value of the subStep property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSubStep() {
        return subStep;
    }

    /**
     * Sets the value of the subStep property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSubStep(Boolean value) {
        this.subStep = value;
    }

    /**
     * Gets the value of the rejectToStepMandatory property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRejectToStepMandatory() {
        return rejectToStepMandatory;
    }

    /**
     * Sets the value of the rejectToStepMandatory property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRejectToStepMandatory(Boolean value) {
        this.rejectToStepMandatory = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDuration(Integer value) {
        this.duration = value;
    }

    /**
     * Gets the value of the manPower property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getManPower() {
        return manPower;
    }

    /**
     * Sets the value of the manPower property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setManPower(Integer value) {
        this.manPower = value;
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
     *         &lt;element name="userGroup" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
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
        "userGroup"
    })
    public static class UserGroups {

        @XmlElement(type = Integer.class)
        protected List<Integer> userGroup;

        /**
         * Gets the value of the userGroup property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the userGroup property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getUserGroup().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Integer }
         * 
         * 
         */
        public List<Integer> getUserGroup() {
            if (userGroup == null) {
                userGroup = new ArrayList<Integer>();
            }
            return this.userGroup;
        }

    }

}
