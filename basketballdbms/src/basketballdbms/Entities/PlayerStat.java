package basketballdbms.Entities;


public class PlayerStat implements Comparable<PlayerStat>{
    private int rank ; 
    private int id ;
    private String playerName ;
    private String playerTeam ;
    private int blocks ;
    private int steals ;
    private int avgPoints ;
    private int totalPoints ;
    private int gamesPlayed ;
    private int assists ;
    private int rebounds ;
    private int ftPercent ;

    public PlayerStat() {
    }

    public PlayerStat(int id, String playerName, String playerTeam, int blocks, int steals, int avgPoints, int totalPoints, int gamesPlayed, int assists, int rebounds, int ftPercent) {
        this.id = id;
        this.playerName = playerName;
        this.playerTeam = playerTeam;
        this.blocks = blocks;
        this.steals = steals;
        this.avgPoints = avgPoints;
        this.totalPoints = totalPoints;
        this.gamesPlayed = gamesPlayed;
        this.assists = assists;
        this.rebounds = rebounds;
        this.ftPercent = ftPercent;
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

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerTeam() {
        return playerTeam;
    }

    public void setPlayerTeam(String playerTeam) {
        this.playerTeam = playerTeam;
    }

    public int getBlocks() {
        return blocks;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }

    public int getSteals() {
        return steals;
    }

    public void setSteals(int steals) {
        this.steals = steals;
    }

    public int getAvgPoints() {
        return avgPoints;
    }

    public void setAvgPoints(int avgPoints) {
        this.avgPoints = avgPoints;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
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
    public String toString() {
        return "PlayerStat{" + "rank=" + rank + ", id=" + id + ", playerName=" + playerName + ", playerTeam=" + playerTeam + ", blocks=" + blocks + ", steals=" + steals + ", avgPoints=" + avgPoints + ", totalPoints=" + totalPoints + ", gamesPlayed=" + gamesPlayed + ", assists=" + assists + ", rebounds=" + rebounds + ", ftPercent=" + ftPercent + '}';
    }



    @Override
    public int compareTo(PlayerStat o) {
        float st1 = (float)this.totalPoints / this.gamesPlayed ;
        float st2 = (float)o.totalPoints / o.gamesPlayed ;
        
        return  Float.compare(st2,st1) ; 
    }
    
    
}
