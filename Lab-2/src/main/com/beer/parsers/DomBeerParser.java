package main.com.beer.parsers;



import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import main.com.beer.BeerValidator;
import main.com.gen.Beer;
import main.com.gen.BeerItemType;

import java.io.File;
import java.util.List;

public class DomBeerParser {
    public List<BeerItemType> parse(String filePath, String xsdPath) throws Exception {
        BeerValidator.validate(filePath, xsdPath);
        JAXBContext context = JAXBContext.newInstance(Beer.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Beer beer = (Beer) unmarshaller.unmarshal(new File(filePath));
        return beer.getBeerItem();
    }
}
