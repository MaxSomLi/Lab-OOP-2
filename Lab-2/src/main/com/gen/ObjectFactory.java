package main.com.gen;

import jakarta.xml.bind.annotation.XmlRegistry;


@XmlRegistry
public class ObjectFactory {

    public Beer createBeer() {
        return new Beer();
    }

    public BeerItemType createBeerItemType() {
        return new BeerItemType();
    }

    public PackagingType createPackagingType() {
        return new PackagingType();
    }

    public CharsType createCharsType() {
        return new CharsType();
    }

    public IngredientsType createIngredientsType() {
        return new IngredientsType();
    }

}
