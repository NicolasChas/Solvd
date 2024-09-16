import Classes.*;
import Classes.Exceptions.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.Arrays;
import java.util.Set;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.function.BiFunction;

import Classes.Interfaces.CustomLambda1;
import Classes.Interfaces.CustomLambda2;
import Classes.Interfaces.CustomLambda3;
import org.apache.logging.log4j.LogManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class ClassHierarchy {
    public static org.apache.logging.log4j.Logger logger;
    public static void main(String[] args) {
        File log4jfile =new File("C:\\Users\\Nicolás\\Desktop\\Java\\Solvd\\ClassHierarchyMaven\\src\\main\\java\\log4j2.properties");
        System.setProperty("log4j2.configurationFile",log4jfile.toURI().toString());
        logger=LogManager.getLogger(ClassHierarchy.class);
        CustomList<Integer> customList = new CustomList<>();
        customList.add(1);
        customList.add(2);
        customList.add(3);
        customList.display();
        HighschoolStudent highschoolStudent= new HighschoolStudent(4321, "Peter Cerk", 15, "Second Year", false);
        ElementaryStudent elementaryStudent= new ElementaryStudent(1574, "Thomas Plank", 10, "Sixth grade", "Blue");
        CollegeStudent collegeStudent=new CollegeStudent(3217, "Carter Jones", 21, "Sophomore", "Engineering", true);
        Teacher teacher= new Teacher(6913, "Helena Pierce", 32,"44459901", "Math");
        Banker banker= new Banker(8710, "Kevin Doyle", 37, "86470912", "Central Bank", "apples00");
        Politician politician= new Politician(3371, "Tim Becker", 55, "18430091", "Senator", 500000);
        Farmer farmer= new Farmer(23, "Lisa Clark", 28, "87416121", "Chicken Farm");
        Lawyer lawyer=new Lawyer(9910, "Saul Goodman", 43, "00192373", 3, 23);
        Chef chef=new Chef(1632, "Gordon Letterman", 51, "01237812", "Pastry Chef", "Chocolate Cake");
        Athlete athlete=new Athlete(3333, "Daiana Madelaine", 24, "9918231", "Volleyball",true);
        Plumber plumber=new Plumber(5595, "Mario Luigi", 62, "89174740", true);
        Unemployed unemployed=new Unemployed(2134,"Johan Ders",32,"83710281");
        farmer.setAnimals();
        unemployed.setPossessions();
        collegeStudent.setSubjects();
        lawyer.setCurrentClients();
        chef.setRecipes();
        logger.info(teacher.toString());
        logger.info(highschoolStudent.hashCode());
        logger.info(farmer.equals(plumber));
        logger.info(highschoolStudent.wakeUpTime());
        logger.info(farmer.printYear());
        logger.info(farmer.animals);
        logger.info(unemployed.possessions);
        logger.info(collegeStudent.subjects);
        logger.info(lawyer.currentClients);
        logger.info(chef.recipes);
        try{
            checkTitle(collegeStudent.highSchoolTitle);
        } catch(InvalidTitle e){
            logger.error(e);
        }
        try{
            checkElementaryStudentAge(elementaryStudent.age);
        } catch(InvalidAge e){
            logger.error(e);
        }
        try{
            checkPasswordSecurity(banker.getPassword());
        } catch(InvalidPassword e){
            logger.error(e);
        }
        try{
            checkSalary(politician.getSalary());
        } catch(InvalidSalary e){
            logger.error(e);
        }
        try{
            checkFit(athlete.getFit());
        } catch(InvalidFit e){
            logger.error(e);
        }
        try{
            readFirstLineFromFile("C:\\Users\\Nicolás\\Desktop\\Java\\Solvd\\ClassHierarchyMaven\\src\\main\\resources\\file.txt");
        }catch(IOException e){
            logger.error(e);
        }
        try{
            readText();
        }catch(IOException e){
            logger.error(e);
        }
        checkPlumberAge(plumber.age);
        //Lambda functions
        Predicate<Integer> lessThan50 = i -> (i<50);
        logger.info(lessThan50.test(athlete.age));

        Consumer<String> showName= name -> logger.info(name);
        showName.accept(politician.name);

        Supplier<Integer> getId = ()-> chef.getId();
        logger.info(getId.get());

        BiFunction<Integer,Integer,Boolean> olderThan=(age1,age2)->age1>age2;
        logger.info(olderThan.apply(teacher.age,lawyer.age));

        Function<String,Integer> nameLength=name ->name.replace(" ","").length();
        logger.info(nameLength.apply(banker.name));

        CustomLambda1<Integer> firstLambda=(age)->logger.info(2*age);
        firstLambda.doubleAge(plumber.age);

        CustomLambda2<String,String> secondLambda=(name1,name2)->name1.length()<name2.length();
        logger.info(secondLambda.compareNamesLength(farmer.name,athlete.name));

        CustomLambda3<String,Integer> thirdLambda=(name,age)->logger.info("The person's name is " +name+", and their age is "+age);
        thirdLambda.printInfo(chef.name,chef.age);


    }
    static void checkTitle(boolean title) throws InvalidTitle{
        if (!title){
            throw new InvalidTitle("You cant create a college student without a high school title.");
        }
        else {
            logger.info("No problems with your College student's credentials.");
        }
    }

    static void checkElementaryStudentAge(int age) throws InvalidAge{
        if (age>11){
            throw new InvalidAge("You cant create an elementary student who is older than 11.");
        }
        else {
            logger.info("No problems with your Elementary student's credentials.");
        }
    }

    static void checkPasswordSecurity(String password) throws InvalidPassword{
        if (password.length()<=4){
            throw new InvalidPassword("Banker's password must be more than 4 characters.");
        }
        else{
            logger.info("No problems with your Banker's credentials.");
        }
    }

    static void checkSalary(int salary) throws InvalidSalary{
        if(salary<100000){
            throw new InvalidSalary("Salary of politician must be higher than 6 figures.");
        }
        else{
            logger.info("No problems with your politician's credentials.");
        }
    }

    static void checkFit(boolean fit) throws InvalidFit{
        if(!fit){
            throw new InvalidFit("Athlete must be fit");
        }
        else{
            logger.info("No problems with your Athlete's credentials.");
        }
    }

    static void checkPlumberAge(int age)throws IncorrectPlumberAge{
        if(age<40){
            throw new IncorrectPlumberAge("The plumber's age should be above 40, because they have more experience");
        }
        else{
            logger.info("The plumber's age is acceptable");
        }
    }
    //try catch with resources
    static void readFirstLineFromFile(String path) throws IOException {
        try (FileReader fr = new FileReader(path);
             BufferedReader br = new BufferedReader(fr)) {
            br.readLine();
        }
    }
    static void readText() throws IOException {
        String content = FileUtils.readFileToString(new File("C:\\Users\\Nicolás\\Desktop\\Java\\Solvd\\ClassHierarchyMaven\\src\\main\\resources\\file2.txt"), "UTF-8");
        Set<String> uniqueWords=Arrays.stream(StringUtils.split(content," ")).map(String::toLowerCase).collect(Collectors.toSet());
        FileUtils.writeStringToFile(new File("C:\\Users\\Nicolás\\Desktop\\Java\\Solvd\\ClassHierarchyMaven\\src\\main\\resources\\output2.txt"),"Amount of unique words: "+uniqueWords.size(),"UTF-8");
        logger.info("The amount of unique words in the file is "+uniqueWords.size());
    }

}