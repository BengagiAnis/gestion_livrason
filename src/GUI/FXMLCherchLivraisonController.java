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
import service.LivraisonService;
import utile.DataConnection;

/**
 * FXML Controller class
 *
 * @author anous
 */
public class FXMLCherchLivraisonController implements Initializable {
     private Connection connection;
    private Statement stat;
    private ResultSet rs;
    @FXML
    private Label labelidliv;
    @FXML
    private Label labelnom;
    @FXML
    private Label labelquantit;
    @FXML
    private Label labelprix;
    @FXML
    private Label labeldate;
    @FXML
    private TextField txt1;
    @FXML
    private TextField tx2;
    @FXML
    private TextField txt3;
    @FXML
    private TextField txt4;
    @FXML
    private TextField txt5;
    @FXML
    private Label lablsupprim;
    @FXML
    private Button btnclear;
     public FXMLCherchLivraisonController() {
        connection=DataConnection.getInstance().getCnx();
   
        
    }

    @FXML
    private TextField txtId;
    @FXML
    private Button btnCherch;
    @FXML
    private Button btnsuprimliv;
    private Button btnmodiliv;
    @FXML
    private Button btnretour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void chercherLivrason(ActionEvent event) {
        String text = txtId.getText();
        if (text.equals(""))
          
        {
            JOptionPane.showMessageDialog(null, "Remplire le champ svp");
        } 
        else 
       {
           int id=Integer.parseInt(text);
         String req="select * from livraison where id_livraison='"+id+"'";
      try{
          stat=connection.createStatement();
          rs=stat.executeQuery(req);
          rs.last();
            
            int row=rs.getRow();
            if(row==1)
          
          
          {
             labelidliv.setVisible(true);
             txt1.setVisible(true);
             labelnom.setVisible(true);
             tx2.setVisible(true);
             labelquantit.setVisible(true);
             txt3.setVisible(true);
             
             
             labelprix.setVisible(true);
             txt4.setVisible(true);
             labeldate.setVisible(true);
             txt5.setVisible(true);
             
             btnsuprimliv.setVisible(true);
             btnclear.setVisible(true);
             
              int  idliv=rs.getInt("id_client");
              String text1=String.valueOf(idliv);
              
               int  qliv=rs.getInt("quantite");
              String textq=String.valueOf(qliv);
              
              int  pliv=rs.getInt("prix_produit");
              String textp=String.valueOf(pliv);
             
              txt1.setText(text1);
              String nomP=rs.getString("nom_produit");
              tx2.setText(nomP);
             txt3.setText(textq);
             txt4.setText(textp);
             txt1.setText(text1);
              String datep=rs.getString("date");
              txt5.setText(datep);
              
             
                        
              
          }
            else{
                JOptionPane.showMessageDialog(null, "livraison introvable");
            }
          
      } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        
              
              
      }
       }
    
    }

    @FXML
    private void suprimerlivraison(ActionEvent event) throws SQLException {
        String text = txt1.getText();
         int id = Integer.parseInt(text) ;
        Livraison l=new Livraison();
        LivraisonService ls=new LivraisonService();
         ls.deleteLivraison(l, id);
         labelidliv.setVisible(false);
             txt1.setVisible(false);
             labelnom.setVisible(false);
             tx2.setVisible(false);
             labelquantit.setVisible(false);
             txt3.setVisible(false);
             
             
             labelprix.setVisible(false);
             txt4.setVisible(false);
             labeldate.setVisible(false);
             txt5.setVisible(false);
             
             btnsuprimliv.setVisible(false);
             
             txtId.clear();
             
         lablsupprim.setVisible(true);
         
    }


    @FXML
    private void rourtAceuil(ActionEvent event) {
        Stage stage = (Stage) btnretour.getScene().getWindow();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("FXMLAceuilPage.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(FXMLloginController.class.getName()).log(Level.SEVERE, null, ex);      //login controller this function 
                }
                stage.setScene(new Scene(root));

    }

    @FXML
    private void clearchamp(ActionEvent event) {
        labelidliv.setVisible(false);
        txt1.setVisible(false);
             labelnom.setVisible(false);
             tx2.setVisible(false);
             labelquantit.setVisible(false);
             txt3.setVisible(false);
             
             
             labelprix.setVisible(false);
             txt4.setVisible(false);
             labeldate.setVisible(false);
             txt5.setVisible(false);
             
             btnsuprimliv.setVisible(false);
             btnclear.setVisible(false);
             
             txtId.clear();
        
    }
    }
    

