
package com.brandmaker.soap.jobmanager;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for findByFilter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="findByFilter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="filter" type="{http://brandmaker.com/webservices/dse/v2/}filterDto" minOccurs="0" form="qualified"/>
 *         &lt;element name="searchTerm" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="includeSubJobs" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="localeId" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findByFilter", propOrder = {
    "filter",
    "searchTerm",
    "includeSubJobs",
    "localeId"
})
public class FindByFilter {

    @XmlElement(namespace = "http://brandmaker.com/webservices/dse/v2/")
    protected FilterDto filter;
    protected List<String> searchTerm;
    protected boolean includeSubJobs;
    @XmlElement(type = Integer.class)
    protected List<Integer> localeId;

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

    /**
     * Gets the value of the searchTerm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the searchTerm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSearchTerm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSearchTerm() {
        if (searchTerm == null) {
            searchTerm = new ArrayList<String>();
        }
        return this.searchTerm;
    }

    /**
     * Gets the value of the includeSubJobs property.
     * 
     */
    public boolean isIncludeSubJobs() {
        return includeSubJobs;
    }

    /**
     * Sets the value of the includeSubJobs property.
     * 
     */
    public void setIncludeSubJobs(boolean value) {
        this.includeSubJobs = value;
    }

    /**
     * Gets the value of the localeId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the localeId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocaleId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getLocaleId() {
        if (localeId == null) {
            localeId = new ArrayList<Integer>();
        }
        return this.localeId;
    }

}
