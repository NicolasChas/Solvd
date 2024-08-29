package Classes;

public class Worker extends Person{
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
    static {
        System.out.println("All workers must pay taxes before the end of the month.");
    }
    final void payTaxes(){
        System.out.println("You have paid your taxes");
    }

}