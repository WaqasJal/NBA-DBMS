package basketballdbms.Entities;

public class Team implements Comparable<Team> {

    private int rank ;
    private int id ;
    private String name ;
    private int wins ;
    private int loses ;
    private float pct ;

    public Team(int rank, String name, int wins, int loses, float pct) {
        this.rank = rank;
        this.name = name;
        this.wins = wins;
        this.loses = loses;
        this.pct = pct;
    }

    public Team() {
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public float getPct() {
        return pct;
    }

    public void setPct(float pct) {
        this.pct = pct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Team{" + "rank=" + rank + ", id=" + id + ", name=" + name + ", wins=" + wins + ", loses=" + loses + ", pct=" + pct + '}';
    }

    @Override
    public int compareTo(Team o) {
        return  Float.compare(o.pct,this.pct) ;      
    }
    
    
}
