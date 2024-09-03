package Classes;

public class Plumber extends Worker{
    private boolean plumbingLicense;
    public Plumber(int id,String name, int age,String cardNumber,boolean plumbingLicense){
        super(id,name,age,cardNumber);
        this.plumbingLicense=plumbingLicense;
    } 

    public boolean getLicense(){
        return plumbingLicense;
    }

    public void setLicense(boolean plumbingLicense){
        this.plumbingLicense=plumbingLicense;
    }
}