package Classes;

public class Banker extends Worker{
    protected String bank;
    private String password;
    public Banker(int id,String name, int age,String cardNumber,String bank, String password){
        super(id,name,age,cardNumber);
        this.bank=bank;
        this.password=password;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }
}