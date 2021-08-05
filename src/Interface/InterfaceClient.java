/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import entite.Client;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author anous
 */
public interface InterfaceClient {
     public void addClient(Client c) throws SQLException;
     public void afficherClient() throws SQLException;
     public void rechercherClient(int id)throws SQLException;
     public void deleteClient(int id) throws SQLException;
     public void updateClient(int id,String nom,String prenom,String adresse,String telph_client) throws SQLException;

     
     public boolean AjoutClient(Client c) throws SQLException;

}
