package main.com.gen;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "beerItem"
})
@XmlRootElement(name = "Beer")
public class Beer {

    @XmlElement(name = "BeerItem", required = true)
    protected List<BeerItemType> beerItem;

    public List<BeerItemType> getBeerItem() {
        if (beerItem == null) {
            beerItem = new ArrayList<>();
        }
        return this.beerItem;
    }

}
