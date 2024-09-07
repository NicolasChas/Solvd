package Classes;
import java.util.TreeSet;
public class Chef extends Worker{
    public String specialization;
    private String secretRecipe;
    public TreeSet<String> recipes = new TreeSet<>();
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

    public void setRecipes(){
        recipes.add("Cookies");
        recipes.add("Scones");
        recipes.add("Cheesecake");
        recipes.add("Croissant");
    }
}