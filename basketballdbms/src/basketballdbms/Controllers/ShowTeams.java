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
import basketballdbms.Services.TeamService;

/**
 *
 * @author cps510
 */
public class ShowTeams extends Application{

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
    

        
    TableView tableView = new TableView();

    TableColumn<Team, String> columnRank = new TableColumn<>("RANK");
    columnRank.setCellValueFactory(new PropertyValueFactory<>("rank"));

    TableColumn<Team, String> columnName = new TableColumn<>("NAME");
    columnName.setCellValueFactory(new PropertyValueFactory<>("name"));

    TableColumn<Team, String> columnWins = new TableColumn<>("W");
    columnWins.setCellValueFactory(new PropertyValueFactory<>("wins"));
    
    TableColumn<Team, String> columnLoses = new TableColumn<>("L");
    columnLoses.setCellValueFactory(new PropertyValueFactory<>("loses"));
    
    TableColumn<Team, String> columnPct = new TableColumn<>("PCT");
    columnPct.setCellValueFactory(new PropertyValueFactory<>("pct"));
    
    
    tableView.getColumns().add(columnRank);
    tableView.getColumns().add(columnName);
    tableView.getColumns().add(columnWins);
    tableView.getColumns().add(columnLoses);
    tableView.getColumns().add(columnPct);
    
    // get list of teams 
    
    TeamService teamService = new TeamService() ;

    List<Team> listTeams = teamService.getListTeams() ;

    
    tableView.getItems().addAll(listTeams);
    
    HBox hBox = new HBox(buttonTeams,buttonStatTeams,buttonPlayerStat,buttonStadium,buttonSQL);
    
    hBox.setAlignment(Pos.CENTER);


    VBox vbox = new VBox(hBox,tableView);

    Scene scene = new Scene(vbox);
    primaryStage.setScene(scene);
    
    tableView.setStyle("-fx-background-color: #16374A; -fx-text-fill: white; -fx-background-color: #16374A;");
    
    columnRank.setStyle("  -fx-alignment: CENTER; -fx-font-weight: bold;");
    columnName.setStyle("  -fx-alignment: CENTER; -fx-font-weight: bold;");
    columnWins.setStyle("  -fx-alignment: CENTER; -fx-font-weight: bold;");
    columnLoses.setStyle("  -fx-alignment: CENTER; -fx-font-weight: bold;");
    columnPct.setStyle("  -fx-alignment: CENTER; -fx-font-weight: bold;");
    
    primaryStage.setWidth(850);
    primaryStage.setHeight(500);
    
    primaryStage.show();
        
    }
    
}
