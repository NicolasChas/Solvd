package Classes;

import Classes.Interfaces.Sleep;

public class Teacher extends Worker implements Sleep{
    String field;
    public Teacher(int id,String name, int age,String cardNumber,String field){
        super(id,name,age,cardNumber);
        this.field=field;
    }
    @Override
    public String toString(){
        return "This teacher's name is "+name+ ", and their field is "+field+".";
    }
    @Override
    public void sleepTime() {
        System.out.println("This teacher sleeps at 01:00 AM");
    }
}