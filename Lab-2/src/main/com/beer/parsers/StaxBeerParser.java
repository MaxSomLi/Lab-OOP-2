package main.com.beer.parsers;

import main.com.beer.BeerValidator;
import main.com.gen.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.*;

public class StaxBeerParser {

    public List<BeerItemType> parse(String filePath, String xsdPath) throws Exception {
        BeerValidator.validate(filePath, xsdPath);
        List<BeerItemType> beerList = new ArrayList<>();
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(filePath));
        BeerItemType beerItem = null;
        IngredientsType ingredients = null;
        CharsType chars = null;
        PackagingType packaging = null;
        String currentElement = null;
        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT -> {
                    currentElement = reader.getLocalName();
                    switch (currentElement) {
                        case "BeerItem" -> {
                            beerItem = new BeerItemType();
                            beerItem.setId(reader.getAttributeValue(null, "id"));
                            beerItem.setAl(YesNo.fromValue(reader.getAttributeValue(null, "Al")));
                        }
                        case "Ingredients" -> {
                            ingredients = new IngredientsType();
                        }
                        case "Chars" -> {
                            chars = new CharsType();
                        }
                        case "Packaging" -> {
                            packaging = new PackagingType();
                        }
                    }
                }
                case XMLStreamConstants.CHARACTERS -> {
                    if (beerItem == null) {
                        continue;
                    }
                    String value = reader.getText().trim();
                    if (value.isEmpty()) {
                        continue;
                    }
                    switch (currentElement) {
                        case "Name" -> {
                            beerItem.setName(value);
                        }
                        case "Type" -> {
                            beerItem.setType(BeerType.fromValue(value));
                        }
                        case "Manufacturer" -> {
                            beerItem.setManufacturer(value);
                        }
                        case "Ingredient" -> {
                            ingredients.getIngredient().add(IngredientEnumType.fromValue(value));
                        }
                        case "AlcoholContent" -> {
                            chars.setAlcoholContent(Float.parseFloat(value));
                        }
                        case "Transparency" -> {
                            chars.setTransparency(Float.parseFloat(value));
                        }
                        case "Filtered" -> {
                            chars.setFiltered(Boolean.parseBoolean(value));
                        }
                        case "Calories" -> {
                            chars.setCalories(Float.parseFloat(value));
                        }
                        case "Volume" -> {
                            packaging.setVolume(Float.parseFloat(value));
                        }
                        case "Material" -> {
                            packaging.setMaterial(value);
                        }
                    }
                }
                case XMLStreamConstants.END_ELEMENT -> {
                    String endElement = reader.getLocalName();
                    switch (endElement) {
                        case "Packaging" -> {
                            chars.setPackaging(packaging);
                        }
                        case "Chars" -> {
                            beerItem.setChars(chars);
                        }
                        case "Ingredients" -> {
                            beerItem.setIngredients(ingredients);
                        }
                        case "BeerItem" -> {
                            beerList.add(beerItem);
                        }
                    }
                    currentElement = null;
                }
            }
        }
        reader.close();
        return beerList;
    }
}
