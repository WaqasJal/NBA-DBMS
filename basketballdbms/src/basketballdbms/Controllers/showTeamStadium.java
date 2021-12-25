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
import basketballdbms.Entities.TeamStat;
import basketballdbms.Entities.teamStadium;
import basketballdbms.Services.TeamService;

/**
 *
 * @author cps510
 */
public class showTeamStadium extends Application{

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
        
        
        TeamService teamService = new TeamService()  ;
        List<teamStadium> list = teamService.getTeamsTadium();

        
        TableView tableView = new TableView();

        TableColumn<teamStadium, Integer> columnteamName = new TableColumn<>("teamName");
        columnteamName.setCellValueFactory(new PropertyValueFactory<>("teamName"));
        
        TableColumn<teamStadium, String> columnteamCity = new TableColumn<>("teamCity");
        columnteamCity.setCellValueFactory(new PropertyValueFactory<>("teamCity"));

        TableColumn<teamStadium, Integer> columngm = new TableColumn<>("gm");
        columngm.setCellValueFactory(new PropertyValueFactory<>("gm"));

        TableColumn<teamStadium, Integer> columnstatium = new TableColumn<>("statium");
        columnstatium.setCellValueFactory(new PropertyValueFactory<>("statium"));

        TableColumn<teamStadium, Integer> columncapacity = new TableColumn<>("capacity");
        columncapacity.setCellValueFactory(new PropertyValueFactory<>("capacity"));

        TableColumn<teamStadium, Integer> columnstatiumCity = new TableColumn<>("statiumCity");
        columnstatiumCity.setCellValueFactory(new PropertyValueFactory<>("statiumCity"));


        tableView.getColumns().add(columnteamName);        
        tableView.getColumns().add(columnteamCity); 
        tableView.getColumns().add(columngm); 
        tableView.getColumns().add(columnstatium); 
        tableView.getColumns().add(columncapacity); 
        tableView.getColumns().add(columnstatiumCity); 
        
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
