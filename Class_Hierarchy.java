class Person{
    private int id;
    String name;
    int age;

    public Person(int id,String name, int age){
        this.id=id;
        this.name=name;
        this.age=age;
    }

    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
}

    

class Student extends Person{
    int grade;
    public Student(int id,String name, int age, int grade){
        super(id,name,age);
        this.grade=grade;
    }
}

class Worker extends Person{
    private String cardNumber; 
    public Worker(int id,String name, int age,String cardNumber){
        super(id,name,age);
        this.cardNumber=cardNumber;
    }

    public String getCardNumber(){
        return cardNumber;
    }

    public void setCardNumber(String cardNumber){
        this.cardNumber=cardNumber;
    }

}

class Teacher extends Person{
    String field;
    public Teacher(int id,String name, int age,String field){
        super(id,name,age);
        this.field=field;
    } 
}

class CEO extends Person{
    String company;
    public CEO(int id,String name, int age,String company){
        super(id,name,age);
        this.company=company;
    } 
}

class Politician extends Person{
    String position;
    private int salary;
    public Politician(int id,String name, int age,int salary){
        super(id,name,age);
        this.salary=salary;
    }

    public int getSalary(){
        return salary;
    }

    public void setSalary(int salary){
        this.salary=salary;
    }
//Override of method
    @Override
    public void setId(int id){
        super.setId(id);
        System.out.println("You have set the id to: "+id);
    }
    
}

class Farmer extends Person{
    String farmType;
    public Farmer(int id,String name, int age,String farmType){
        super(id,name,age);
        this.farmType=farmType;
    } 
}

class Soldier extends Person{
    int yearsOfService;
    public Soldier(int id,String name, int age,int yearsOfService){
        super(id,name,age);
        this.yearsOfService=yearsOfService;
    } 
}

class Chef extends Person{
    String specialization;
    private String secretRecipe;
    public Chef(int id,String name, int age,String specialization,String recipe){
        super(id,name,age);
        this.specialization=specialization;
        this.secretRecipe=recipe;
    }

    public String getSecretRecipe(){
        return secretRecipe;
    }

    public void setSecretRecipe(String secretRecipe){
        this.secretRecipe=secretRecipe;
    }
}
    
class Athlete extends Person{
    String sport;
    boolean fit;
    public Athlete(int id,String name, int age,String sport,boolean fit){
        super(id,name,age);
        this.sport=sport;
        this.fit=fit;
    } 
//Overloading constructor
    public Athlete(int id,String name,int age, String sport){
        super(id, name, age);
        this.sport=sport;
        this.fit=true;
    }
}

class Criminal extends Person{
    private String crime;
    public Criminal(int id,String name, int age,String crime){
        super(id,name,age);
        this.crime=crime;
    } 

    public String getCrime(){
        return crime;
    }

    public void setCrime(String crime){
        this.crime=crime;
    }
}

public class Class_Hierarchy {
    public static void main(String[] args) {
        Student student=new Student(42877810,"Jhon Maine",12,7);
        Worker worker=new Worker(13543165, "Michael Brooks", 32, "4333212300987785");
        Teacher teacher= new Teacher(23438912, "Laura Jhones", 27, "Math");
        CEO ceo=new CEO(18374481, "Steve Meks", 54, "IBM");
        Politician politician=new Politician(11321731, "Tim Walz", 66, 600000);
        Farmer farmer=new Farmer(4321, "Peter Dinkel", 45, "Chicken farm");
        Soldier soldier=new Soldier(32871903, "Derek Stern", 31, 5);
        Chef chef=new Chef(38017361, "Gordon Morgan", 49, "Pastry Chef", "Chocolate Cake");
        Athlete athlete= new Athlete(41123917, "Sara Denver", 26, "Hockey", true);
        Criminal criminal=new Criminal(21888461, "Tom Jones", 35, "Burglary");
    }
    
}
