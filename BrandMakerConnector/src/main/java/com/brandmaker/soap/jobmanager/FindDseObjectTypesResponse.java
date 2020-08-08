
package com.brandmaker.soap.jobmanager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for findDseObjectTypesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="findDseObjectTypesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://brandmaker.com/webservices/dse/v2/}dseObjectTypeList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findDseObjectTypesResponse", propOrder = {
    "_return"
})
public class FindDseObjectTypesResponse {

    @XmlElement(name = "return")
    protected DseObjectTypeList _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link DseObjectTypeList }
     *     
     */
    public DseObjectTypeList getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link DseObjectTypeList }
     *     
     */
    public void setReturn(DseObjectTypeList value) {
        this._return = value;
    }

}
