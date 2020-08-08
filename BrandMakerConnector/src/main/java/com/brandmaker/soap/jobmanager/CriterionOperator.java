
package com.brandmaker.soap.jobmanager;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for criterionOperator.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="criterionOperator">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AND"/>
 *     &lt;enumeration value="OR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "criterionOperator")
@XmlEnum
public enum CriterionOperator {

    AND,
    OR;

    public String value() {
        return name();
    }

    public static CriterionOperator fromValue(String v) {
        return valueOf(v);
    }

}
