/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballdbms.Controllers;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import basketballdbms.Services.GlobalService;

/**
 *
 * @author cps510
 */
public class showActions extends Application{

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
        GlobalService globalService = new GlobalService() ;

        
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
        
        
        Label label = new Label("");
        
        Button buttonDropTables = new Button("Drop tables");   
        buttonDropTables.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event)  {
            try {
                  globalService.dropTables();
                  label.setText("tables deleted");
            } catch (Exception ex) {
                
            }
        }
        });
        
        Button buttonCreateTables = new Button("Create tables");   
        buttonCreateTables.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event)  {
            try {
                  globalService.createTables();
                  label.setText("tables created");
            } catch (Exception ex) {
                Logger.getLogger(ShowTeams.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        });
        
        Button buttonPopulateTables = new Button("Populate tables");   
        buttonPopulateTables.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event)  {
            try {
                 
                   globalService.populateData();
                   label.setText("tables Populated");
            } catch (Exception ex) {
                System.out.println("error");
            }
        }
        });
        
        Button buttonQueryTables = new Button("Query tables");   
        buttonQueryTables.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event)  {
            try {
                int numberPlayers = globalService.firstQuery() ; 
                int numberTeams = globalService.secondQuery() ; 
                String firstString = "total players is : " + numberPlayers ; 
                String secondString = "total teams is : " + numberTeams ;  
                label.setText(firstString + "\n" + secondString);
                   
            } catch (Exception ex) {
                Logger.getLogger(ShowTeams.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        });
        
        HBox hBox2 = new HBox(buttonTeams,buttonStatTeams,buttonPlayerStat,buttonStadium,buttonSQL);
        hBox2.setAlignment(Pos.TOP_CENTER);
        
        HBox hBox = new HBox(buttonDropTables,buttonCreateTables,buttonPopulateTables,buttonQueryTables);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(150, 100, 0, 50)) ;
        VBox vBox = new VBox(hBox2,hBox,label) ;
        vBox.setAlignment(Pos.TOP_CENTER);
        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
