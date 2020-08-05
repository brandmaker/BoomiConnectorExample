
package com.brandmaker.soap.jobmanager;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for filtersList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="filtersList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://brandmaker.com/webservices/dse/v2/}result">
 *       &lt;sequence>
 *         &lt;element name="savedFilter" type="{http://brandmaker.com/webservices/dse/v2/}savedFilterDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "filtersList", propOrder = {
    "savedFilter"
})
public class FiltersList
    extends Result
{

    @XmlElement(nillable = true)
    protected List<SavedFilterDto> savedFilter;

    /**
     * Gets the value of the savedFilter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the savedFilter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSavedFilter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SavedFilterDto }
     * 
     * 
     */
    public List<SavedFilterDto> getSavedFilter() {
        if (savedFilter == null) {
            savedFilter = new ArrayList<SavedFilterDto>();
        }
        return this.savedFilter;
    }

}
