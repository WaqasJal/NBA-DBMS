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
)

create  table Teams(
Team_ID int,
Team_Name varchar(200),
City_State varchar(100),
gm varchar(100),
Primary Key(Team_ID)
)

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
)

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
)

create table Stadium 
(
Stadium_ID int,
Capacity int,
Stadium_Name varchar(100),
Stadium_City varchar(100),
Primary Key(Stadium_ID)
)


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
)

------------------------------------------------------------------ POPULATE

insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )
values (1,'LeBron James',202,250,'SF',6,'Lakers');
insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )
values (2,'Anthony Davis',208,253,'PF',3,'Lakers');
insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )
values (3,'Russel Westbrook',190,200,'PG',0,'Lakers');
insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )
values (4,'Dwight Howard',208,265,'C',39,'Lakers');
insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )
values (5,'Kent Bazemore',193,195,'SG',9,'Lakers');

insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )
values (6,'Stephen Curry',190,185,'PG',30,'Warriors');
insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )
values (7,'Klay Thompson',198,215,'SG',11,'Warriors');
insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )
values (8,'Draymond Green',198,230,'PF',23,'Warriors');
insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )
values (9,'Andrew Wiggins',201,197,'PF',22,'Warriors');
insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )
values (10,'Kevon Looney',206,222,'C',5,'Warriors');

insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )
values (11,'Chris Boucher',206,200,'C',25,'Raptors');
insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )
values (12,'Fred Vanvleet',185,197,'SG',23,'Raptors');
insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )
values (13,'OG Anunoby',201,232,'SF',3,'Raptors');
insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )
values (14,'Goran Dragic',190,190,'PG',1,'Raptors');
insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )
values (15,'Pascal Siakam',206,230,'PF',43,'Raptors');

insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )
values (16,'Kevin Durant',208,240,'PF',7,'Nets');
insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )
values (17,'James Harden',196,220,'PG',13,'Nets');
insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )
values (18,'Blake Griffin',206,250,'PF',2,'Nets');
insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )
values (19,'LaMarcus Aldrige',211,250,'C',21,'Nets');
insert into Players (Player_ID, Name,Height,Weight,Position,Jersy_No, Team_name )
values (20,'Kyrie Irving',188,195,'PG',11,'Nets');


insert into Teams (Team_ID,Team_Name,City_State,gm)
values (1,'Lakers','Los Angeles','Rob Pelinka');
insert into Teams (Team_ID,Team_Name,City_State,gm)
values (2,'Warriors','San Francisco','Bob Myers');
insert into Teams (Team_ID,Team_Name,City_State,gm)
values (3,'Raptors','Toronto','Bobby Webster');
insert into Teams (Team_ID,Team_Name,City_State,gm)
values (4,'Nets','Brooklyn','Sean Marks');


insert into Player_Stats 
(Player_ID, Avg_Points, Assists, Rebounds, Blocks, Steals, Total_Points, Games_Played, FreeThrowPercent)
values (1, 26, 6, 5.5, 1.1, 1.7, 35471, 1314, 76.5);
insert into Player_Stats 
(Player_ID, Avg_Points, Assists, Rebounds, Blocks, Steals, Total_Points, Games_Played, FreeThrowPercent)
values (2, 26.2, 2.7, 11.2, 2.5, 0.7, 13620, 570, 73.7);
insert into Player_Stats 
(Player_ID, Avg_Points, Assists, Rebounds, Blocks, Steals, Total_Points, Games_Played, FreeThrowPercent)
values (3, 18, 8.7, 8.8, 0.2, 1.7, 21965, 949, 50);
insert into Player_Stats 
(Player_ID, Avg_Points, Assists, Rebounds, Blocks, Steals, Total_Points, Games_Played, FreeThrowPercent)
values (4, 4.3, 0.5, 4, 0.5, 1, 19139, 1188, 81.8);
insert into Player_Stats 
(Player_ID, Avg_Points, Assists, Rebounds, Blocks, Steals, Total_Points, Games_Played, FreeThrowPercent)
values (5, 7.2, 1.3, 2, 0.5, 1, 5325, 624, 66.7);

insert into Player_Stats 
(Player_ID, Avg_Points, Assists, Rebounds, Blocks, Steals, Total_Points, Games_Played, FreeThrowPercent)
values (6, 28.7, 6.5, 7.5, 0.3, 1.5, 18606, 768, 97.1);
insert into Player_Stats 
(Player_ID, Avg_Points, Assists, Rebounds, Blocks, Steals, Total_Points, Games_Played, FreeThrowPercent)
values (7, 19.5, 2.3, 3.5, 0.6, 1.1, 11995, 615, 84.4);
insert into Player_Stats 
(Player_ID, Avg_Points, Assists, Rebounds, Blocks, Steals, Total_Points, Games_Played, FreeThrowPercent)
values (8, 9.3, 7, 8.7, 1.2, 1.3, 5670, 645, 36.8);
insert into Player_Stats 
(Player_ID, Avg_Points, Assists, Rebounds, Blocks, Steals, Total_Points, Games_Played, FreeThrowPercent)
values (9, 16.2, 1.7, 4.5, 0.5, 1.2, 10360, 531, 69.2);
insert into Player_Stats 
(Player_ID, Avg_Points, Assists, Rebounds, Blocks, Steals, Total_Points, Games_Played, FreeThrowPercent)
values (10, 6.2, 0.7, 5.5, 0.5, 0.4, 1267, 291, 70);

insert into Player_Stats 
(Player_ID, Avg_Points, Assists, Rebounds, Blocks, Steals, Total_Points, Games_Played, FreeThrowPercent)
values (11, 6.1, 0.3, 4.4, 1, 1, 1365, 158, 62.5);
insert into Player_Stats 
(Player_ID, Avg_Points, Assists, Rebounds, Blocks, Steals, Total_Points, Games_Played, FreeThrowPercent)
values (12, 17, 7.3, 5, 0.4, 1.6, 3554, 290, 70.6);
insert into Player_Stats 
(Player_ID, Avg_Points, Assists, Rebounds, Blocks, Steals, Total_Points, Games_Played, FreeThrowPercent)
values (13, 18, 2.9, 5.6, 0.7, 1.7, 2448, 260, 87.5);
insert into Player_Stats 
(Player_ID, Avg_Points, Assists, Rebounds, Blocks, Steals, Total_Points, Games_Played, FreeThrowPercent)
values (14, 6, 1.5, 2.3, 0.3, 0.8, 12070, 871, 100);
insert into Player_Stats 
(Player_ID, Avg_Points, Assists, Rebounds, Blocks, Steals, Total_Points, Games_Played, FreeThrowPercent)
values (15, 14.3, 2.7, 5.8, 0.7, 0.9, 4739, 332, 78.2);

insert into Player_Stats 
(Player_ID, Avg_Points, Assists, Rebounds, Blocks, Steals, Total_Points, Games_Played, FreeThrowPercent)
values (16, 27.7, 5.3, 8.9, 0.9, 0.9, 24077, 891, 79.5);
insert into Player_Stats 
(Player_ID, Avg_Points, Assists, Rebounds, Blocks, Steals, Total_Points, Games_Played, FreeThrowPercent)
values (17, 18.6, 8.6, 7.6, 1.0, 1.0, 22175, 884, 86.5);
insert into Player_Stats 
(Player_ID, Avg_Points, Assists, Rebounds, Blocks, Steals, Total_Points, Games_Played, FreeThrowPercent)
values (18, 4.8, 0.7, 4.8, 0.3, 0.5, 14013, 674, 77.8);
insert into Player_Stats 
(Player_ID, Avg_Points, Assists, Rebounds, Blocks, Steals, Total_Points, Games_Played, FreeThrowPercent)
values (19, 12.7, 0.3, 5.0, 1.2, 0.3, 20027, 1035, 61.5);
insert into Player_Stats 
(Player_ID, Avg_Points, Assists, Rebounds, Blocks, Steals, Total_Points, Games_Played, FreeThrowPercent)
values (20, 22.8, 5.7, 3.8, 0.7, 1.4, 13293, 582, 88.1);


insert into Team_Stats
(Team_ID,Wins,Losses,Total_Points,Steals,Rebounds,Assists,Blocks,FT_Percentage)
values (1,4,1,900,200,775,1000,80,65);
insert into Team_Stats
(Team_ID,Wins,Losses,Total_Points,Steals,Rebounds,Assists,Blocks,FT_Percentage)
values (2,3,3,870,220,705,1350,50,79);
insert into Team_Stats
(Team_ID,Wins,Losses,Total_Points,Steals,Rebounds,Assists,Blocks,FT_Percentage)
values (3,3,2,790,300,580,1100,70,71);
insert into Team_Stats
(Team_ID,Wins,Losses,Total_Points,Steals,Rebounds,Assists,Blocks,FT_Percentage)
values (4,5,2,905,255,620,1040,90,73);


Insert into Stadium (Stadium_ID, Capacity, Stadium_Name, Stadium_City)
Values (1,20000,'Staples Center', 'Los Angeles');
Insert into Stadium (Stadium_ID,Capacity,Stadium_Name, Stadium_City)
Values (2,18000,'Chase Center', 'San Francisco');
Insert into Stadium (Stadium_ID,Capacity,Stadium_Name, Stadium_City)
Values (3,19800,'Scotiabank Arena', 'Toronto');
Insert into Stadium (Stadium_ID,Capacity,Stadium_Name, Stadium_City)
Values (4,19000,'Barclays Center', 'Brooklyn');
Insert into Stadium (Stadium_ID,Capacity,Stadium_Name, Stadium_City)
Values (5,20800,'Madison Square Garden', 'New York');
Insert into Stadium (Stadium_ID,Capacity,Stadium_Name, Stadium_City)
Values (6,23500,'United Center', 'Chicago');


Insert into Schedule (Match_ID, Stadium_ID, Team_ID_1,Team_ID_2, Match_Name, DateTime_Schedule)
Values (1,1,1,2,'Lakers vs Warriors',TO_DATE('10/08/2021', 'DD/MM/YYYY'));
Insert into Schedule (Match_ID, Stadium_ID, Team_ID_1,Team_ID_2, Match_Name, DateTime_Schedule)
Values (2,3,3,4,'Raptors vs Nets',TO_DATE('14/08/2021', 'DD/MM/YYYY'));
Insert into Schedule (Match_ID, Stadium_ID, Team_ID_1,Team_ID_2, Match_Name, DateTime_Schedule)
Values (3,5,3,1,'Raptors vs Lakers',TO_DATE('19/08/2021', 'DD/MM/YYYY'));
Insert into Schedule (Match_ID, Stadium_ID, Team_ID_1,Team_ID_2, Match_Name, DateTime_Schedule)
Values (4,4,4,2,'Nets vs Warriors',TO_DATE('22/08/2021', 'DD/MM/YYYY'));
Insert into Schedule (Match_ID, Stadium_ID, Team_ID_1,Team_ID_2, Match_Name, DateTime_Schedule)
Values (5,6,1,4,'Lakers vs Nets',TO_DATE('27/08/2021', 'DD/MM/YYYY'));
Insert into Schedule (Match_ID, Stadium_ID, Team_ID_1,Team_ID_2, Match_Name, DateTime_Schedule)
Values (6,2,2,3,'Warriors vs Raptors',TO_DATE('02/09/2021', 'DD/MM/YYYY'));





