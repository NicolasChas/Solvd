package Classes;

public abstract class Person{
    private int id;
    public String name;
    public int age;
    public static int year=2024;
    
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

    public static String printYear(){
        return "The year is "+year;
    }
    

    public abstract void printName();
//Equals override to return true if two persons have the same id.
    @Override
    public boolean equals(Object person){
        if(this.id==((Person) person).getId()){
            return true;
        }
        else{
            return false;
        }
    }
}
