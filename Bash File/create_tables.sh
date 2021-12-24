#!/bin/sh
#export LD_LIBRARY_PATH=/usr/lib/oracle/12.1/client64/lib
sqlplus64 "wjalali/02189545@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(Host=oracle.scs.ryerson.ca)(Port=1521))(CONNECT_DATA=(SID=orcl)))"<<EOF

create table Players
(
Player_ID int,
Name varchar(200),
Height int,
Weight int,
Position varchar(10),
Jersy_No int,
Team_name varchar(200),
Primary key (Player_ID)
);

create  table Teams(
Team_ID int,
Team_Name varchar(200),
City_State varchar(100),
gm varchar(100),
Primary Key(Team_ID)
);

create  table Player_Stats
(
--Player_Status_ID int,    NOT NEEDED
Player_ID int,
Blocks int,
Steals int,
Avg_Points int,
Total_Points int,
Games_Played int,
assists int,
rebounds int,
FreeThrowPercent int,
--primary key(Player_Status_ID),
Foreign key (Player_ID) references Players(Player_ID)
);

create table Team_Stats
(
--Team_Stats_ID int,   NOT NEEDED 
Team_ID int,
Wins int,
Losses int,
Total_Points int,
Steals int,
Rebounds int,
Assists int,
Blocks int,
FT_Percentage int,
--Primary Key(Team_Stats_ID),
Foreign Key(Team_ID) references Teams (Team_ID)
);

create table Stadium 
(
Stadium_ID int,
Capacity int,
Stadium_Name varchar(100),
Stadium_City varchar(100),
Primary Key(Stadium_ID)
);


create table Schedule 
(
Match_ID int,
Stadium_ID int,
Team_ID_1 int,
Team_ID_2 int,
Match_Name varchar(100),
DateTime_Schedule date,
Primary Key(Match_ID),
Foreign Key(Stadium_ID) references Stadium (Stadium_ID)
);


exit;
EOF