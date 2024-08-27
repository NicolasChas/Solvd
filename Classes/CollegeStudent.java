package Classes;

public class CollegeStudent extends Student{
    protected String career;
    public boolean highSchoolTitle;
    public CollegeStudent(int id, String name, int age, String grade,String career,boolean highSchoolTitle){
        super(id, name, age, grade);
        this.career=career;
        this.highSchoolTitle=highSchoolTitle;
    }
    
}