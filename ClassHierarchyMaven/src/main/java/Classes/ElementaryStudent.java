package Classes;

import Classes.Interfaces.Play;

public class ElementaryStudent extends Student implements Play{
    protected String favColor;
    public ElementaryStudent(int id,String name,int age, String grade,String favColor){
        super(id, name, age, grade);
        this.favColor=favColor;
    }
    @Override
    public void playTime() {
        System.out.println("This Elementary Student plays with toys");
    }
}