/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Livraison;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utile.DataConnection;

/**
 *
 * @author wiemhjiri
 */
public class ListLivraison {
    
     private Connection connection;
    private Statement stat;
    private ResultSet rs;

    
    private List<Livraison> listliv;

    public ListLivraison(){
        listliv=new ArrayList<>();
        connection=DataConnection.getInstance().getCnx();
    }

    

    public List<Livraison> getListliv() {
        return listliv;
    }

    public void ajouterLivraison(Livraison l) {
       listliv.add(l);
    }

  
    public void supprimerLivraison(Livraison l) {
       listliv.remove(l);
        System.out.println("Livraison  retirer ");
    }


   
    public void afficherLivraison() {
        listliv.stream().forEach(e->System.out.println(e));
    }
    public ObservableList<Livraison> getAll() throws SQLException {
     ObservableList<Livraison> groupe_list = FXCollections.observableArrayList();
     String requete = "SELECT * FROM livraison";
       stat=connection.createStatement();
       rs=stat.executeQuery(requete);
     
     while(rs.next()){
        Livraison l= new Livraison();
        l.setId_livraison(rs.getInt("id_livraison"));
        l.setNom_produit(rs.getString("nom_produit"));
        System.out.println(rs.getInt("quantite"));
        l.setQuantite(rs.getInt("quantite"));
        l.setPrix_produit(rs.getInt("prix_produit"));
        l.setDate(rs.getString("date"));
      
        groupe_list.add(l);
     }
     return groupe_list;
    }
    
}
