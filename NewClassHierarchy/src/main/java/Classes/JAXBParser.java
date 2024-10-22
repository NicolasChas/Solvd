package Classes;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBParser {
    public Products jaxbParser(String xmlFilePath) throws JAXBException{
        JAXBContext content=JAXBContext.newInstance(Products.class);
        Unmarshaller unmarshaller=content.createUnmarshaller();

        File xmlFile=new File(xmlFilePath);

        return (Products)unmarshaller.unmarshal(xmlFile);
    }
}
