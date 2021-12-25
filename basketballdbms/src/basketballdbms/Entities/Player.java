package basketballdbms.Entities;

public class Player {
    private int id ;
    private String name ;
    private int height ;
    private int weight ;
    private String position ;
    private int jersy_No ;
    private String teamName ;

    public Player(String name, int height, int weight, String position, int jersy_No, String teamName) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.position = position;
        this.jersy_No = jersy_No;
        this.teamName = teamName;
    }

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getJersy_No() {
        return jersy_No;
    }

    public void setJersy_No(int jersy_No) {
        this.jersy_No = jersy_No;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Player{" + "id=" + id + ", name=" + name + ", height=" + height + ", weight=" + weight + ", position=" + position + ", jersy_No=" + jersy_No + ", teamName=" + teamName + '}';
    }
    
    
    
}
