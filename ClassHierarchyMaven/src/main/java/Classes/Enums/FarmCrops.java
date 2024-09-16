package Classes.Enums;

public enum FarmCrops {
    LETTUCE("Butter head Lettuce","Summer"),
    WHEAT("Saracen wheat","Summer-Spring-Autumn"),
    CORN("Sweet corn","Summer-Spring");

    private final String name;
    private final String season;

    FarmCrops(String name, String season){
        this.name=name;
        this.season=season;
    }

    public String getName(){
        return name;
    }
    public String getSeason(){
        return season;
    }

    public boolean isSummerCrop(){
        return this.season.contains("Summer");
    }
}
