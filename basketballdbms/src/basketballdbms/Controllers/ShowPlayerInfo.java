/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballdbms.Controllers;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import basketballdbms.Entities.Player;
import basketballdbms.Services.playerService;

public class ShowPlayerInfo extends Application{
    
    private int id ;
    private Player player ; 
    
    public ShowPlayerInfo(int id) {
        this.id = id ; 
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        playerService ps = new playerService() ;
        Player p = ps.getPlayer(id) ; 
        System.out.println("found " + p);
        
        
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);
        VBox dialogVbox = new VBox(20);
        dialogVbox.getChildren().add(new Text("   Name : " + p.getName()));
        dialogVbox.getChildren().add(new Text("   Height : " + p.getHeight()));
        dialogVbox.getChildren().add(new Text("   Weight : " + p.getWeight()));
        dialogVbox.getChildren().add(new Text("   TeamName : " + p.getTeamName()));
        dialogVbox.getChildren().add(new Text("   Position : " + p.getPosition()));
        dialogVbox.getChildren().add(new Text("   Jersy_No : " + p.getJersy_No()));
        Scene dialogScene = new Scene(dialogVbox, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    
    
}
