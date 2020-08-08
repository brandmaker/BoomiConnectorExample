
package com.brandmaker.soap.jobmanager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createV2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createV2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="data" type="{http://brandmaker.com/webservices/dse/v2/}descriptionDto" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createV2", propOrder = {
    "data"
})
public class CreateV2 {

    @XmlElement(namespace = "http://brandmaker.com/webservices/dse/v2/")
    protected DescriptionDto data;

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link DescriptionDto }
     *     
     */
    public DescriptionDto getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link DescriptionDto }
     *     
     */
    public void setData(DescriptionDto value) {
        this.data = value;
    }

}
