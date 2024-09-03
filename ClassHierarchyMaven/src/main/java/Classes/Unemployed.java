package Classes;
import java.util.ArrayList;

public final class Unemployed extends Worker{
    public ArrayList<String> possessions = new ArrayList<String>();
    public Unemployed(int id,String name, int age, String cardNumber){
        super(id,name,age,cardNumber);
    }
    public void setPossessions(){
        possessions.add("Phone");
        possessions.add("Box");
        possessions.add("Fork");
    }
}