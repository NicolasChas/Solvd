package Classes;

import Classes.Interfaces.Dream;

public class Athlete extends Worker implements Dream{
    String sport;
    protected boolean fit;
    public Athlete(int id,String name, int age,String cardNumber,String sport,boolean fit){
        super(id,name,age,cardNumber);
        this.sport=sport;
        this.fit=fit;
    } 
//Overloading constructor
    public Athlete(int id,String name,int age,String cardNumber,String sport){
        super(id, name, age,cardNumber);
        this.sport=sport;
        this.fit=true;
    }
    @Override
    public void dreamTime() {
        System.out.println("This athlete dreams of winning a gold medal.");
    }
    public boolean getFit(){
        return fit;
    }
}