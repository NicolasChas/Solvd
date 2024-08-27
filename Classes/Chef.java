package Classes;

public class Chef extends Worker{
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