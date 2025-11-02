package main.com.gen;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PackagingType", propOrder = {
    "volume",
    "material"
})
public class PackagingType {

    @XmlElement(name = "Volume")
    protected Float volume;
    @XmlElement(name = "Material", required = true)
    protected String material;


    public Float getVolume() {
        return volume;
    }

    public void setVolume(Float value) {
        this.volume = value;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String value) {
        this.material = value;
    }

}
