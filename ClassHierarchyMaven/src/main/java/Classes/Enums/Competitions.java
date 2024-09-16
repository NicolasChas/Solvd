package Classes.Enums;

public enum Competitions {
    TOURNAMENT("Volleyball",6),
    WORLDCUP("Basketball",11);

    private final String competitionName;
    private final int competitionMatches;

    Competitions(String name,int matches){
        this.competitionName=name;
        this.competitionMatches=matches;
    }

    public String getCompetitionName(){
        return competitionName;
    }
    public int getCompetitionMatches(){
        return competitionMatches;
    }
}
