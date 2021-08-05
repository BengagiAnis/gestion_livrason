/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Client;
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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.ClientService;

/**
 * FXML Controller class
 *
 * @author anous
 */
public class FXMLAjouterClientController implements Initializable {

    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtprenom;
    @FXML
    private TextField txtadresse;
    @FXML
    private TextField txttelphone;
    @FXML
    private Button btnajouter;
    @FXML
    private Button btneffacer;
    @FXML
    private Button btnretour;
    @FXML
    private Text ajoutclientsecces;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterClient(ActionEvent event) throws SQLException {
           
        String nom = txtnom.getText();
        String prenom=txtprenom.getText();
        String adresse=txtadresse.getText();
        String telephone=txttelphone.getText();
        System.out.println(nom);
        System.out.println(prenom);
        
        if (nom.equals("") ||  prenom.equals("")||
                adresse.equals("") || telephone.equals("")) {
            JOptionPane.showMessageDialog(null, "Remplire toutes champs svp");
        } else {
            ClientService cli = new ClientService();    
            
            Client c = new Client(nom, prenom, adresse, telephone);            
            c.setNom(nom);
            c.setPrenom(prenom);
            c.setAdresse(adresse);
            c.setTelephone(telephone);
            
           cli.AjoutClient(c);
            
           
                   
                ajoutclientsecces.setVisible(true);
                txtnom.clear();
                txtprenom.clear();
                txtadresse.clear();
                txttelphone.clear();
           
                       
            }
        
            }

        
            
      

    @FXML
    private void Efacerchamp(ActionEvent event) {
        txtnom.clear();
        txtadresse.clear();
        txtprenom.clear();
        txttelphone.clear();
    }

    @FXML
    private void retournerAceuil(ActionEvent event) {
          Stage stage = (Stage) btnretour.getScene().getWindow();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("FXMLAceuilPage.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(FXMLloginController.class.getName()).log(Level.SEVERE, null, ex);      //login controller this function 
                }
                stage.setScene(new Scene(root));
 
    }
        
    }
    
