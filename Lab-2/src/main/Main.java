package main;

import com.beer.model.BeerItemType;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<BeerItemType> beers = new DomBeerParser().parse("src/main/resources/beer.xml", "src/main/resources/beer.xsd");
        beers.sort(Comparator.comparing(beer -> (beer.getChars() != null && beer.getChars().getAlcoholContent() != null) ? beer.getChars().getAlcoholContent() : 0));
        beers.forEach(b -> System.out.println(b.getName()));
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer(new StreamSource(new File("src/main/resources/beerGroupByType.xsl")));
        transformer.transform(new StreamSource(new File("src/main/resources/beer.xml")), new StreamResult(new File("src/main/resources/new.xml")));
    }
}