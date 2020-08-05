
package com.brandmaker.soap.jobmanager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for criteriaDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="criteriaDto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cmpCondition" type="{http://brandmaker.com/webservices/dse/v2/}operatorType" minOccurs="0"/>
 *         &lt;element name="cmpTo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dseObjectType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operator" type="{http://brandmaker.com/webservices/dse/v2/}criterionOperator" minOccurs="0"/>
 *         &lt;element name="technicalName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "criteriaDto", propOrder = {
    "cmpCondition",
    "cmpTo",
    "dseObjectType",
    "operator",
    "technicalName"
})
public class CriteriaDto {

    @XmlSchemaType(name = "string")
    protected OperatorType cmpCondition;
    protected String cmpTo;
    protected String dseObjectType;
    @XmlSchemaType(name = "string")
    protected CriterionOperator operator;
    protected String technicalName;

    /**
     * Gets the value of the cmpCondition property.
     * 
     * @return
     *     possible object is
     *     {@link OperatorType }
     *     
     */
    public OperatorType getCmpCondition() {
        return cmpCondition;
    }

    /**
     * Sets the value of the cmpCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperatorType }
     *     
     */
    public void setCmpCondition(OperatorType value) {
        this.cmpCondition = value;
    }

    /**
     * Gets the value of the cmpTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCmpTo() {
        return cmpTo;
    }

    /**
     * Sets the value of the cmpTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCmpTo(String value) {
        this.cmpTo = value;
    }

    /**
     * Gets the value of the dseObjectType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDseObjectType() {
        return dseObjectType;
    }

    /**
     * Sets the value of the dseObjectType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDseObjectType(String value) {
        this.dseObjectType = value;
    }

    /**
     * Gets the value of the operator property.
     * 
     * @return
     *     possible object is
     *     {@link CriterionOperator }
     *     
     */
    public CriterionOperator getOperator() {
        return operator;
    }

    /**
     * Sets the value of the operator property.
     * 
     * @param value
     *     allowed object is
     *     {@link CriterionOperator }
     *     
     */
    public void setOperator(CriterionOperator value) {
        this.operator = value;
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

}
