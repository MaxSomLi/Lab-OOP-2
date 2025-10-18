package main;

import com.beer.model.Beer;
import com.beer.model.BeerItemType;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

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
