package main.com.gen;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;



@XmlType(name = "BeerType")
@XmlEnum
public enum BeerType {

    @XmlEnumValue("Темне")
    TEMNE("Темне"),

    @XmlEnumValue("Світле")
    SVITLE("Світле"),

    @XmlEnumValue("Лагерне")
    LAGERNE("Лагерне"),

    @XmlEnumValue("Живе")
    ZHYVE("Живе");

    private final String value;

    BeerType(String v) {
        value = v;
    }

    /**
     * Gets the value associated to the enum constant.
     * 
     * @return
     *     The value linked to the enum.
     */
    public String value() {
        return value;
    }

    /**
     * Gets the enum associated to the value passed as parameter.
     * 
     * @param v
     *     The value to get the enum from.
     * @return
     *     The enum which corresponds to the value, if it exists.
     * @throws IllegalArgumentException
     *     If no value matches in the enum declaration.
     */
    public static BeerType fromValue(String v) {
        for (BeerType c: BeerType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
