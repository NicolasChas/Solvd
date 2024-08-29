package Classes;

public class Politician extends Worker{
    protected String position;
    private int salary;
    public Politician(int id,String name, int age,String cardNumber,String position, int salary){
        super(id,name,age,cardNumber);
        this.position=position;
        this.salary=salary;
    }

    public int getSalary(){
        return salary;
    }

    public void setSalary(int salary){
        this.salary=salary;
    }
//Override of method/Polymorphism of abstrac
    @Override
    public void setId(int id){
        super.setId(id);
        System.out.println("You have set the id to: "+id);
    }

}