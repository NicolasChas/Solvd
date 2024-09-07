package Classes;

public class Student extends Person{
    String grade;
    public Student(int id,String name, int age, String grade){
        super(id,name,age);
        this.grade=grade;
    }
//Override of abstract method
    @Override
    public void printName() {
        System.out.println("The Student's name is "+ this.name);
    }
    
}