
package com.brandmaker.soap.jobmanager;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for variableHistoryResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="variableHistoryResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://brandmaker.com/webservices/dse/v2/}result">
 *       &lt;sequence>
 *         &lt;element name="descriptions" type="{http://brandmaker.com/webservices/dse/v2/}variableHistoryDescription" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "variableHistoryResult", propOrder = {
    "descriptions"
})
public class VariableHistoryResult
    extends Result
{

    @XmlElement(nillable = true)
    protected List<VariableHistoryDescription> descriptions;

    /**
     * Gets the value of the descriptions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the descriptions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDescriptions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VariableHistoryDescription }
     * 
     * 
     */
    public List<VariableHistoryDescription> getDescriptions() {
        if (descriptions == null) {
            descriptions = new ArrayList<VariableHistoryDescription>();
        }
        return this.descriptions;
    }

}
