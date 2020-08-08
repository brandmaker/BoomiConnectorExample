
package com.brandmaker.soap.jobmanager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getRejectCandidates complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getRejectCandidates">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dseInstanceId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="l10nLocaleId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getRejectCandidates", propOrder = {
    "dseInstanceId",
    "l10NLocaleId"
})
public class GetRejectCandidates {

    protected Integer dseInstanceId;
    @XmlElement(name = "l10nLocaleId")
    protected Integer l10NLocaleId;

    /**
     * Gets the value of the dseInstanceId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDseInstanceId() {
        return dseInstanceId;
    }

    /**
     * Sets the value of the dseInstanceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDseInstanceId(Integer value) {
        this.dseInstanceId = value;
    }

    /**
     * Gets the value of the l10NLocaleId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getL10NLocaleId() {
        return l10NLocaleId;
    }

    /**
     * Sets the value of the l10NLocaleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setL10NLocaleId(Integer value) {
        this.l10NLocaleId = value;
    }

}
