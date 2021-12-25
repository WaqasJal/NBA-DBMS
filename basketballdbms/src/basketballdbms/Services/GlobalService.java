/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballdbms.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import basketballdbms.Utils.MaConnection;

/**
 *
 * @author cps510
 */
public class GlobalService {
    
    
    public void dropTables() {
        MaConnection maConnection = MaConnection.getInstance();
        Connection cnx = maConnection.getCnx() ;
        
         try {
            
         Statement stmt=cnx.createStatement();  
         stmt.addBatch("drop table Schedule ");         
         stmt.addBatch("drop table Stadium ");   
         stmt.addBatch("drop table Team_Stats ");   
         stmt.addBatch("drop table player_Stats ");   
         stmt.addBatch("drop table teams ");   
         stmt.addBatch("drop table players ");   
     
         stmt.executeBatch() ;
         System.out.println("deleted");

         } catch (Exception e) 
         {
             System.out.println(e.getMessage());
         }
    }
    
    public void createTables() {
        MaConnection maConnection = MaConnection.getInstance();
        Connection cnx = maConnection.getCnx() ;
        
         try {
                Statement stmt=cnx.createStatement();  
                stmt.addBatch("create table players ( Player_ID int, Name varchar(200), Height int, Weight int, Position varchar(10), Jersy_No int, Team_name varchar(200), Primary key (Player_ID) ) ");
                
                stmt.addBatch("create table teams( Team_ID int, Team_Name varchar(200), City_State varchar(100), gm varchar(100), Primary Key(Team_ID) ) ");
                
                stmt.addBatch("create table Player_Stats ( Player_ID int, Blocks int, Steals int, Avg_Points int, Total_Points int, Games_Played int, assists int, rebounds int, FreeThrowPercent int, Foreign key (Player_ID) references Players(Player_ID) )  ");
                
                stmt.addBatch("create table Team_Stats ( Team_ID int, Wins int, Losses int, Total_Points int, Steals int, Rebounds int, Assists int, Blocks int, FT_Percentage int, Foreign Key(Team_ID) references Teams (Team_ID) ) ");
                
                stmt.addBatch("create table Stadium ( Stadium_ID int, Capacity int, Stadium_Name varchar(100), Stadium_City varchar(100), Primary Key(Stadium_ID) )");
                
                stmt.addBatch("create table Schedule ( Match_ID int, Stadium_ID int, Team_ID_1 int, Team_ID_2 int, Match_Name varchar(100), DateTime_Schedule date, Primary Key(Match_ID), Foreign Key(Stadium_ID) references Stadium (Stadium_ID) ) ");
                stmt.executeBatch();
                System.out.println("tables created");
         } catch (Exception e) 
         {
             System.out.println(e.getMessage());
         }
    }
    
    public void populateData() {
        MaConnection maConnection = MaConnection.getInstance();
        Connection cnx = maConnection.getCnx() ;
        
         try {
                Statement stmt=cnx.createStatement(); 
                stmt.addBatch("insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )\n" +
"values (1,'LeBron James',202,250,'SF',6,'Lakers')");
                stmt.addBatch("insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )\n" +
"values (2,'Anthony Davis',208,253,'PF',3,'Lakers')");
                stmt.addBatch("insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )\n" +
"values (3,'Russel Westbrook',190,200,'PG',0,'Lakers')");
                stmt.addBatch("insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )\n" +
"values (4,'Dwight Howard',208,265,'C',39,'Lakers')");
                stmt.addBatch("insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )\n" +
"values (5,'Kent Bazemore',193,195,'SG',9,'Lakers')");
                
                stmt.addBatch("insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )\n" +
"values (6,'Stephen Curry',190,185,'PG',30,'Warriors')");
                stmt.addBatch("insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )\n" +
"values (7,'Klay Thompson',198,215,'SG',11,'Warriors')");
                stmt.addBatch("insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )\n" +
"values (8,'Draymond Green',198,230,'PF',23,'Warriors')");
                stmt.addBatch("insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )\n" +
"values (9,'Andrew Wiggins',201,197,'PF',22,'Warriors')");
                stmt.addBatch("insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )\n" +
"values (10,'Kevon Looney',206,222,'C',5,'Warriors')");
               
                stmt.addBatch("insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )\n" +
"values (11,'Chris Boucher',206,200,'C',25,'Raptors')");
                stmt.addBatch("insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )\n" +
"values (12,'Fred Vanvleet',185,197,'SG',23,'Raptors')");
                stmt.addBatch("insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )\n" +
"values (13,'OG Anunoby',201,232,'SF',3,'Raptors')");
                stmt.addBatch("insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )\n" +
"values (14,'Goran Dragic',190,190,'PG',1,'Raptors')");
                stmt.addBatch("insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )\n" +
"values (15,'Pascal Siakam',206,230,'PF',43,'Raptors')");
                
                stmt.addBatch("insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )\n" +
"values (16,'Kevin Durant',208,240,'PF',7,'Nets')");
                stmt.addBatch("insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )\n" +
"values (17,'James Harden',196,220,'PG',13,'Nets')");
                stmt.addBatch("insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )\n" +
"values (18,'Blake Griffin',206,250,'PF',2,'Nets')");
                stmt.addBatch("insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )\n" +
"values (19,'LaMarcus Aldrige',211,250,'C',21,'Nets')");
                stmt.addBatch("insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )\n" +
"values (20,'Kyrie Irving',188,195,'PG',11,'Nets')");
                
                stmt.addBatch("insert into Teams (Team_ID,Team_Name,City_State,gm)\n" +
"values (1,'Lakers','Los Angeles','Rob Pelinka')");
                stmt.addBatch("insert into Teams (Team_ID,Team_Name,City_State,gm)\n" +
"values (2,'Warriors','San Francisco','Bob Myers')");
                stmt.addBatch("insert into Teams (Team_ID,Team_Name,City_State,gm)\n" +
"values (3,'Raptors','Toronto','Bobby Webster')");
                stmt.addBatch("insert into Teams (Team_ID,Team_Name,City_State,gm)\n" +
"values (4,'Nets','Brooklyn','Sean Marks')");
                
                stmt.addBatch("insert into Player_Stats \n" +
"(Player_ID, Avg_Points, Assists, Rebounds, Blocks, Steals, Total_Points, Games_Played, FreeThrowPercent)\n" +
"values (1, 26, 6, 5.5, 1.1, 1.7, 35471, 1314, 76.5)");
                stmt.addBatch("insert into Player_Stats \n" +
"(Player_ID, Avg_Points, Assists, Rebounds, Blocks, Steals, Total_Points, Games_Played, FreeThrowPercent)\n" +
"values (2, 26.2, 2.7, 11.2, 2.5, 0.7, 13620, 570, 73.7)");
                stmt.addBatch("insert into Player_Stats \n" +
"(Player_ID, Avg_Points, Assists, Rebounds, Blocks, Steals, Total_Points, Games_Played, FreeThrowPercent)\n" +
"values (3, 18, 8.7, 8.8, 0.2, 1.7, 21965, 949, 50)");
                stmt.addBatch("insert into Player_Stats \n" +
"(Player_ID, Avg_Points, Assists, Rebounds, Blocks, Steals, Total_Points, Games_Played, FreeThrowPercent)\n" +
"values (4, 4.3, 0.5, 4, 0.5, 1, 19139, 1188, 81.8)");
                stmt.addBatch("insert into Player_Stats \n" +
"(Player_ID, Avg_Points, Assists, Rebounds, Blocks, Steals, Total_Points, Games_Played, FreeThrowPercent)\n" +
"values (5, 7.2, 1.3, 2, 0.5, 1, 5325, 624, 66.7)");
                
                stmt.addBatch("insert into Player_Stats \n" +
"(Player_ID, Avg_Points, Assists, Rebounds, Blocks, Steals, Total_Points, Games_Played, FreeThrowPercent)\n" +
"values (6, 28.7, 6.5, 7.5, 0.3, 1.5, 18606, 768, 97.1)");
                stmt.addBatch("insert into Player_Stats \n" +
"(Player_ID, Avg_Points, Assists, Rebounds, Blocks, Steals, Total_Points, Games_Played, FreeThrowPercent)\n" +
"values (7, 19.5, 2.3, 3.5, 0.6, 1.1, 11995, 615, 84.4)");
                stmt.addBatch("insert into Player_Stats \n" +
"(Player_ID, Avg_Points, Assists, Rebounds, Blocks, Steals, Total_Points, Games_Played, FreeThrowPercent)\n" +
"values (8, 9.3, 7, 8.7, 1.2, 1.3, 5670, 645, 36.8)");
                stmt.addBatch("insert into Player_Stats \n" +
"(Player_ID, Avg_Points, Assists, Rebounds, Blocks, Steals, Total_Points, Games_Played, FreeThrowPercent)\n" +
"values (9, 16.2, 1.7, 4.5, 0.5, 1.2, 10360, 531, 69.2)");
                stmt.addBatch("insert into Player_Stats \n" +
"(Player_ID, Avg_Points, Assists, Rebounds, Blocks, Steals, Total_Points, Games_Played, FreeThrowPercent)\n" +
"values (10, 6.2, 0.7, 5.5, 0.5, 0.4, 1267, 291, 70)");
                
                stmt.addBatch("insert into Team_Stats\n" +
"(Team_ID,Wins,Losses,Total_Points,Steals,Rebounds,Assists,Blocks,FT_Percentage)\n" +
"values (1,4,1,900,200,775,1000,80,65)");
                stmt.addBatch("insert into Team_Stats\n" +
"(Team_ID,Wins,Losses,Total_Points,Steals,Rebounds,Assists,Blocks,FT_Percentage)\n" +
"values (2,3,3,870,220,705,1350,50,79)");
                stmt.addBatch("insert into Team_Stats\n" +
"(Team_ID,Wins,Losses,Total_Points,Steals,Rebounds,Assists,Blocks,FT_Percentage)\n" +
"values (3,3,2,790,300,580,1100,70,71)");
                stmt.addBatch("insert into Team_Stats\n" +
"(Team_ID,Wins,Losses,Total_Points,Steals,Rebounds,Assists,Blocks,FT_Percentage)\n" +
"values (4,5,2,905,255,620,1040,90,73)");
                
                stmt.addBatch("Insert into Stadium (Stadium_ID, Capacity, Stadium_Name, Stadium_City)\n" +
"Values (1,20000,'Staples Center', 'Los Angeles')");
                stmt.addBatch("Insert into Stadium (Stadium_ID,Capacity,Stadium_Name, Stadium_City)\n" +
"Values (2,18000,'Chase Center', 'San Francisco')");
                stmt.addBatch("Insert into Stadium (Stadium_ID,Capacity,Stadium_Name, Stadium_City)\n" +
"Values (3,19800,'Scotiabank Arena', 'Toronto')");
                stmt.addBatch("Insert into Stadium (Stadium_ID,Capacity,Stadium_Name, Stadium_City)\n" +
"Values (4,19000,'Barclays Center', 'Brooklyn')");
                stmt.addBatch("Insert into Stadium (Stadium_ID,Capacity,Stadium_Name, Stadium_City)\n" +
"Values (5,20800,'Madison Square Garden', 'New York')");
                stmt.addBatch("Insert into Stadium (Stadium_ID,Capacity,Stadium_Name, Stadium_City)\n" +
"Values (6,23500,'United Center', 'Chicago')");
                
                stmt.addBatch("Insert into Schedule (Match_ID, Stadium_ID, Team_ID_1,Team_ID_2, Match_Name, DateTime_Schedule)\n" +
"Values (1,1,1,2,'Lakers vs Warriors',TO_DATE('10/08/2021', 'DD/MM/YYYY'))");
                stmt.addBatch("Insert into Schedule (Match_ID, Stadium_ID, Team_ID_1,Team_ID_2, Match_Name, DateTime_Schedule)\n" +
"Values (2,3,3,4,'Raptors vs Nets',TO_DATE('14/08/2021', 'DD/MM/YYYY'))");
                stmt.addBatch("Insert into Schedule (Match_ID, Stadium_ID, Team_ID_1,Team_ID_2, Match_Name, DateTime_Schedule)\n" +
"Values (3,5,3,1,'Raptors vs Lakers',TO_DATE('19/08/2021', 'DD/MM/YYYY'))");
                stmt.addBatch("Insert into Schedule (Match_ID, Stadium_ID, Team_ID_1,Team_ID_2, Match_Name, DateTime_Schedule)\n" +
"Values (4,4,4,2,'Nets vs Warriors',TO_DATE('22/08/2021', 'DD/MM/YYYY'))");
                stmt.addBatch("Insert into Schedule (Match_ID, Stadium_ID, Team_ID_1,Team_ID_2, Match_Name, DateTime_Schedule)\n" +
"Values (5,6,1,4,'Lakers vs Nets',TO_DATE('27/08/2021', 'DD/MM/YYYY'))");
                stmt.addBatch("Insert into Schedule (Match_ID, Stadium_ID, Team_ID_1,Team_ID_2, Match_Name, DateTime_Schedule)\n" +
"Values (6,2,2,3,'Warriors vs Raptors',TO_DATE('02/09/2021', 'DD/MM/YYYY'))");
                
                
                
                
                stmt.executeBatch(); 
               System.out.println("data inserted");
                
 
                
         } catch (Exception e) 
         {
             System.out.println(e.getMessage());
         }
    }
    
    
    public int firstQuery() {
        MaConnection maConnection = MaConnection.getInstance();
        Connection cnx = maConnection.getCnx() ;
        
         try {
             
             Statement stmt=cnx.createStatement(); 
             ResultSet rs=stmt.executeQuery("select count(*) from players");  
             rs.next() ;
             int numberPlayers = rs.getInt(1) ; 
             return numberPlayers ;
         
             
         
         } catch (Exception e)
         {
             System.out.println(e.getMessage());
         }
         return 0 ; 
    }
    
    public int secondQuery() {
        MaConnection maConnection = MaConnection.getInstance();
        Connection cnx = maConnection.getCnx() ;
        
         try {
             Statement stmt=cnx.createStatement(); 
             ResultSet rs = stmt.executeQuery("select count(*) from teams" );
             rs.next() ;
             int numberteams = rs.getInt(1) ; 
             return numberteams ; 
       
             
         } catch (Exception e)
         {
             System.out.println(e.getMessage());
         }
         return 0 ;
    }
    
            
    
    
    
}
