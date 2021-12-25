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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import basketballdbms.Entities.Team;
import basketballdbms.Entities.TeamStat;
import basketballdbms.Entities.teamStadium;
import basketballdbms.Utils.MaConnection;

/**
 *
 * @author cps510
 */
public class TeamService {
    
    
    public List<Team> getListTeams()
    {
        List<Team> list = new ArrayList<>() ; 
        
        MaConnection maConnection = MaConnection.getInstance();
        
        Connection cnx = maConnection.getCnx() ; 
        
        try {
            
        Statement stmt=cnx.createStatement();  
  
        ResultSet rs=stmt.executeQuery("select Teams.Team_Name , Team_Stats.Wins , Team_Stats.Losses  from Team_Stats join Teams on Team_Stats.Team_ID = Teams.Team_ID");  
        
        while(rs.next())  
        {
            String teamName = rs.getString(1) ;
            int wins = rs.getInt(2) ; 
            int losses = rs.getInt(3) ;
            
            float percent = (float)wins / (wins + losses) ;
            percent = percent * 100 ; 
            
            Team team = new Team(0, teamName, wins, losses, percent);
            list.add(team) ; 
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
    
    
    
     public List<TeamStat> getTeamStat()
    {
        List<TeamStat> list = new ArrayList<>() ; 
        
        MaConnection maConnection = MaConnection.getInstance();
        
        Connection cnx = maConnection.getCnx() ; 
        
        try {
            
        Statement stmt=cnx.createStatement();  
  
        ResultSet rs=stmt.executeQuery(" select Teams.Team_Name , Team_Stats.* from Team_Stats join Teams on Team_Stats.Team_ID = Teams.Team_ID");  
        
        while(rs.next())  
        {
            String teamName = rs.getString(1) ;
            int wins = rs.getInt(3) ;
            int losses = rs.getInt(4) ;
            int totalPoints = rs.getInt(5);
            int steals = rs.getInt(6) ;
            int rebounds = rs.getInt(7) ;
            int assists = rs.getInt(8) ; 
            int blocks = rs.getInt(9) ; 
            int ftPercent = rs.getInt(10);

            TeamStat teamStat = new TeamStat();
            teamStat.setName(teamName);
            teamStat.setWins(wins);
            teamStat.setLosses(losses);
            teamStat.setTotalPoints(totalPoints);
            teamStat.setSteals(steals);
            teamStat.setRebounds(rebounds);
            teamStat.setAssists(assists);
            teamStat.setBlocks(blocks);
            teamStat.setFtPercent(ftPercent);
            
            list.add(teamStat) ; 
            

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
     
     public List<teamStadium> getTeamsTadium()
    {
        List<teamStadium> list = new ArrayList<>() ; 
        
        MaConnection maConnection = MaConnection.getInstance();
        
        Connection cnx = maConnection.getCnx() ; 
        
        Map<Integer , ArrayList<Object>> lSchedule = new HashMap<>() ;
        Map<Integer , ArrayList<Object>> lTeams = new HashMap<>() ;
        Map<Integer , ArrayList<Object>> lStadium = new HashMap<>() ;
        
        try {
            
        Statement stmt=cnx.createStatement(); 
        
        // select Schedule
        
        
        ResultSet rs=stmt.executeQuery("select * from Schedule ");  
        int i = 0 ;
        while(rs.next())  
        {
            int Stadium_ID = rs.getInt(2) ;
            int teamId1 = rs.getInt(3) ;
            int teamId2 = rs.getInt(4) ;
            
            ArrayList array = new ArrayList();
            array.add(Stadium_ID) ;
            array.add(teamId1) ;
            array.add(teamId2) ;
            
           lSchedule.put(i, array);
           
           i = i + 1 ; 
            
        }
        
      
        
        stmt=cnx.createStatement(); 
        
        // select Schedule

        
        rs=stmt.executeQuery("select * from teams");
        
        while(rs.next())  
        {
            int teamId = rs.getInt(1) ;
            String Team_Name = rs.getString(2) ;
            String City_State = rs.getString(3) ;
            String gm = rs.getString(4) ;
            
            
            ArrayList<Object> array = new ArrayList();
            array.add(Team_Name) ;
            array.add(City_State) ;
            array.add(gm) ;
            
           lTeams.put(teamId, array);
            
        }
        
        stmt=cnx.createStatement(); 
        
        // select Schedule
        
        
        rs=stmt.executeQuery("select * from Stadium ");
        
        while(rs.next())  
        {
            int stadiumId = rs.getInt(1) ;
            int Capacity = rs.getInt(2) ;
            String Stadium_Name = rs.getString(3) ;
            String Stadium_City = rs.getString(4) ;
            
            
            ArrayList<Object> array = new ArrayList();
            array.add(Capacity) ;
            array.add(Stadium_Name) ;
            array.add(Stadium_City) ;
            
            lStadium.put(stadiumId, array);
            
        }
        
         for (int j = 0 ; j < lSchedule.size() ; j++) {
             
             int stadiumId = (int) lSchedule.get(j).get(0) ;
             int team1Id = (int) lSchedule.get(j).get(1) ; 
             int team2Id = (int) lSchedule.get(j).get(2) ; 
             
             String TeamName1 = (String) lTeams.get(team1Id).get(0) ;
             String TeamCity1 = (String) lTeams.get(team1Id).get(1) ;
             String Teamgm1 = (String) lTeams.get(team1Id).get(2) ;
             
             String TeamName2 = (String) lTeams.get(team2Id).get(0) ;
             String TeamCity2 = (String) lTeams.get(team2Id).get(1) ;
             String Teamgm2 = (String) lTeams.get(team2Id).get(2) ;
             
             int stadiumCapacity = (int) lStadium.get(stadiumId).get(0);
             String Stadium_Name = (String) lStadium.get(stadiumId).get(1);
             String Stadium_City = (String) lStadium.get(stadiumId).get(2);
             
             teamStadium t1 = new teamStadium();
             t1.setCapacity(stadiumCapacity);
             t1.setGm(Teamgm1);
             t1.setTeamName(TeamName1);
             t1.setTeamCity(TeamCity1);
             t1.setStatium(Stadium_Name);
             t1.setStatiumCity(Stadium_City);
             
             teamStadium t2 = new teamStadium();
             t2.setCapacity(stadiumCapacity);
             t2.setGm(Teamgm2);
             t2.setTeamName(TeamName2);
             t2.setTeamCity(TeamCity2);
             t2.setStatium(Stadium_Name);
             t2.setStatiumCity(Stadium_City);
             
             
             list.add(t1) ;
             list.add(t2) ;
  
             
         }

        }catch(Exception e){ System.out.println(e);}  

        
        return list ; 
        
    }
}
