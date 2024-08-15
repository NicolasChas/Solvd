//Override of toString is in Teacher class.
//Override of hashCode is in HighschoolStudent class.
//Override of equals is in Person class.
abstract class Person{
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

    

class Student extends Person{
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

    class HighschoolStudent extends Student{
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
    }

    class ElementaryStudent extends Student{
        protected String favColor;
        public ElementaryStudent(int id,String name,int age, String grade,String favColor){
            super(id, name, age, grade);
            this.favColor=favColor;
        }
    }

    class CollegeStudent extends Student{
        protected String career;
        public CollegeStudent(int id, String name, int age, String grade,String career){
            super(id, name, age, grade);
            this.career=career;
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
    @Override
    public void printName(){
        System.out.println("The Worker's name is "+ this.name);
    }

}

    class Teacher extends Worker{
        String field;
        public Teacher(int id,String name, int age,String cardNumber,String field){
            super(id,name,age,cardNumber);
            this.field=field;
        }
        @Override
        public String toString(){
            return "This theacher's name is "+name+ ", and their field is "+field+".";
        }
    }

    class Banker extends Worker{
        protected String bank;
        private String password;
        public Banker(int id,String name, int age,String cardNumber,String bank, String password){
            super(id,name,age,cardNumber);
            this.bank=bank;
            this.password=password;
        }

        public String getPassword(){
            return password;
        }

        public void setPassword(String password){
            this.password=password;
        }
    }

    class Politician extends Worker{
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

    class Farmer extends Worker{
        String farmType;
        public Farmer(int id,String name, int age,String cardNumber,String farmType){
            super(id,name,age,cardNumber);
            this.farmType=farmType;
        } 
    }

    class Lawyer extends Worker{
        protected int casesWon;
        private int casesLost;
        public Lawyer(int id,String name, int age,String cardNumber,int casesWon,int casesLost){
            super(id,name,age,cardNumber);
            this.casesWon=casesWon;
            this.casesLost=casesLost;
        } 

        public int getCasesLost(){
            return casesLost;
        }

        public void setCasesLost(int casesLost){
            this.casesLost=casesLost;
        }
    }

    class Chef extends Worker{
        String specialization;
        private String secretRecipe;
        public Chef(int id,String name, int age,String cardNumber,String specialization,String recipe){
            super(id,name,age,cardNumber);
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
    
    class Athlete extends Worker{
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
    }

    class Plumber extends Worker{
        private boolean plumbingLicense;
        public Plumber(int id,String name, int age,String cardNumber,boolean plumbingLicense){
            super(id,name,age,cardNumber);
            this.plumbingLicense=plumbingLicense;
        } 

        public boolean getLicense(){
            return plumbingLicense;
        }

        public void setLicnese(boolean plumbingLicense){
            this.plumbingLicense=plumbingLicense;
        }
    }

public class Class_Hierarchy {
    public static void main(String[] args) {
        HighschoolStudent highschoolStudent= new HighschoolStudent(4321, "Peter Cerk", 15, "Second Year", false);
        ElementaryStudent elementaryStudent= new ElementaryStudent(1574, "Thomas Plank", 10, "Sixth grade", "Blue");
        CollegeStudent collegeStudent= new CollegeStudent(4831, "Carter Jones", 20, "Sophomore", "Engineering");
        Teacher teacher= new Teacher(6913, "Helena Pierce", 32,"44459901", "Math");
        Banker banker= new Banker(8710, "Kevin Doyle", 37, "86470912", "Central Bank", "apples00");
        Politician politician= new Politician(3371, "Tim Becker", 55, "18430091", "Senator", 500000);
        Farmer farmer= new Farmer(23, "Lisa Clark", 28, "87416121", "Chicken Farm");
        Lawyer lawyer=new Lawyer(9910, "Saul Goodman", 43, "00192373", 3, 23);
        Chef chef=new Chef(1632, "Gordon Letterman", 51, "01237812", "Pastry Chef", "Chocolate Cake");
        Athlete athlete=new Athlete(3333, "Daiana Madelaine", 24, "9918231", "Volleyball",true);
        Plumber plumber=new Plumber(5595, "Mario Luigi", 62, "89174740", true);
        System.out.println(teacher.toString());
        System.out.println(highschoolStudent.hashCode());
        System.out.println(farmer.equals(plumber));
    }
    
}
