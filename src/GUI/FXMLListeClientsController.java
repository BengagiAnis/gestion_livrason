/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Client;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.ClientService;
import utile.DataConnection;

/**
 * FXML Controller class
 *
 * @author anous
 */
public class FXMLListeClientsController implements Initializable {

    
    @FXML
    private Button afficher;
    @FXML
    private TableColumn<?, ?> NomClient;
    @FXML
    private TableColumn<?, ?>PrenomClient;
    @FXML
    private TableColumn<?, ?> AdresseClient;
    @FXML
    private TableView<Client> tableClient;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> telephone;
    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AfiicherListeClient(ActionEvent event) throws SQLException {
       ClientService cl= new ClientService();
       id.setCellValueFactory(new PropertyValueFactory("id"));
       NomClient.setCellValueFactory(new PropertyValueFactory("nom"));
       PrenomClient.setCellValueFactory(new PropertyValueFactory("prenom"));
       AdresseClient.setCellValueFactory(new PropertyValueFactory("adresse"));
       telephone.setCellValueFactory(new PropertyValueFactory("telephone"));
       tableClient.setItems(cl.getAll());
      
    }
        
}
