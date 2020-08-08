
package com.brandmaker.soap.jobmanager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for findByFilterUnique complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="findByFilterUnique">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="filter" type="{http://brandmaker.com/webservices/dse/v2/}filterDto" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findByFilterUnique", propOrder = {
    "filter"
})
public class FindByFilterUnique {

    @XmlElement(namespace = "http://brandmaker.com/webservices/dse/v2/")
    protected FilterDto filter;

    /**
     * Gets the value of the filter property.
     * 
     * @return
     *     possible object is
     *     {@link FilterDto }
     *     
     */
    public FilterDto getFilter() {
        return filter;
    }

    /**
     * Sets the value of the filter property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilterDto }
     *     
     */
    public void setFilter(FilterDto value) {
        this.filter = value;
    }

}
