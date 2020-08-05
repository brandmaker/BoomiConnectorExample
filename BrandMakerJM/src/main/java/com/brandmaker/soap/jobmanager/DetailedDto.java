
package com.brandmaker.soap.jobmanager;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for detailedDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="detailedDto">
 *   &lt;complexContent>
 *     &lt;extension base="{http://brandmaker.com/webservices/dse/v2/}descriptionDto">
 *       &lt;sequence>
 *         &lt;element name="assignees" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subJobs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="variables" type="{http://brandmaker.com/webservices/dse/v2/}detailedVariableDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detailedDto", propOrder = {
    "assignees",
    "subJobs",
    "variables"
})
public class DetailedDto
    extends DescriptionDto
{

    protected String assignees;
    protected String subJobs;
    @XmlElement(nillable = true)
    protected List<DetailedVariableDto> variables;

    /**
     * Gets the value of the assignees property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssignees() {
        return assignees;
    }

    /**
     * Sets the value of the assignees property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssignees(String value) {
        this.assignees = value;
    }

    /**
     * Gets the value of the subJobs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubJobs() {
        return subJobs;
    }

    /**
     * Sets the value of the subJobs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubJobs(String value) {
        this.subJobs = value;
    }

    /**
     * Gets the value of the variables property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the variables property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVariables().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DetailedVariableDto }
     * 
     * 
     */
    public List<DetailedVariableDto> getVariables() {
        if (variables == null) {
            variables = new ArrayList<DetailedVariableDto>();
        }
        return this.variables;
    }

}
