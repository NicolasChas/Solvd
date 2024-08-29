package Classes;
import java.util.HashSet;
import java.util.Set;

public class CollegeStudent extends Student{
    protected String career;
    public boolean highSchoolTitle;
    public Set<String> subjects= new HashSet<>();
    public CollegeStudent(int id, String name, int age, String grade,String career,boolean highSchoolTitle){
        super(id, name, age, grade);
        this.career=career;
        this.highSchoolTitle=highSchoolTitle;
    }
    public void setSubjects(){
        subjects.add("Algebra I");
        subjects.add("Physics I");
    }
    
}