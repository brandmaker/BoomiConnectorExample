
package com.brandmaker.soap.jobmanager;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for descriptionDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="descriptionDto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="assignDefaultValues" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="creator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="localeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="maplNodeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="parentId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="state" type="{http://brandmaker.com/webservices/dse/v2/}dseObjectState" minOccurs="0"/>
 *         &lt;element name="topicName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="typeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="variable" type="{http://brandmaker.com/webservices/dse/v2/}variableDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="workflowStepName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workflowTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "descriptionDto", propOrder = {
    "assignDefaultValues",
    "creator",
    "id",
    "localeId",
    "maplNodeId",
    "parentId",
    "state",
    "topicName",
    "typeName",
    "variable",
    "workflowStepName",
    "workflowTypeName"
})
@XmlSeeAlso({
    DetailedDto.class
})
public class DescriptionDto {

    protected Boolean assignDefaultValues;
    protected String creator;
    protected Integer id;
    protected Integer localeId;
    protected Integer maplNodeId;
    protected Integer parentId;
    @XmlSchemaType(name = "string")
    protected DseObjectState state;
    protected String topicName;
    protected String typeName;
    @XmlElement(nillable = true)
    protected List<VariableDto> variable;
    protected String workflowStepName;
    protected String workflowTypeName;

    /**
     * Gets the value of the assignDefaultValues property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAssignDefaultValues() {
        return assignDefaultValues;
    }

    /**
     * Sets the value of the assignDefaultValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAssignDefaultValues(Boolean value) {
        this.assignDefaultValues = value;
    }

    /**
     * Gets the value of the creator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreator() {
        return creator;
    }

    /**
     * Sets the value of the creator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreator(String value) {
        this.creator = value;
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
     * Gets the value of the localeId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLocaleId() {
        return localeId;
    }

    /**
     * Sets the value of the localeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLocaleId(Integer value) {
        this.localeId = value;
    }

    /**
     * Gets the value of the maplNodeId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaplNodeId() {
        return maplNodeId;
    }

    /**
     * Sets the value of the maplNodeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaplNodeId(Integer value) {
        this.maplNodeId = value;
    }

    /**
     * Gets the value of the parentId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * Sets the value of the parentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setParentId(Integer value) {
        this.parentId = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link DseObjectState }
     *     
     */
    public DseObjectState getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link DseObjectState }
     *     
     */
    public void setState(DseObjectState value) {
        this.state = value;
    }

    /**
     * Gets the value of the topicName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTopicName() {
        return topicName;
    }

    /**
     * Sets the value of the topicName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTopicName(String value) {
        this.topicName = value;
    }

    /**
     * Gets the value of the typeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Sets the value of the typeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeName(String value) {
        this.typeName = value;
    }

    /**
     * Gets the value of the variable property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the variable property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVariable().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VariableDto }
     * 
     * 
     */
    public List<VariableDto> getVariable() {
        if (variable == null) {
            variable = new ArrayList<VariableDto>();
        }
        return this.variable;
    }

    /**
     * Gets the value of the workflowStepName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkflowStepName() {
        return workflowStepName;
    }

    /**
     * Sets the value of the workflowStepName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkflowStepName(String value) {
        this.workflowStepName = value;
    }

    /**
     * Gets the value of the workflowTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkflowTypeName() {
        return workflowTypeName;
    }

    /**
     * Sets the value of the workflowTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkflowTypeName(String value) {
        this.workflowTypeName = value;
    }

}
