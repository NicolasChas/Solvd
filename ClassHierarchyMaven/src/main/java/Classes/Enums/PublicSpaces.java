package Classes.Enums;


public enum PublicSpaces {
    HOSPITAL("Hospital",24),
    BANK("Bank",4),
    SCHOOL("School",12),
    PARK("Park",24);

    private final String name;
    private final int hoursOpen;

    PublicSpaces(String name,int hoursOpen){
        this.name=name;
        this.hoursOpen=hoursOpen;
    }

    public String getName(){
        return name;
    }
    public int getHoursOpen(){
        return hoursOpen;
    }

    public String goTo(String personName,String placeName){
        return "The person "+personName+" is going to "+placeName;
    }
}
