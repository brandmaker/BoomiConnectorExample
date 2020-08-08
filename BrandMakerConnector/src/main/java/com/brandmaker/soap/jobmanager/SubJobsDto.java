
package com.brandmaker.soap.jobmanager;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for subJobsDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="subJobsDto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="subJob" type="{http://brandmaker.com/webservices/dse/v2/}descriptionDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subJobsDto", propOrder = {
    "subJob"
})
public class SubJobsDto {

    @XmlElement(nillable = true)
    protected List<DescriptionDto> subJob;

    /**
     * Gets the value of the subJob property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subJob property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubJob().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DescriptionDto }
     * 
     * 
     */
    public List<DescriptionDto> getSubJob() {
        if (subJob == null) {
            subJob = new ArrayList<DescriptionDto>();
        }
        return this.subJob;
    }

}
