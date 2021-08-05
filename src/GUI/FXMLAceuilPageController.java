/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author anous
 */
public class FXMLAceuilPageController implements Initializable {

    @FXML
    private MenuItem btnajouter;
    @FXML
    private MenuItem btncherch;
    @FXML
    private MenuItem listPage;
    @FXML
    private MenuItem ajouterLivraison;
    @FXML
    private MenuItem consultlivraison;
    @FXML
    private MenuItem txtajout;
    @FXML
    private MenuItem chercherliv;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void quiter(ActionEvent event) {
       System.exit(0);    
    }

    @FXML
    private void ajouterClient(ActionEvent event) throws IOException {
        Stage stage=new  Stage();
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLAjouterClient.fxml"));
        stage.setTitle("lOGIN");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
               
 
    }

    @FXML
    private void pageChercher(ActionEvent event) throws IOException {
        Stage stage1=new  Stage();
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLChercheClient.fxml"));
        stage1.setTitle("Chercher");
        stage1.setScene(new Scene(root, 600, 400));
        stage1.show();
    }

    @FXML
    private void afficheListeClient(ActionEvent event) throws IOException {
        
        
        
        
        Stage stage2=new  Stage();
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLListeClients.fxml"));
        stage2.setTitle("Chercher");
        stage2.setScene(new Scene(root, 600, 400));
        stage2.show();
               
    }

    @FXML
    private void pageAjoutLivraison(ActionEvent event) throws IOException {
        Stage stage3=new  Stage();
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLAjouterLivraison.fxml"));
        stage3.setTitle("Nouvelle Livraison");
        stage3.setScene(new Scene(root, 600, 400));
        stage3.show();
    }

    @FXML
    private void afficherLivrason(ActionEvent event) throws IOException {
        try {
            Stage stage=new  Stage();
            Parent root = FXMLLoader.load(getClass().getResource("FXMLListesLivraisons.fxml"));
            stage.setTitle(" Liste Livraison");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLAceuilPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
               
 
    }

    private void pageAjoutProduit(ActionEvent event) throws IOException {
         Stage stage5=new  Stage();
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLAjouterProduit.fxml"));
        stage5.setTitle("Nouveau Produit");
        stage5.setScene(new Scene(root, 600, 400));
        stage5.show();
    }

    private void afficherProduit(ActionEvent event) throws IOException {
        Stage stage6=new  Stage();
        
        Parent root = FXMLLoader.load(getClass().getResource("ListeProduit.fxml"));
        stage6.setTitle("Nouveau Produit");
        stage6.setScene(new Scene(root, 600, 400));
        stage6.show();
        
    }

    @FXML
    private void ajouteruser(ActionEvent event) throws IOException {
        Stage stage7=new  Stage();
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLajouteruser.fxml"));
        stage7.setTitle("Nouveau Produit");
        stage7.setScene(new Scene(root, 600, 400));
        stage7.show(); 
        
    }


    private void chercherLiv(ActionEvent event) throws IOException {
        Stage stage9=new  Stage();
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLChercherlivraison.fxml"));
        stage9.setTitle("LIVRAISON");
        stage9.setScene(new Scene(root, 600, 400));
        stage9.show(); 
    }

    private void chercherliv(ActionEvent event) throws IOException {
        Stage stage9=new  Stage();
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLChercherlivraison.fxml"));
        stage9.setTitle("LIVRAISON");
        stage9.setScene(new Scene(root, 600, 400));
        stage9.show(); 
    }
    

    private void cherchlivraison(ActionEvent event) throws IOException {
     Stage stage9=new  Stage();
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLChercherlivraison.fxml"));
        stage9.setTitle("LIVRAISON");
        stage9.setScene(new Scene(root, 600, 400));
        stage9.show(); 
    }

    @FXML
    private void chercherLivraison(ActionEvent event) throws IOException {
        Stage stage9=new  Stage();
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLCherchLivraison.fxml"));
        stage9.setTitle("LIVRAISON");
        stage9.setScene(new Scene(root, 600, 400));
        stage9.show(); 
    }
    }
    
    
    

