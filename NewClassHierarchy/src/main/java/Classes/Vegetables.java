package Classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Vegetable")
public class Vegetables extends Product{
    private int idVegetable;
    private String vegName;
    private String brand;

    public Vegetables (){}

    public Vegetables(int idProduct, String name, int price,int idVegetable,String vegName,String brand) {
        super(idProduct, name, price);
        this.idVegetable = idVegetable;
        this.vegName = vegName;
        this.brand = brand;
    }
    @XmlElement(name = "idVegetable")
    public int getIdVegetable() {
        return idVegetable;
    }

    public void setIdVegetable(int idVegetable) {
        this.idVegetable = idVegetable;
    }
    @XmlElement(name = "Name")
    public String getVegetableName() {
        return vegName;
    }

    public void setVegetableName(String vegName){
        this.vegName=vegName;
    }
    @XmlElement(name = "Brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


}
