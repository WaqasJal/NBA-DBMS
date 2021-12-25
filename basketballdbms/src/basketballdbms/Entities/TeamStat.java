package basketballdbms.Entities;

public class TeamStat implements Comparable<TeamStat> {
    
    private int rank ; 
    private int id ;
    private String name ;
    private int wins ;
    private int losses ;
    private int totalPoints ;
    private int steals ;
    private int blocks ;
    private int assists ;
    private int rebounds ;
    private int ftPercent ;

    public TeamStat(int id, String name, int wins, int losses, int totalPoints, int steals, int blocks, int assists, int rebounds, int ftPercent) {
        this.id = id;
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.totalPoints = totalPoints;
        this.steals = steals;
        this.blocks = blocks;
        this.assists = assists;
        this.rebounds = rebounds;
        this.ftPercent = ftPercent;
    }

    public TeamStat() {
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getSteals() {
        return steals;
    }

    public void setSteals(int steals) {
        this.steals = steals;
    }

    public int getBlocks() {
        return blocks;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getRebounds() {
        return rebounds;
    }

    public void setRebounds(int rebounds) {
        this.rebounds = rebounds;
    }

    public int getFtPercent() {
        return ftPercent;
    }

    public void setFtPercent(int ftPercent) {
        this.ftPercent = ftPercent;
    }

    @Override
    public int compareTo(TeamStat o) {
        
       float percent1 = (float) this.wins / this.wins + this.losses ;
       float percent2 = (float) o.wins / o.wins + o.losses ;
        
       return  Float.compare(percent1,percent2) ;    
    }

    @Override
    public String toString() {
        return "TeamStat{" + "rank=" + rank + ", id=" + id + ", name=" + name + ", wins=" + wins + ", losses=" + losses + ", totalPoints=" + totalPoints + ", steals=" + steals + ", blocks=" + blocks + ", assists=" + assists + ", rebounds=" + rebounds + ", ftPercent=" + ftPercent + '}';
    }
    
    
}
