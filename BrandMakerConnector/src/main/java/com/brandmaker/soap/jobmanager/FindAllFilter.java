
package com.brandmaker.soap.jobmanager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for findAllFilter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="findAllFilter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="topicName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findAllFilter", propOrder = {
    "topicName"
})
public class FindAllFilter {

    protected String topicName;

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

}
