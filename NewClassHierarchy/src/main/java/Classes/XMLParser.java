package Classes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLParser {
    public void parseXML(String filePath){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = factory.newDocumentBuilder();
            Document doc= docBuilder.parse(new File(filePath));
            doc.getDocumentElement().normalize();

            Element element=doc.getDocumentElement();

            NodeList productList=doc.getElementsByTagName("Product");
            System.out.println("Root element is: " + element.getTagName());

            for(int i=0;i<productList.getLength();i++){
                Node nProduct=productList.item(i);
                if(nProduct.getNodeType()==Node.ELEMENT_NODE){
                    Element elementProduct=(Element) nProduct;
                    System.out.println("\nProduct id:"+elementProduct.getElementsByTagName("idProduct").item(0).getTextContent());
                    System.out.println("Product type:"+elementProduct.getElementsByTagName("Name").item(0).getTextContent());
                    System.out.println("Product price:"+elementProduct.getElementsByTagName("Price").item(0).getTextContent());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
