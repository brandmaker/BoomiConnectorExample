
package com.brandmaker.soap.jobmanager;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for variableTypeList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="variableTypeList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="variableTypes" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="variableType" type="{http://brandmaker.com/webservices/dse/v2/}variableTypeDto" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "variableTypeList", propOrder = {
    "variableTypes"
})
public class VariableTypeList {

    protected VariableTypeList.VariableTypes variableTypes;

    /**
     * Gets the value of the variableTypes property.
     * 
     * @return
     *     possible object is
     *     {@link VariableTypeList.VariableTypes }
     *     
     */
    public VariableTypeList.VariableTypes getVariableTypes() {
        return variableTypes;
    }

    /**
     * Sets the value of the variableTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link VariableTypeList.VariableTypes }
     *     
     */
    public void setVariableTypes(VariableTypeList.VariableTypes value) {
        this.variableTypes = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="variableType" type="{http://brandmaker.com/webservices/dse/v2/}variableTypeDto" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "variableType"
    })
    public static class VariableTypes {

        protected List<VariableTypeDto> variableType;

        /**
         * Gets the value of the variableType property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the variableType property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getVariableType().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link VariableTypeDto }
         * 
         * 
         */
        public List<VariableTypeDto> getVariableType() {
            if (variableType == null) {
                variableType = new ArrayList<VariableTypeDto>();
            }
            return this.variableType;
        }

    }

}
