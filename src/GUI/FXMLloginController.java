/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.User;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.swing.JOptionPane;
import service.UserService;
import static sun.security.jgss.GSSUtil.login;
import utile.DataConnection;

/**
 * FXML Controller class
 *
 * @author anous
 */
public class FXMLloginController implements Initializable {

    @FXML
    private TextField txtauthentification;
    @FXML
    private TextField txtpasse;
    @FXML
    private Button btnauthentification;
    @FXML
    private Text erreur;
    ImageView iv = new ImageView();
   
    
    

    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

       
        

    @FXML
    private void Connecter(ActionEvent event) throws SQLException, IOException {
         
        String login = txtauthentification.getText();
        String passe= txtpasse.getText();
         System.out.println(login);
        System.out.println(passe);
        if (login.equals("") ||  passe.equals("")) {
      JOptionPane.showMessageDialog(null, "Remplire toutes champs svlp");
        } else {
            UserService us = new UserService();    
            User u = new User();            
            u.setLogin(login);
            u.setPass(passe);
            
            if (us.Connecter(login, passe)) {
             
                JOptionPane.showConfirmDialog(null, "connecté avec succées");
                Stage stage = (Stage) btnauthentification.getScene().getWindow();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("FXMLAceuilPage.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(FXMLloginController.class.getName()).log(Level.SEVERE, null, ex);      //login controller this function 
                }
                stage.setScene(new Scene(root));

            } else {
           erreur.visibleProperty().set(true);
               txtauthentification.clear();
             txtpasse.clear();
            }

        }
    }
        }
    


    
    
    

            
            
     
     
        
         
               
           
         
