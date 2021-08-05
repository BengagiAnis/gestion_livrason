/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Client;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.ClientService;
import utile.DataConnection;

/**
 * FXML Controller class
 *
 * @author anous
 */
public class FXMLchercheClientController implements Initializable {
    
    
    private Connection connection;
    private Statement stat;
    private ResultSet rs;
    @FXML
    private Label labelNom;
    @FXML
    private Label labelPrenom;
    @FXML
    private Label labelAdresse;
    @FXML
    private Label labelTelephone;
    
    

    public FXMLchercheClientController() {
        connection=DataConnection.getInstance().getCnx();
   
        
    }

    @FXML
    private TextField txtIdClient;
    @FXML
    private TextField txtNomClient;
    @FXML
    private TextField txtPrenomClient;
    @FXML
    private TextField txtAdresseClient;
    @FXML
    private TextField txtTelephoneClient;
    @FXML
    private Button btnCherche;
    @FXML
    private Button btnSuprimerClient;
    @FXML
    private Button btnModifierClient;
    @FXML
    private Button btnAnuler;
    @FXML
    private Button btnAceuil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ChercherClient(ActionEvent event) throws SQLException {
        
        String text = txtIdClient.getText();
        if (text.equals(""))
          
        {
            JOptionPane.showMessageDialog(null, "Remplire le champ svp");
        } 
        else 
       {
           int id=Integer.parseInt(text);
         String req="select * from client where id_client='"+id+"'";
      try{
          stat=connection.createStatement();
          rs=stat.executeQuery(req);
          rs.last();
            
            int row=rs.getRow();
            if(row==1)
          
          
          {
             labelNom.setVisible(true);
             txtNomClient.setVisible(true);
             labelPrenom.setVisible(true);
             txtPrenomClient.setVisible(true);
             labelAdresse.setVisible(true);
             txtAdresseClient.setVisible(true);
             
             
             labelTelephone.setVisible(true);
             txtTelephoneClient.setVisible(true);
             
             btnAnuler.setVisible(true);
             btnModifierClient.setVisible(true);
             btnSuprimerClient.setVisible(true);
              String nom=rs.getString("nom");
              txtNomClient.setText(nom);
              String prenom=rs.getString("prenom");
              txtPrenomClient.setText(prenom);
             String adresse=rs.getString("adresse");
              txtAdresseClient.setText(adresse);
              String telephone=rs.getString("telph_client");
              txtTelephoneClient.setText(telephone);
             
             
             
                        
              
          }
            else{
                JOptionPane.showMessageDialog(null, "client introvable");
            }
          
      } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        
              
              
      }
       }
    }
    
    @FXML
    private void SuprimerClient(ActionEvent event) throws SQLException {
         String text = txtIdClient.getText();
         int id = Integer.parseInt(text) ;
         Client c1=new Client();
         ClientService cs=new ClientService();
         cs.deleteClient(id);
         txtIdClient.clear();
         txtNomClient.clear();
         txtAdresseClient.clear();
         txtTelephoneClient.clear();
         txtPrenomClient.clear();
         
        }
    

    @FXML
    private void ModifierClient(ActionEvent event) {
        String text = txtIdClient.getText();
        String adresse=txtAdresseClient.getText();
        String tel=txtTelephoneClient.getText();
         try{
        String req1="update client set adresse='"+adresse+
                    "', telph_client='"+tel+
                    "' where id_client='"+text+"'";
                  stat.executeUpdate(req1);
                   JOptionPane.showMessageDialog(null, "client modifier");
                   txtIdClient.clear();
         txtNomClient.clear();
         txtAdresseClient.clear();
         txtTelephoneClient.clear();
         txtPrenomClient.clear();
          
                    System.out.println("client bien modifier");
                  } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    @FXML
    private void AnnulerEcriture(ActionEvent event) {
        txtIdClient.clear();
        txtNomClient.clear();
        txtPrenomClient.clear();
        txtAdresseClient.clear();
        txtTelephoneClient.clear();
         labelNom.setVisible(false);
             txtNomClient.setVisible(false);
             labelPrenom.setVisible(false);
             txtPrenomClient.setVisible(false);
             labelAdresse.setVisible(false);
             txtAdresseClient.setVisible(false);
             
             
             labelTelephone.setVisible(false);
             txtTelephoneClient.setVisible(false);
             
             btnAnuler.setVisible(false);
             btnModifierClient.setVisible(false);
             btnSuprimerClient.setVisible(false);
    }

    @FXML
    private void RetourPageAceuil(ActionEvent event) {
        Stage stage = (Stage) btnAceuil.getScene().getWindow();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("FXMLAceuilPage.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(FXMLloginController.class.getName()).log(Level.SEVERE, null, ex);      //login controller this function 
                }
                stage.setScene(new Scene(root));

    }
    
}
