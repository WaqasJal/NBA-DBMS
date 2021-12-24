#!/bin/sh
#export LD_LIBRARY_PATH=/usr/lib/oracle/12.1/client64/lib
sqlplus64 "wjalali/02189545@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(Host=oracle.scs.ryerson.ca)(Port=1521))(CONNECT_DATA=(SID=orcl)))"<<EOF

SELECT Name FROM Players WHERE height > 200;

SELECT Team_ID, Team_Name, gm FROM Teams WHERE Teams.City_State = 'Toronto'; 

SELECT Player_Stats.Player_ID, Players.Name, Position, Jersy_NO 
FROM Player_Stats, Players 
WHERE Player_Stats.Player_ID=Players.Player_ID and Player_Stats.Avg_Points > 20;

SELECT Team_Stats.Team_ID, Teams.Team_Name, Losses 
FROM Team_Stats, Teams  
WHERE Team_Stats.Team_ID=Teams.Team_ID and Team_Stats.Losses >= 2;

SELECT Stadium_ID, Stadium_Name, Capacity 
FROM Stadium WHERE Stadium_City = 'New York'

SELECT Schedule.Match_ID, Schedule.Match_Name, Stadium.Stadium_Name, Schedule.DateTime_Schedule 
FROM Schedule, Stadium 
WHERE Schedule.Stadium_ID = Stadium.Stadium_ID and Team_ID_1 = 2 and Team_ID_2 = 3;  

-- Queries Using DISTINCT, ORDER BY, and GROUP BY

SELECT DISTINCT Height FROM Players;

SELECT Weight, Name,Player_ID FROM Players ORDER BY Weight DESC;

SELECT COUNT(Assists), Player_ID FROM Player_Stats GROUP BY Player_ID ORDER BY COUNT(Assists) DESC;

--SELECT COUNT(Team_ID_1) FROM Schedule WHERE Team_ID_1 = 1 GROUP BY Match_ID ORDER BY COUNT(Team_ID_1) DESC;

exit;
EOF