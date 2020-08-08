
package com.brandmaker.soap.jobmanager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateGrid complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateGrid">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="gridVariableTypeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="dseObjectId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="localeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="grid" type="{http://brandmaker.com/webservices/dse/v2/}gridDto" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateGrid", propOrder = {
    "gridVariableTypeId",
    "dseObjectId",
    "localeId",
    "grid"
})
public class UpdateGrid {

    protected Integer gridVariableTypeId;
    protected Integer dseObjectId;
    protected Integer localeId;
    @XmlElement(namespace = "http://brandmaker.com/webservices/dse/v2/")
    protected GridDto grid;

    /**
     * Gets the value of the gridVariableTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGridVariableTypeId() {
        return gridVariableTypeId;
    }

    /**
     * Sets the value of the gridVariableTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGridVariableTypeId(Integer value) {
        this.gridVariableTypeId = value;
    }

    /**
     * Gets the value of the dseObjectId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDseObjectId() {
        return dseObjectId;
    }

    /**
     * Sets the value of the dseObjectId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDseObjectId(Integer value) {
        this.dseObjectId = value;
    }

    /**
     * Gets the value of the localeId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLocaleId() {
        return localeId;
    }

    /**
     * Sets the value of the localeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLocaleId(Integer value) {
        this.localeId = value;
    }

    /**
     * Gets the value of the grid property.
     * 
     * @return
     *     possible object is
     *     {@link GridDto }
     *     
     */
    public GridDto getGrid() {
        return grid;
    }

    /**
     * Sets the value of the grid property.
     * 
     * @param value
     *     allowed object is
     *     {@link GridDto }
     *     
     */
    public void setGrid(GridDto value) {
        this.grid = value;
    }

}
