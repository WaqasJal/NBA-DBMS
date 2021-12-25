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
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import basketballdbms.Entities.PlayerStat;
import basketballdbms.Entities.TeamStat;
import basketballdbms.Services.playerService;

/**
 *
 * @author cps510
 */
public class ShowPlayersStat extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        
    
        playerService playService = new playerService() ;
        List<PlayerStat> list = playService.getListPlayers() ; 

        
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

        TableColumn<PlayerStat, Integer> columnRank = new TableColumn<>("RANK");
        columnRank.setCellValueFactory(new PropertyValueFactory<>("rank"));
        
        TableColumn<PlayerStat, Integer> columnid = new TableColumn<>("id");
        columnid.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<PlayerStat, String> columnplayerName = new TableColumn<>("playerName");
        columnplayerName.setCellValueFactory(new PropertyValueFactory<>("playerName"));

        TableColumn<PlayerStat, String> columnplayerTeam = new TableColumn<>("playerTeam");
        columnplayerTeam.setCellValueFactory(new PropertyValueFactory<>("playerTeam"));       
        
        TableColumn<PlayerStat, Integer> columnavgPoints = new TableColumn<>("avgPoints");
        columnavgPoints.setCellValueFactory(new PropertyValueFactory<>("avgPoints"));

        TableColumn<PlayerStat, Integer> columntotalPoints = new TableColumn<>("totalPoints");
        columntotalPoints.setCellValueFactory(new PropertyValueFactory<>("totalPoints"));

        TableColumn<PlayerStat, Integer> columntotalgamesPlayed = new TableColumn<>("gamesPlayed");
        columntotalgamesPlayed.setCellValueFactory(new PropertyValueFactory<>("gamesPlayed"));
        
        TableColumn<PlayerStat, Integer> columnsteals = new TableColumn<>("steals");
        columnsteals.setCellValueFactory(new PropertyValueFactory<>("steals"));

        TableColumn<PlayerStat, Integer> columnblocks = new TableColumn<>("blocks");
        columnblocks.setCellValueFactory(new PropertyValueFactory<>("blocks"));

        TableColumn<PlayerStat, Integer> columnassists = new TableColumn<>("assists");
        columnassists.setCellValueFactory(new PropertyValueFactory<>("assists"));  

        TableColumn<PlayerStat, Integer> columnrebounds = new TableColumn<>("rebounds");
        columnrebounds.setCellValueFactory(new PropertyValueFactory<>("rebounds"));  

        TableColumn<PlayerStat, Integer> columnftPercent = new TableColumn<>("ftPercent");
        columnftPercent.setCellValueFactory(new PropertyValueFactory<>("ftPercent"));          

        tableView.getColumns().add(columnRank);        
        tableView.getColumns().add(columnid); 
        tableView.getColumns().add(columnplayerName); 
        tableView.getColumns().add(columnplayerTeam); 
        tableView.getColumns().add(columnavgPoints); 
        tableView.getColumns().add(columntotalPoints); 
        tableView.getColumns().add(columntotalgamesPlayed); 
        tableView.getColumns().add(columnsteals); 
        tableView.getColumns().add(columnblocks); 
        tableView.getColumns().add(columnassists); 
        tableView.getColumns().add(columnrebounds);
        tableView.getColumns().add(columnftPercent);
        
        tableView.getItems().addAll(list) ;
        
        
        tableView.setRowFactory(tv -> {
        TableRow<PlayerStat> row = new TableRow<>();
        row.setOnMouseClicked(event -> {
            if (! row.isEmpty() && event.getButton()==MouseButton.PRIMARY 
                 && event.getClickCount() == 2) {

                try {
                    PlayerStat clickedRow = row.getItem();
                    ShowPlayerInfo showPlayerInfo = new ShowPlayerInfo(clickedRow.getId());
                    showPlayerInfo.start(primaryStage);
                } catch (Exception ex) {
                    Logger.getLogger(ShowPlayersStat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        return row ;
        });

        


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
