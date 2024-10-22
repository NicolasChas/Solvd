package Classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Meat")
public class Meat extends Product{
    private int idMeat;
    private String cut;
    private String brand;

    public Meat() {}

    public Meat(int idProduct, String name, int price,int idMeat,String cut,String brand) {
        super(idProduct, name, price);
        this.idMeat = idMeat;
        this.cut = cut;
        this.brand = brand;
    }

    @XmlElement(name = "idMeat")
    public int getIdMeat() {
        return idMeat;
    }

    public void setIdMeat(int idMeat) {
        this.idMeat = idMeat;
    }
    @XmlElement(name = "Cut")
    public String getCut() {
        return cut;
    }

    public void setCut(String cut) {
        this.cut = cut;
    }
    @XmlElement(name = "Brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}
