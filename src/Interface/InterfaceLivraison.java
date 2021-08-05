/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import entite.Client;
import entite.Livraison;
import java.sql.SQLException;

/**
 *
 * @author anous
 */
public interface InterfaceLivraison {
    public void  addLivrason(Livraison l,int id) throws SQLException;
     public void deleteLivraison(Livraison l,int id) throws SQLException;
     public void updateLivraison(String nom_produit,int quantite,float prix,String date,int id) throws SQLException;
     public void afficherLivraison() throws SQLException;
     public void afficherLivraisonClient(int id) throws SQLException;
   }


