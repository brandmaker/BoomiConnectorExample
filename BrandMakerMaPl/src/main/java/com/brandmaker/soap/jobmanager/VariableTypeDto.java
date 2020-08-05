
package com.brandmaker.soap.jobmanager;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for variableTypeDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="variableTypeDto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="controllerVariableValues" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="customObject" type="{http://brandmaker.com/webservices/dse/v2/}customObjectDto" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gridColumns" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="column" type="{http://brandmaker.com/webservices/dse/v2/}variableTypeDto" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="defaultValues" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="defaultValue" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="prefilling" type="{http://brandmaker.com/webservices/dse/v2/}prefillingDto" minOccurs="0"/>
 *         &lt;element name="datasource" type="{http://brandmaker.com/webservices/dse/v2/}datasourceDto" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="uniqueName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="technicalName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="label" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="controllerVariableTypeId" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="typeName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "variableTypeDto", propOrder = {
    "controllerVariableValues",
    "gridColumns",
    "defaultValues",
    "prefilling",
    "datasource"
})
public class VariableTypeDto {

    protected VariableTypeDto.ControllerVariableValues controllerVariableValues;
    protected VariableTypeDto.GridColumns gridColumns;
    protected VariableTypeDto.DefaultValues defaultValues;
    protected PrefillingDto prefilling;
    protected DatasourceDto datasource;
    @XmlAttribute(name = "id")
    protected Integer id;
    @XmlAttribute(name = "uniqueName")
    protected String uniqueName;
    @XmlAttribute(name = "technicalName")
    protected String technicalName;
    @XmlAttribute(name = "label")
    protected String label;
    @XmlAttribute(name = "controllerVariableTypeId")
    protected Integer controllerVariableTypeId;
    @XmlAttribute(name = "typeName")
    protected String typeName;

    /**
     * Gets the value of the controllerVariableValues property.
     * 
     * @return
     *     possible object is
     *     {@link VariableTypeDto.ControllerVariableValues }
     *     
     */
    public VariableTypeDto.ControllerVariableValues getControllerVariableValues() {
        return controllerVariableValues;
    }

    /**
     * Sets the value of the controllerVariableValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link VariableTypeDto.ControllerVariableValues }
     *     
     */
    public void setControllerVariableValues(VariableTypeDto.ControllerVariableValues value) {
        this.controllerVariableValues = value;
    }

    /**
     * Gets the value of the gridColumns property.
     * 
     * @return
     *     possible object is
     *     {@link VariableTypeDto.GridColumns }
     *     
     */
    public VariableTypeDto.GridColumns getGridColumns() {
        return gridColumns;
    }

    /**
     * Sets the value of the gridColumns property.
     * 
     * @param value
     *     allowed object is
     *     {@link VariableTypeDto.GridColumns }
     *     
     */
    public void setGridColumns(VariableTypeDto.GridColumns value) {
        this.gridColumns = value;
    }

    /**
     * Gets the value of the defaultValues property.
     * 
     * @return
     *     possible object is
     *     {@link VariableTypeDto.DefaultValues }
     *     
     */
    public VariableTypeDto.DefaultValues getDefaultValues() {
        return defaultValues;
    }

    /**
     * Sets the value of the defaultValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link VariableTypeDto.DefaultValues }
     *     
     */
    public void setDefaultValues(VariableTypeDto.DefaultValues value) {
        this.defaultValues = value;
    }

    /**
     * Gets the value of the prefilling property.
     * 
     * @return
     *     possible object is
     *     {@link PrefillingDto }
     *     
     */
    public PrefillingDto getPrefilling() {
        return prefilling;
    }

    /**
     * Sets the value of the prefilling property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrefillingDto }
     *     
     */
    public void setPrefilling(PrefillingDto value) {
        this.prefilling = value;
    }

    /**
     * Gets the value of the datasource property.
     * 
     * @return
     *     possible object is
     *     {@link DatasourceDto }
     *     
     */
    public DatasourceDto getDatasource() {
        return datasource;
    }

    /**
     * Sets the value of the datasource property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatasourceDto }
     *     
     */
    public void setDatasource(DatasourceDto value) {
        this.datasource = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the uniqueName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUniqueName() {
        return uniqueName;
    }

    /**
     * Sets the value of the uniqueName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUniqueName(String value) {
        this.uniqueName = value;
    }

    /**
     * Gets the value of the technicalName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTechnicalName() {
        return technicalName;
    }

    /**
     * Sets the value of the technicalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTechnicalName(String value) {
        this.technicalName = value;
    }

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Gets the value of the controllerVariableTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getControllerVariableTypeId() {
        return controllerVariableTypeId;
    }

    /**
     * Sets the value of the controllerVariableTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setControllerVariableTypeId(Integer value) {
        this.controllerVariableTypeId = value;
    }

    /**
     * Gets the value of the typeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Sets the value of the typeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeName(String value) {
        this.typeName = value;
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
     *         &lt;element name="customObject" type="{http://brandmaker.com/webservices/dse/v2/}customObjectDto" maxOccurs="unbounded" minOccurs="0"/>
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
        "customObject"
    })
    public static class ControllerVariableValues {

        protected List<CustomObjectDto> customObject;

        /**
         * Gets the value of the customObject property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the customObject property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCustomObject().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CustomObjectDto }
         * 
         * 
         */
        public List<CustomObjectDto> getCustomObject() {
            if (customObject == null) {
                customObject = new ArrayList<CustomObjectDto>();
            }
            return this.customObject;
        }

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
     *         &lt;element name="defaultValue" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "defaultValue"
    })
    public static class DefaultValues {

        protected List<String> defaultValue;

        /**
         * Gets the value of the defaultValue property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the defaultValue property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDefaultValue().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getDefaultValue() {
            if (defaultValue == null) {
                defaultValue = new ArrayList<String>();
            }
            return this.defaultValue;
        }

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
     *         &lt;element name="column" type="{http://brandmaker.com/webservices/dse/v2/}variableTypeDto" maxOccurs="unbounded" minOccurs="0"/>
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
        "column"
    })
    public static class GridColumns {

        protected List<VariableTypeDto> column;

        /**
         * Gets the value of the column property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the column property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getColumn().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link VariableTypeDto }
         * 
         * 
         */
        public List<VariableTypeDto> getColumn() {
            if (column == null) {
                column = new ArrayList<VariableTypeDto>();
            }
            return this.column;
        }

    }

}
