package main.com.gen;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;



@XmlType(name = "IngredientEnumType")
@XmlEnum
public enum IngredientEnumType {

    @XmlEnumValue("Вода")
    VODA("Вода"),

    @XmlEnumValue("Хміль")
    HMIL("Хміль"),

    @XmlEnumValue("Солод")
    SOLOД("Солод"),

    @XmlEnumValue("Цукор")
    CUKOR("Цукор");

    private final String value;

    IngredientEnumType(String v) {
        value = v;
    }


    public String value() {
        return value;
    }

    public static IngredientEnumType fromValue(String v) {
        for (IngredientEnumType c: IngredientEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
