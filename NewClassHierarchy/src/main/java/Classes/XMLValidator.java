package Classes;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XMLValidator {
    public static boolean validate(String xmlPath,String xsdPath){
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File("C:\\Users\\Nicolás\\Desktop\\Java\\Solvd\\NewClassHierarchy\\src\\main\\resources\\Products.xsd"));
            Validator validator= schema.newValidator();
            validator.validate(new StreamSource(new File("C:\\Users\\Nicolás\\Desktop\\Java\\Solvd\\NewClassHierarchy\\src\\main\\resources\\Products.xml")));
            return true;
        }catch(IOException| SAXException e){
            e.printStackTrace();
            return false;
        }
    }
}
