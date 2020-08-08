
package com.brandmaker.soap.jobmanager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for variableDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="variableDto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="editable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="grid" type="{http://brandmaker.com/webservices/dse/v2/}gridDto" minOccurs="0"/>
 *         &lt;element name="subJobs" type="{http://brandmaker.com/webservices/dse/v2/}subJobsDto" minOccurs="0"/>
 *         &lt;element name="technicalName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="variableTypeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "variableDto", propOrder = {
    "editable",
    "grid",
    "subJobs",
    "technicalName",
    "value",
    "variableTypeId"
})
public class VariableDto {

    protected Boolean editable;
    protected GridDto grid;
    protected SubJobsDto subJobs;
    protected String technicalName;
    protected String value;
    protected Integer variableTypeId;

    /**
     * Gets the value of the editable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEditable() {
        return editable;
    }

    /**
     * Sets the value of the editable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEditable(Boolean value) {
        this.editable = value;
    }

    /**
     * Gets the value of the grid property.
     * 
     * @return
     *     possible object is
     *     {@link GridDto }
     *     
     */
    public GridDto getGrid() {
        return grid;
    }

    /**
     * Sets the value of the grid property.
     * 
     * @param value
     *     allowed object is
     *     {@link GridDto }
     *     
     */
    public void setGrid(GridDto value) {
        this.grid = value;
    }

    /**
     * Gets the value of the subJobs property.
     * 
     * @return
     *     possible object is
     *     {@link SubJobsDto }
     *     
     */
    public SubJobsDto getSubJobs() {
        return subJobs;
    }

    /**
     * Sets the value of the subJobs property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubJobsDto }
     *     
     */
    public void setSubJobs(SubJobsDto value) {
        this.subJobs = value;
    }

    /**
     * Gets the value of the technicalName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTechnicalName() {
        return technicalName;
    }

    /**
     * Sets the value of the technicalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTechnicalName(String value) {
        this.technicalName = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the variableTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getVariableTypeId() {
        return variableTypeId;
    }

    /**
     * Sets the value of the variableTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setVariableTypeId(Integer value) {
        this.variableTypeId = value;
    }

}
