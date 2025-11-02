package main.com.gen;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CharsType", propOrder = {
    "alcoholContent",
    "transparency",
    "filtered",
    "calories",
    "packaging"
})
public class CharsType {

    @XmlElement(name = "AlcoholContent")
    protected Float alcoholContent;
    @XmlElement(name = "Transparency", type = Float.class)
    protected float transparency;
    @XmlElement(name = "Filtered")
    protected boolean filtered;
    @XmlElement(name = "Calories")
    protected Float calories;
    @XmlElement(name = "Packaging", required = true)
    protected PackagingType packaging;

    public Float getAlcoholContent() {
        return alcoholContent;
    }

    public void setAlcoholContent(Float value) {
        this.alcoholContent = value;
    }

    public float getTransparency() {
        return this.transparency;
    }

    public boolean isFiltered() {
        return filtered;
    }

    public void setFiltered(boolean value) {
        this.filtered = value;
    }

    public Float getCalories() {
        return calories;
    }

    public void setCalories(Float value) {
        this.calories = value;
    }

    public PackagingType getPackaging() {
        return packaging;
    }

    public void setPackaging(PackagingType value) {
        this.packaging = value;
    }

    public void setTransparency(float v) {
        this.transparency = v;
    }
}
