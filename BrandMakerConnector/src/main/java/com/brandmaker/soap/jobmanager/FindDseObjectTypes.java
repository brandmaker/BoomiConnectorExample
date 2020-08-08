
package com.brandmaker.soap.jobmanager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for findDseObjectTypes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="findDseObjectTypes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dseModule" type="{http://brandmaker.com/webservices/dse/v2/}dseModule" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findDseObjectTypes", propOrder = {
    "dseModule"
})
public class FindDseObjectTypes {

    @XmlSchemaType(name = "string")
    protected DseModule dseModule;

    /**
     * Gets the value of the dseModule property.
     * 
     * @return
     *     possible object is
     *     {@link DseModule }
     *     
     */
    public DseModule getDseModule() {
        return dseModule;
    }

    /**
     * Sets the value of the dseModule property.
     * 
     * @param value
     *     allowed object is
     *     {@link DseModule }
     *     
     */
    public void setDseModule(DseModule value) {
        this.dseModule = value;
    }

}
