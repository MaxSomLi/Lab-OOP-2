package main.com.gen;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BeerItemType", propOrder = {
    "name",
    "type",
    "manufacturer",
    "ingredients",
    "chars"
})
public class BeerItemType {

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Type", required = true)
    @XmlSchemaType(name = "string")
    protected BeerType type;
    @XmlElement(name = "Manufacturer", required = true)
    protected String manufacturer;
    @XmlElement(name = "Ingredients", required = true)
    protected IngredientsType ingredients;
    @XmlElement(name = "Chars", required = true)
    protected CharsType chars;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "Al", required = true)
    protected YesNo al;


    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public BeerType getType() {
        return type;
    }

    public void setType(BeerType value) {
        this.type = value;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String value) {
        this.manufacturer = value;
    }

    public IngredientsType getIngredients() {
        return ingredients;
    }

    public void setIngredients(IngredientsType value) {
        this.ingredients = value;
    }

    public CharsType getChars() {
        return chars;
    }

    public void setChars(CharsType value) {
        this.chars = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public YesNo getAl() {
        return al;
    }

    public void setAl(YesNo value) {
        this.al = value;
    }

}
