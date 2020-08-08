
package com.brandmaker.soap.jobmanager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for prefillingDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="prefillingDto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customStructureName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customStructureAttribute" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="overrideVariableTypeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="permanentBinding" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "prefillingDto", propOrder = {
    "customStructureName",
    "customStructureAttribute",
    "overrideVariableTypeId",
    "permanentBinding"
})
public class PrefillingDto {

    protected String customStructureName;
    protected String customStructureAttribute;
    protected Integer overrideVariableTypeId;
    protected Boolean permanentBinding;

    /**
     * Gets the value of the customStructureName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomStructureName() {
        return customStructureName;
    }

    /**
     * Sets the value of the customStructureName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomStructureName(String value) {
        this.customStructureName = value;
    }

    /**
     * Gets the value of the customStructureAttribute property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomStructureAttribute() {
        return customStructureAttribute;
    }

    /**
     * Sets the value of the customStructureAttribute property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomStructureAttribute(String value) {
        this.customStructureAttribute = value;
    }

    /**
     * Gets the value of the overrideVariableTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOverrideVariableTypeId() {
        return overrideVariableTypeId;
    }

    /**
     * Sets the value of the overrideVariableTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOverrideVariableTypeId(Integer value) {
        this.overrideVariableTypeId = value;
    }

    /**
     * Gets the value of the permanentBinding property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPermanentBinding() {
        return permanentBinding;
    }

    /**
     * Sets the value of the permanentBinding property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPermanentBinding(Boolean value) {
        this.permanentBinding = value;
    }

}
