/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Interface.InterfaceClient;
import entite.Client;
import entite.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utile.DataConnection;

/**
 *
 * @author anous
 */
public class ClientService implements InterfaceClient{
    private Connection connection;
    private Statement stat;
    private ResultSet rs;
    public ClientService() {
        connection=DataConnection.getInstance().getCnx();    
    }
    @Override
    public void addClient(Client c) throws SQLException {
        
        String requete="insert into client(nom,prenom,adresse,telph_client)values( '"+c.getNom()+"','"+c.getPrenom()+"','"+c.getAdresse()+"','"+c.getTelephone()+"')";  
        try {
            
            stat=connection.createStatement();
            stat.executeUpdate(requete);
            
            System.out.println("client ajouter avec succes");
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Override
    public void rechercherClient(int id) throws SQLException {
       String req="select* from client where id_client='"+id+"'";
       
        try{
            stat=connection.createStatement();
            rs=stat.executeQuery(req);
            rs.last();
            
            int row=rs.getRow();
            if(row==1)
            {  
            System.out.println("client trouver");
            }
            else 
                System.out.println("client inexistant");
           
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void deleteClient(int id) throws SQLException {
        String req="select* from client where id_client='"+id+"'";
       
        try{
            stat=connection.createStatement();
            rs=stat.executeQuery(req);
            rs.last();
            
            int row=rs.getRow();
            if(row==1)
            {  
          String reqq="select* from livraison where id_client='"+id+"'";
          stat=connection.createStatement();
            rs=stat.executeQuery(reqq);
            rs.last();
            
            int row1=rs.getRow();
            
            if(row==1)
            { String reqq1="delete from livraison where id_client="+id;
              stat=connection.createStatement();
            stat.executeUpdate(reqq1);
            }
       
           String req2="delete from client where id_client="+id;
       
            stat=connection.createStatement();
            stat.executeUpdate(req2);
            System.out.println("client supprimer");
            }
       else 
                System.out.println("client a supprimer  inexistant");
           
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    @Override
    public void updateClient(int id,String nom,String prenom,String adresse,String telph_client) throws SQLException {
       String req="select* from client where id_client='"+id+"'";
       
        try{
            stat=connection.createStatement();
            rs=stat.executeQuery(req);
            rs.last();
            
            int row=rs.getRow();
            if(row==1)
            {  
            String req1="update client set nom='"+nom+
                    "', prenom='"+prenom+
                    "', adresse='"+adresse+
                    "', telph_client='"+telph_client+
                    "' where id_client='"+id+"'";
                  stat.executeUpdate(req1);
                    System.out.println("client bien modifier");
                    }
            
            else 
                System.out.println("client a modifier inexistant");
           
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    @Override
    public void afficherClient() throws SQLException {
      String req="select * from client";
      try{
          stat=connection.createStatement();
          rs=stat.executeQuery(req);
          
          
          while(rs.next())
          {
               System.out.println(rs.getInt("id_client")+" " +rs.getString("nom")+" "+rs.getString("prenom")+" "+rs.getString("telph_client"));
              
          }
          
      } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);     
      }
}
    @Override
    public boolean AjoutClient(Client c) throws SQLException {
      
     String requete="insert into client(nom,prenom,adresse,telph_client)values( '"+c.getNom()+"','"+c.getPrenom()+"','"+c.getAdresse()+"','"+c.getTelephone()+"')";  
        try {
            stat=connection.createStatement();
           stat.executeUpdate(requete);
            {   
           String messagetrue="ajouter";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public ObservableList<Client> getAll() throws SQLException {
     ObservableList<Client> groupe_list = FXCollections.observableArrayList();
     String requete = "SELECT * FROM client";
       stat=connection.createStatement();
       rs=stat.executeQuery(requete);
     while(rs.next()){
        Client c = new Client();
        c.setId(rs.getInt("id_client"));
        c.setNom(rs.getString("nom"));
        c.setPrenom(rs.getString("prenom"));
        c.setAdresse(rs.getString("adresse"));
        c.setTelephone(rs.getString("telph_client"));
       
      groupe_list.add(c);
       }
     return groupe_list;
    }
  }


    

