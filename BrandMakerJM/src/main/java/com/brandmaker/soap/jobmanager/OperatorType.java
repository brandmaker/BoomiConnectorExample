
package com.brandmaker.soap.jobmanager;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for operatorType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="operatorType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EQUAL"/>
 *     &lt;enumeration value="NOT_EQUAL"/>
 *     &lt;enumeration value="INCLUDES"/>
 *     &lt;enumeration value="EXCLUDES"/>
 *     &lt;enumeration value="STARTS"/>
 *     &lt;enumeration value="STARTS_NOT"/>
 *     &lt;enumeration value="ENDS"/>
 *     &lt;enumeration value="ENDS_NOT"/>
 *     &lt;enumeration value="GREATER"/>
 *     &lt;enumeration value="GREATER_OR_EQ"/>
 *     &lt;enumeration value="LESS"/>
 *     &lt;enumeration value="LESS_OR_EQ"/>
 *     &lt;enumeration value="TIME_SPAN_FROM_NOW"/>
 *     &lt;enumeration value="WORKFLOW_STEP_NAME_EQ"/>
 *     &lt;enumeration value="WORKFLOW_STEP_NAME_NOT_EQ"/>
 *     &lt;enumeration value="CSV_EQUAL"/>
 *     &lt;enumeration value="CSV_NOT_EQUAL"/>
 *     &lt;enumeration value="CSV_INCLUDES"/>
 *     &lt;enumeration value="CSV_EXCLUDES"/>
 *     &lt;enumeration value="IN"/>
 *     &lt;enumeration value="NUMERIC_EQUAL"/>
 *     &lt;enumeration value="NUMERIC_NOT_EQUAL"/>
 *     &lt;enumeration value="NUMERIC_GREATER"/>
 *     &lt;enumeration value="NUMERIC_GREATER_OR_EQ"/>
 *     &lt;enumeration value="NUMERIC_LESS"/>
 *     &lt;enumeration value="NUMERIC_LESS_OR_EQ"/>
 *     &lt;enumeration value="ALL_GRID_ROWS_NOT_EQUAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "operatorType")
@XmlEnum
public enum OperatorType {

    EQUAL,
    NOT_EQUAL,
    INCLUDES,
    EXCLUDES,
    STARTS,
    STARTS_NOT,
    ENDS,
    ENDS_NOT,
    GREATER,
    GREATER_OR_EQ,
    LESS,
    LESS_OR_EQ,
    TIME_SPAN_FROM_NOW,
    WORKFLOW_STEP_NAME_EQ,
    WORKFLOW_STEP_NAME_NOT_EQ,
    CSV_EQUAL,
    CSV_NOT_EQUAL,
    CSV_INCLUDES,
    CSV_EXCLUDES,
    IN,
    NUMERIC_EQUAL,
    NUMERIC_NOT_EQUAL,
    NUMERIC_GREATER,
    NUMERIC_GREATER_OR_EQ,
    NUMERIC_LESS,
    NUMERIC_LESS_OR_EQ,
    ALL_GRID_ROWS_NOT_EQUAL;

    public String value() {
        return name();
    }

    public static OperatorType fromValue(String v) {
        return valueOf(v);
    }

}
