package basketballdbms.Entities;

public class teamStadium {
    private int id ;
    private String teamName ;
    private String teamCity ;
    private String gm ;
    private String statium ;
    private int capacity ;
    private String statiumCity ;


    public teamStadium() {
    }

    public teamStadium(int id, String teamName, String teamCity, String gm, String statium, int capacity, String statiumCity) {
        this.id = id;
        this.teamName = teamName;
        this.teamCity = teamCity;
        this.gm = gm;
        this.statium = statium;
        this.capacity = capacity;
        this.statiumCity = statiumCity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamCity() {
        return teamCity;
    }

    public void setTeamCity(String teamCity) {
        this.teamCity = teamCity;
    }

    public String getGm() {
        return gm;
    }

    public void setGm(String gm) {
        this.gm = gm;
    }

    public String getStatium() {
        return statium;
    }

    public void setStatium(String statium) {
        this.statium = statium;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getStatiumCity() {
        return statiumCity;
    }

    public void setStatiumCity(String statiumCity) {
        this.statiumCity = statiumCity;
    }

    @Override
    public String toString() {
        return "teamStadium{" + "id=" + id + ", teamName=" + teamName + ", teamCity=" + teamCity + ", gm=" + gm + ", statium=" + statium + ", capacity=" + capacity + ", statiumCity=" + statiumCity + '}';
    }
    
    
}
