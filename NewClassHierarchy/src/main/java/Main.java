import Classes.*;
import Classes.Interfaces.GenericDAO;
import org.apache.logging.log4j.LogManager;

import javax.sql.DataSource;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.sql.SQLException;

public class Main {
    public static org.apache.logging.log4j.Logger logger;
    public static void main(String[] args) {
        File log4jfile =new File("C:\\Users\\Nicolás\\Desktop\\Java\\Solvd\\NewClassHierarchy\\src\\main\\java\\log4j2.properties");
        System.setProperty("log4j2.configurationFile",log4jfile.toURI().toString());
        logger=LogManager.getLogger(Main.class);

        DataSource dataSource = ConnectionPool.getDataSource();
        GenericDAO<Product, Integer> ProductDAO = new ProductDAO(dataSource);
        ServiceLayer serviceLayer=new ServiceLayer(ProductDAO);
        try{
            String path="C:\\Users\\Nicolás\\Desktop\\Java\\Solvd\\NewClassHierarchy\\src\\main\\resources\\Products.xml";
            XMLParser parser= new XMLParser();
            parser.parseXML(path);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JAXBParser parser = new JAXBParser();
        try {
            Products productsXML = parser.jaxbParser("C:\\Users\\Nicolás\\Desktop\\Java\\Solvd\\NewClassHierarchy\\src\\main\\resources\\Products.xml");
            logger.info("Product list from XML File:");
            for (Product product : productsXML.getProducts()) {
                logger.info(product);
            }
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        
        try{
            Product product=new Product(23,"Dairy",23);
            serviceLayer.addProduct(product);

            Product retrievedProduct = serviceLayer.getProductById(23);
            if (retrievedProduct != null) {
                logger.info("Product: "+retrievedProduct.getName()+" Price: "+retrievedProduct.getPrice());
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
