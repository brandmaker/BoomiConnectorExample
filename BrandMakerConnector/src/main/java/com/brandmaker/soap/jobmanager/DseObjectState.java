
package com.brandmaker.soap.jobmanager;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dseObjectState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="dseObjectState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ACTIVE"/>
 *     &lt;enumeration value="CANCELED"/>
 *     &lt;enumeration value="DELETED"/>
 *     &lt;enumeration value="FINISHED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "dseObjectState")
@XmlEnum
public enum DseObjectState {

    ACTIVE,
    CANCELED,
    DELETED,
    FINISHED;

    public String value() {
        return name();
    }

    public static DseObjectState fromValue(String v) {
        return valueOf(v);
    }

}
