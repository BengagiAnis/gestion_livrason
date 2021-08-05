/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Client;
import entite.Livraison;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.LivraisonService;
import service.UserService;
import utile.DataConnection;

/**
 * FXML Controller class
 *
 * @author anous
 */
public class FXMLListesLivraisonsController implements Initializable {

    @FXML
    private Button livraison;
    @FXML
    private TableView<Livraison> tableLivraison;
    @FXML
    private TableColumn<?, ?> idlivraison;
    @FXML
    private TableColumn<?, ?> produit;
    @FXML
    private TableColumn<?, ?> quantite;
    @FXML
    private TableColumn<?, ?> prix;
    @FXML
    private TableColumn<?, ?> date;
    @FXML
    private TableColumn<?, ?> id_client;
    @FXML
    private Button btnFaceuilr;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void afficher(ActionEvent event) {
        try {
            LivraisonService ls =new LivraisonService();
            idlivraison.setCellValueFactory(new PropertyValueFactory<>("id_livraison"));
            produit.setCellValueFactory(new PropertyValueFactory<>("nom_produit"));
            quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
            prix.setCellValueFactory(new PropertyValueFactory<>("prix_produit"));
            date.setCellValueFactory(new PropertyValueFactory<>("date"));
            id_client.setCellValueFactory(new PropertyValueFactory<>("id_client"));
            tableLivraison.setItems(ls.getAll());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLListesLivraisonsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void retourAceuil(ActionEvent event) {
         Stage stage = (Stage) btnFaceuilr.getScene().getWindow();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("FXMLAceuilPage.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(FXMLloginController.class.getName()).log(Level.SEVERE, null, ex);      //login controller this function 
                }
                stage.setScene(new Scene(root));
    }
        
    }

  

