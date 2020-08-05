
package com.brandmaker.soap.jobmanager;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dseObjectTypeList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dseObjectTypeList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dseObjectTypes" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="dseObjectType" type="{http://brandmaker.com/webservices/dse/v2/}dseObjectTypeDto" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "dseObjectTypeList", propOrder = {
    "dseObjectTypes"
})
public class DseObjectTypeList {

    protected DseObjectTypeList.DseObjectTypes dseObjectTypes;

    /**
     * Gets the value of the dseObjectTypes property.
     * 
     * @return
     *     possible object is
     *     {@link DseObjectTypeList.DseObjectTypes }
     *     
     */
    public DseObjectTypeList.DseObjectTypes getDseObjectTypes() {
        return dseObjectTypes;
    }

    /**
     * Sets the value of the dseObjectTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link DseObjectTypeList.DseObjectTypes }
     *     
     */
    public void setDseObjectTypes(DseObjectTypeList.DseObjectTypes value) {
        this.dseObjectTypes = value;
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
     *         &lt;element name="dseObjectType" type="{http://brandmaker.com/webservices/dse/v2/}dseObjectTypeDto" maxOccurs="unbounded" minOccurs="0"/>
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
        "dseObjectType"
    })
    public static class DseObjectTypes {

        protected List<DseObjectTypeDto> dseObjectType;

        /**
         * Gets the value of the dseObjectType property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the dseObjectType property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDseObjectType().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DseObjectTypeDto }
         * 
         * 
         */
        public List<DseObjectTypeDto> getDseObjectType() {
            if (dseObjectType == null) {
                dseObjectType = new ArrayList<DseObjectTypeDto>();
            }
            return this.dseObjectType;
        }

    }

}
