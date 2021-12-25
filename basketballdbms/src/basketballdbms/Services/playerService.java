/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballdbms.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import basketballdbms.Entities.Player;
import basketballdbms.Entities.PlayerStat;
import basketballdbms.Utils.MaConnection;

/**
 *
 * @author cps510
 */
public class playerService {
    
    public List<PlayerStat> getListPlayers()
    {
        List<PlayerStat> list = new ArrayList<>() ; 
        
        MaConnection maConnection = MaConnection.getInstance();
        
        Connection cnx = maConnection.getCnx() ; 
        
        try {
            
        Statement stmt=cnx.createStatement();  
  
        ResultSet rs=stmt.executeQuery("select Players.Name , Players.Team_name , Player_Stats.* from Player_Stats join Players on Players.Player_ID = Player_Stats.Player_ID");  
        
        while(rs.next())  
        {
            String playerName = rs.getString(1) ;
            String playerTeam = rs.getString(2) ; 
            int playerStatId = rs.getInt(3) ;
            int blocks = rs.getInt(4) ; 
            int steals = rs.getInt(5) ; 
            int avgPoints = rs.getInt(7);
            int totalPoints = rs.getInt(8);
            int gamesPlayed = rs.getInt(6);
            int assists = rs.getInt(9) ; 
            int rebounds = rs.getInt(10) ;
            int ftPercent = rs.getInt(11);

            PlayerStat playerStat = new PlayerStat();
            playerStat.setId(playerStatId);
            playerStat.setPlayerName(playerName);
            playerStat.setPlayerTeam(playerTeam);
            playerStat.setBlocks(blocks);
            playerStat.setSteals(steals);
            playerStat.setAvgPoints(avgPoints);
            playerStat.setGamesPlayed(gamesPlayed);
            playerStat.setAssists(assists);
            playerStat.setRebounds(rebounds);
            playerStat.setFtPercent(ftPercent);
            playerStat.setTotalPoints(totalPoints);
            
            list.add(playerStat) ;

        }

        }catch(Exception e){ System.out.println(e);}  

        
        // sort list 
        
        Collections.sort(list);
        
        // add rank to Teams
        
        for ( int i = 0 ; i < list.size() ; i++)
        {
            list.get(i).setRank(i+1);
        }
        
        return list ; 
        
    }
    
    
    public Player getPlayer(int id)
    {
        MaConnection maConnection = MaConnection.getInstance();
        
        Connection cnx = maConnection.getCnx() ; 
        
        try {
            
        Statement stmt=cnx.createStatement();  
  
        ResultSet rs=stmt.executeQuery("select * from Players where Player_ID = " + id);  
        
        rs.next() ;
        
        String name = rs.getString(2) ;
        int height = rs.getInt(3) ; 
        int Weight = rs.getInt(4) ; 
        String Position = rs.getString(5) ; 
        int Jersy_No = rs.getInt(6) ; 
        String teamName = rs.getString(7) ; 
        
        Player player = new Player(); 
        player.setName(name);
        player.setHeight(height);
        player.setWeight(Weight);
        player.setPosition(Position);
        player.setJersy_No(Jersy_No);
        player.setTeamName(teamName);
        
        return player ;
        
        
        }catch(Exception e){ System.out.println(e);}  
        
            

        
        return null ; 
    }
    
}
