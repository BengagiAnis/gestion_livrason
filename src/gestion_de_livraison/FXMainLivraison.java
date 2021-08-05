/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_de_livraison;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
/**
 *
 * @author anous
 */
public class FXMainLivraison extends Application {
    
    
   
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        
        Parent root = FXMLLoader.load(getClass().getResource("..//GUI/FXMLlogin.fxml"));
        primaryStage.setTitle("lOGIN");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
 
    }
    public static void main(String[] args) {
        launch(args);
    }

}
