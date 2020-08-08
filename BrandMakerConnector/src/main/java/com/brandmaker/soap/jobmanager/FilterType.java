
package com.brandmaker.soap.jobmanager;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for filterType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="filterType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Standard"/>
 *     &lt;enumeration value="Private"/>
 *     &lt;enumeration value="Public"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "filterType")
@XmlEnum
public enum FilterType {

    @XmlEnumValue("Standard")
    STANDARD("Standard"),
    @XmlEnumValue("Private")
    PRIVATE("Private"),
    @XmlEnumValue("Public")
    PUBLIC("Public");
    private final String value;

    FilterType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FilterType fromValue(String v) {
        for (FilterType c: FilterType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
