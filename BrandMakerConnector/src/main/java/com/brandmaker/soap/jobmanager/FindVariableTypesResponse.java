
package com.brandmaker.soap.jobmanager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for findVariableTypesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="findVariableTypesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://brandmaker.com/webservices/dse/v2/}variableTypeList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findVariableTypesResponse", propOrder = {
    "_return"
})
public class FindVariableTypesResponse {

    @XmlElement(name = "return")
    protected VariableTypeList _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link VariableTypeList }
     *     
     */
    public VariableTypeList getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link VariableTypeList }
     *     
     */
    public void setReturn(VariableTypeList value) {
        this._return = value;
    }

}
