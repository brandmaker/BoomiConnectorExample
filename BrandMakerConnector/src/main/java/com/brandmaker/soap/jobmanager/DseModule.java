
package com.brandmaker.soap.jobmanager;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dseModule.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="dseModule">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Job"/>
 *     &lt;enumeration value="Product"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "dseModule")
@XmlEnum
public enum DseModule {

    @XmlEnumValue("Job")
    JOB("Job"),
    @XmlEnumValue("Product")
    PRODUCT("Product");
    private final String value;

    DseModule(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DseModule fromValue(String v) {
        for (DseModule c: DseModule.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
