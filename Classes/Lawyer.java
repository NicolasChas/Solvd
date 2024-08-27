package Classes;

public class Lawyer extends Worker{
    protected int casesWon;
    private int casesLost;
    final boolean inDebt=true;
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