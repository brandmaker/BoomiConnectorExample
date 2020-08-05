
package com.brandmaker.soap.jobmanager;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for detailedList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="detailedList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://brandmaker.com/webservices/dse/v2/}result">
 *       &lt;sequence>
 *         &lt;element name="desriptions" type="{http://brandmaker.com/webservices/dse/v2/}detailedDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detailedList", propOrder = {
    "desriptions"
})
public class DetailedList
    extends Result
{

    @XmlElement(nillable = true)
    protected List<DetailedDto> desriptions;

    /**
     * Gets the value of the desriptions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the desriptions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDesriptions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DetailedDto }
     * 
     * 
     */
    public List<DetailedDto> getDesriptions() {
        if (desriptions == null) {
            desriptions = new ArrayList<DetailedDto>();
        }
        return this.desriptions;
    }

}
