package main.tests;

import com.beer.model.BeerItemType;
import main.DomBeerParser;
import org.junit.jupiter.api.*;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    static List<BeerItemType> beers;

    @BeforeAll
    static void setUp() throws Exception {
        beers = new DomBeerParser().parse("src/main/resources/beer.xml","src/main/resources/beer.xsd");
    }

    @Test
    void testXmlParsedCorrectly() {
        assertNotNull(beers);
        assertFalse(beers.isEmpty(), "Beer list should not be empty");
    }

    @Test
    void testXsltTransformationCreatesFile() throws Exception {
        File xslt = new File("src/main/resources/beerGroupByType.xsl");
        File input = new File("src/main/resources/beer.xml");
        File output = new File("src/main/resources/new.xml");

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(new StreamSource(xslt));
        transformer.transform(new StreamSource(input), new StreamResult(output));

        assertTrue(output.exists(), "XSLT output file should exist");
        assertTrue(output.length() > 0, "XSLT output file should not be empty");
    }
}
