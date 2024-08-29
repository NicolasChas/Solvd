package Classes;
import java.util.HashMap;

import Classes.Interfaces.Eat;

public class Farmer extends Worker implements Eat{
    String farmType;
    public HashMap<String,String> animals=new HashMap<>();

    public Farmer(int id,String name, int age,String cardNumber,String farmType){
        super(id,name,age,cardNumber);
        this.farmType=farmType;
    }

    @Override
    public String eatingTime() {
        return "This farmer eats eggs and chicken.";
    }

    public void setAnimals(){
        animals.put("Chicken","Rupert");
        animals.put("Cat","Ernest");
        animals.put("Horse","Mary");
        animals.put("Cow","Sindy");
        animals.put("Dog","Bob");
    }
}