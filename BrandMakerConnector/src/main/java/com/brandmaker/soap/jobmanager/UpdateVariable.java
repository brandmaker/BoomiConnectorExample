
package com.brandmaker.soap.jobmanager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateVariable complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateVariable">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="variableTypeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="dseObjectId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="localeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="editable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateVariable", propOrder = {
    "variableTypeId",
    "dseObjectId",
    "localeId",
    "editable",
    "value"
})
public class UpdateVariable {

    protected Integer variableTypeId;
    protected Integer dseObjectId;
    protected Integer localeId;
    protected Boolean editable;
    protected String value;

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

    /**
     * Gets the value of the dseObjectId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDseObjectId() {
        return dseObjectId;
    }

    /**
     * Sets the value of the dseObjectId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDseObjectId(Integer value) {
        this.dseObjectId = value;
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

}
