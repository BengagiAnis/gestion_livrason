/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.util.Collection;
import entite.Client;
import entite.Livraison;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.ClientService;
import service.LivraisonService;

import utile.DataConnection;

/**
 * FXML Controller class
 *
 * @author anous
 */
public class FXMLAjouterLivraisonController implements Initializable {
private Connection connection;
    private Statement stat;
    private ResultSet rs;
    @FXML
    private ComboBox comboboxclient;
    @FXML
    private Label labelajoutlivrason;
    private Button btnAceuil;
    @FXML
    private Button btnAceuil1;
   
   public FXMLAjouterLivraisonController(){
//       comboboxclient=new ComboBox<>();
//       comboboxclient.getItems().add("Choice 1");
//       comboboxclient.getItems().add("Choice 2");
//       

//       Client c=new Client(1);
//       comboboxclient.getItems().add(c);
       connection=DataConnection.getInstance().getCnx();
   } 
    

    @FXML
    private TextField txtNomProduit;
    @FXML
    private TextField txtQuantite;
    @FXML
    private TextField txtPrix;
    @FXML
    private TextField txtDate;
    @FXML
    private Button btnNouveauClient;
    @FXML
    private Button btnAjouterLivraison;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          String req="select * from client";
      try{
          stat=connection.createStatement();
          rs=stat.executeQuery(req);
          
          
          while(rs.next())
          {
            comboboxclient.getItems().add(rs.getInt("id_client"));
           
               
                      
          }
          
          
      } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        
              
              
      }
        
    }  
    
             

    @FXML
    private void afficherListClient (ActionEvent event) {
//         String s=comboboxclient.getSelectionModel().getSelectedItem().toString();
     int s=(int) comboboxclient.getSelectionModel().getSelectedItem();
         
       
    }


        
    @FXML
    private void AjouterLivraison(ActionEvent event) throws SQLException {
        int s=(int) comboboxclient.getSelectionModel().getSelectedItem();
    
        
        String nom = txtNomProduit.getText();
        String quantite=txtQuantite.getText();
        String prix=txtPrix.getText();
        String date=txtDate.getText();
        
       float prixf=Float.parseFloat(prix);
        if (nom.equals("") ||  quantite.equals("")||
                prix.equals("") || date.equals("")) {
            JOptionPane.showMessageDialog(null, "Remplire toutes champs svp");
        } else {
            String requete="insert into livraison(nom_produit,quantite,prix_produit,date,id_client)values( '"+nom+"','"+quantite+"','"+prix+"','"+date+"','"+s+"')";  
        try {
            stat=connection.createStatement();
            stat.executeUpdate(requete);
            
            labelajoutlivrason.setVisible(true);
            txtDate.clear();
            txtNomProduit.clear();
            txtPrix.clear();
            txtQuantite.clear();
           
             
          
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        }                
           
    }
   
    @FXML
    private void ajouterNouveauClient(ActionEvent event) throws IOException {
        Stage stage=new  Stage();
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLAjouterClient.fxml"));
        stage.setTitle("lOGIN");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    @FXML
    private void retourAceuil(ActionEvent event) {
         Stage stage = (Stage) btnAceuil1.getScene().getWindow();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("FXMLAceuilPage.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(FXMLloginController.class.getName()).log(Level.SEVERE, null, ex);      //login controller this function 
                }
                stage.setScene(new Scene(root));
    }
    
}
