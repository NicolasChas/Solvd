package Classes.Enums;

public enum Ingredients {
    BEEF("Cow beef",100),
    TOMATO("Italian tomato",20);

    private final String name;
    private final int price;

    Ingredients(String name,int price){
        this.name=name;
        this.price=price;
    }

    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }
}
