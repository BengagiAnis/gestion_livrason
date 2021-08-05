/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Client;
import entite.User;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import service.ClientService;
import service.UserService;

/**
 * FXML Controller class
 *
 * @author anous
 */
public class FXMLajouteruserController implements Initializable {

    @FXML
    private TextField txtlog;
    @FXML
    private TextField txtpass;
    @FXML
    private Button adduser;
    @FXML
    private Label txtajoutersusces;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouteruser(ActionEvent event) throws SQLException {
        String login= txtlog.getText();
        String pass=txtpass.getText();
        
       
        
        if (login.equals("") || pass.equals("")
                 ) {
            JOptionPane.showMessageDialog(null, "Remplire toutes champs svp");
        } else {
            User u =new   User();
            UserService us=new UserService();
            u.setLogin(login);
            u.setPass(pass);
                        
            us.addUser(u);
            
            txtajoutersusces.setVisible(true);
           txtlog.clear();
           txtpass.clear();
                   
                
                       
            }
        
            }
}