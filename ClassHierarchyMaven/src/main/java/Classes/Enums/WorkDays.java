package Classes.Enums;

public enum WorkDays {
    MONDAY(true),
    THURSDAY(true),
    WEDNESDAY(true),
    TUESDAY(true),
    FRIDAY(true),
    SATURDAY(false),
    SUNDAY(false);

    private final boolean workday;

    WorkDays(boolean workday){
        this.workday=workday;
    }

    public boolean getWorkday(){
        return workday;
    }
}
