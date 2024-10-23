package Classes;

import com.fasterxml.jackson.annotation.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@JsonSubTypes({
        @JsonSubTypes.Type(value = Meat.class, name = "Meat"),
        @JsonSubTypes.Type(value = Vegetables.class, name = "Vegetables")
})
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

@XmlType(propOrder = { "idProduct", "name", "price" })
@XmlSeeAlso({Meat.class, Vegetables.class})
public class Product {
    @JsonProperty("idProduct")
    private int idProduct;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Price")
    private int price;

    public Product(){}

    public Product(int idProduct,String name, int price){
        this.idProduct=idProduct;
        this.name=name;
        this.price=price;
    }
    @XmlElement(name = "idProduct")
    public int getIdProduct() { return idProduct; }

    public void setIdProduct(int idProduct) { this.idProduct = idProduct; }
    @XmlElement(name = "Name")
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
    @XmlElement(name = "Price")
    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }

    @Override
    public String toString() {
        return "Product: id= " + idProduct + ", type= " + name + ", price= " + price + ".";
    }
}
