package main.com.gen;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IngredientsType", propOrder = {
    "ingredient"
})
public class IngredientsType {

    @XmlElement(name = "Ingredient", required = true)
    @XmlSchemaType(name = "string")
    protected List<IngredientEnumType> ingredient;

    public List<IngredientEnumType> getIngredient() {
        if (ingredient == null) {
            ingredient = new ArrayList<>();
        }
        return this.ingredient;
    }

}
