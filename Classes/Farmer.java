package Classes;

import Classes.Interfaces.Eat;

public class Farmer extends Worker implements Eat{
    String farmType;
    public Farmer(int id,String name, int age,String cardNumber,String farmType){
        super(id,name,age,cardNumber);
        this.farmType=farmType;
    }
    @Override
    public void eatingTime() {
        System.out.println("This farmer eats eggs and chicken.");
    } 
}