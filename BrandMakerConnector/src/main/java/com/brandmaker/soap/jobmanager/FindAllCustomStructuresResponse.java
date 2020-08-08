
package com.brandmaker.soap.jobmanager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for findAllCustomStructuresResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="findAllCustomStructuresResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://brandmaker.com/webservices/dse/v2/}customStructureList" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findAllCustomStructuresResponse", propOrder = {
    "_return"
})
public class FindAllCustomStructuresResponse {

    @XmlElement(name = "return", namespace = "http://brandmaker.com/webservices/dse/v2/")
    protected CustomStructureList _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link CustomStructureList }
     *     
     */
    public CustomStructureList getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomStructureList }
     *     
     */
    public void setReturn(CustomStructureList value) {
        this._return = value;
    }

}
