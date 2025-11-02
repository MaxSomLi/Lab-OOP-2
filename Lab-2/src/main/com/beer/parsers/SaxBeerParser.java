package main.com.beer.parsers;


import main.com.beer.BeerValidator;
import main.com.gen.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class SaxBeerParser {

    public List<BeerItemType> parse(String filePath, String xsdPath) throws Exception {
        BeerValidator.validate(filePath, xsdPath);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);
        SAXParser saxParser = factory.newSAXParser();
        BeerHandler handler = new BeerHandler();
        saxParser.parse(new File(filePath), handler);
        return handler.getBeerList();
    }

    private static class BeerHandler extends DefaultHandler {
        private List<BeerItemType> beerList = new ArrayList<>();
        private BeerItemType beerItem;
        private IngredientsType ingredients;
        private CharsType chars;
        private PackagingType packaging;
        private StringBuilder currentValue = new StringBuilder();

        public List<BeerItemType> getBeerList() {
            return beerList;
        }

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentValue.setLength(0);
            switch (qName) {
                case "BeerItem" -> {
                    beerItem = new BeerItemType();
                    beerItem.setId(attributes.getValue("id"));
                    beerItem.setAl(YesNo.fromValue(attributes.getValue("Al")));
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

        @Override
        public void characters(char[] ch, int start, int length) {
            currentValue.append(ch, start, length);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            String value = currentValue.toString().trim();
            switch (qName) {
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
                case "Ingredients" -> {
                    beerItem.setIngredients(ingredients);
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
                case "Packaging" -> {
                    chars.setPackaging(packaging);
                }
                case "Chars" -> {
                    beerItem.setChars(chars);
                }
                case "BeerItem" -> {
                    beerList.add(beerItem);
                }
            }
        }
    }
}

