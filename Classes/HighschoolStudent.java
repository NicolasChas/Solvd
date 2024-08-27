package Classes;

import Classes.Interfaces.Wakeup;

public class HighschoolStudent extends Student implements Wakeup{
    protected boolean privateSchool;
    public HighschoolStudent(int id,String name,int age,String grade,boolean privateSchool){
        super(id, name, age, grade);
        this.privateSchool=privateSchool;
    }
//Override of hashcode, adds the person's id to its age to create a code.
    @Override
    public int hashCode(){
        int code=this.getId() + this.age;
        return code;
    }
@Override
    public void wakeUpTime(){
        System.out.println("This Highschool Student wakes up at 09:00 AM");
    }
}