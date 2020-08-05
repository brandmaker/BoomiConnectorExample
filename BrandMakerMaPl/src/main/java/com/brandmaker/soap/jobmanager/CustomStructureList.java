
package com.brandmaker.soap.jobmanager;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for customStructureList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="customStructureList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://brandmaker.com/webservices/dse/v2/}result">
 *       &lt;sequence>
 *         &lt;element name="customStructures" type="{http://brandmaker.com/webservices/dse/v2/}customStructureDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customStructureList", propOrder = {
    "customStructures"
})
public class CustomStructureList
    extends Result
{

    @XmlElement(nillable = true)
    protected List<CustomStructureDto> customStructures;

    /**
     * Gets the value of the customStructures property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customStructures property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomStructures().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomStructureDto }
     * 
     * 
     */
    public List<CustomStructureDto> getCustomStructures() {
        if (customStructures == null) {
            customStructures = new ArrayList<CustomStructureDto>();
        }
        return this.customStructures;
    }

}
