/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballdbms.Controllers;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import basketballdbms.Entities.Team;
import basketballdbms.Entities.TeamStat;
import basketballdbms.Services.TeamService;

/**
 *
 * @author cps510
 */
public class showTeamStat extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        
    Button buttonTeams = new Button("list Teams");   
    buttonTeams.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event)  {
            ShowPlayersStat showPlayersStat = new ShowPlayersStat() ;
            try {
                    ShowTeams showTeams = new ShowTeams();
                    showTeams.start(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(ShowTeams.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
    
    Button buttonStatTeams = new Button("list Stat of teams");   
    buttonStatTeams.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event)  {

            try {
                    showTeamStat sh = new showTeamStat() ;
                    sh.start(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(ShowTeams.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
    
        Button buttonPlayerStat = new Button("list of Players");   
        buttonPlayerStat.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event)  {

            try {
                    ShowPlayersStat showPlayersStat = new ShowPlayersStat() ;
                    showPlayersStat.start(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(ShowTeams.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
        
        
        Button buttonStadium = new Button("list Stadium Teams");   
        buttonStadium.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event)  {
            try {
                    showTeamStadium st = new showTeamStadium() ;
                    st.start(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(ShowTeams.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
        
        Button buttonSQL = new Button("Sql actions");   
        buttonSQL.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event)  {
            try {
                    showActions st = new showActions() ;
                    st.start(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(ShowTeams.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        });
        
        
        TeamService teamService = new TeamService() ; 
        List<TeamStat> list = teamService.getTeamStat() ; 


        TableView tableView = new TableView();

        TableColumn<TeamStat, Integer> columnRank = new TableColumn<>("RANK");
        columnRank.setCellValueFactory(new PropertyValueFactory<>("rank"));
        
        TableColumn<TeamStat, String> columnName = new TableColumn<>("name");
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<TeamStat, Integer> columnwins = new TableColumn<>("wins");
        columnwins.setCellValueFactory(new PropertyValueFactory<>("wins"));

        TableColumn<TeamStat, Integer> columnlosses = new TableColumn<>("losses");
        columnlosses.setCellValueFactory(new PropertyValueFactory<>("losses"));

        TableColumn<TeamStat, Integer> columntotalPoints = new TableColumn<>("totalPoints");
        columntotalPoints.setCellValueFactory(new PropertyValueFactory<>("totalPoints"));

        TableColumn<TeamStat, Integer> columnsteals = new TableColumn<>("steals");
        columnsteals.setCellValueFactory(new PropertyValueFactory<>("steals"));

        TableColumn<TeamStat, Integer> columnblocks = new TableColumn<>("blocks");
        columnblocks.setCellValueFactory(new PropertyValueFactory<>("blocks"));

        TableColumn<TeamStat, Integer> columnassists = new TableColumn<>("assists");
        columnassists.setCellValueFactory(new PropertyValueFactory<>("assists"));  

        TableColumn<TeamStat, Integer> columnrebounds = new TableColumn<>("rebounds");
        columnrebounds.setCellValueFactory(new PropertyValueFactory<>("rebounds"));  

        TableColumn<TeamStat, Integer> columnftPercent = new TableColumn<>("ftPercent");
        columnftPercent.setCellValueFactory(new PropertyValueFactory<>("ftPercent"));          

        tableView.getColumns().add(columnRank);        
        tableView.getColumns().add(columnName); 
        tableView.getColumns().add(columnwins); 
        tableView.getColumns().add(columnlosses); 
        tableView.getColumns().add(columntotalPoints); 
        tableView.getColumns().add(columnsteals); 
        tableView.getColumns().add(columnblocks); 
        tableView.getColumns().add(columnassists); 
        tableView.getColumns().add(columnrebounds); 
        tableView.getColumns().add(columnftPercent); 
        
        tableView.getItems().addAll(list) ;
        
        
        HBox hBox = new HBox(buttonTeams,buttonStatTeams,buttonPlayerStat,buttonStadium,buttonSQL);
        hBox.setAlignment(Pos.CENTER);
        VBox vbox = new VBox(hBox,tableView);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);


        primaryStage.setWidth(850);
        primaryStage.setHeight(500);

        primaryStage.show();
    }
    
}
