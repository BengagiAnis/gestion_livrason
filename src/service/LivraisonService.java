/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Interface.InterfaceClient;
import Interface.InterfaceLivraison;
import entite.Client;
import entite.Livraison;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
public class LivraisonService implements InterfaceLivraison,InterfaceClient{
    private Connection connection;
    private Statement stat;
    private ResultSet rs;
 
    private List<Livraison> listliv;
    public LivraisonService() {
        connection=DataConnection.getInstance().getCnx();
         listliv=new ArrayList<>();
    }
   
     @Override
    public void addLivrason(Livraison l,int id) throws SQLException {
        
         String req="select* from client where id_client='"+id+"'";
       
        try{
            stat=connection.createStatement();
            rs=stat.executeQuery(req);
            rs.last();
            
            int row=rs.getRow();
            if(row==1)
            {  
            System.out.println("client trouver pour une livraison");
            String req1="insert into livraison(nom_produit,quantite,prix_produit,date,id_client)values('"+l.getNom_produit()+"','"+l.getQuantite()+"','"+l.getPrix_produit()+"','"+l.getDate()+"','"+id+"')";
         
              
     
        
            stat=connection.createStatement();
            stat.executeUpdate(req1);
                System.out.println("livraison etablit");
            }
            else 
                System.out.println("client inexistant pour la livraison");
           
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        

    @Override
    public void deleteLivraison(Livraison l,int id) throws SQLException {
        String req="select* from client where id_client='"+id+"'";
       
        try{
            stat=connection.createStatement();
            rs=stat.executeQuery(req);
            rs.last();
            
            int row=rs.getRow();
            if(row==1)
            {  
            System.out.println("client trouver pour suprimer la livraison");
            String req1="delete from livraison where id_client="+id;
         
              
     
        
            stat=connection.createStatement();
            stat.executeUpdate(req1);
                System.out.println("livraison supprimer");
            }
            else 
                System.out.println("client inexistant pour la livraison");
           
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        
        
       

    @Override
    public void addClient(Client c) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void afficherClient() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

        


   
        
       

   

    @Override
    public void rechercherClient(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteClient(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateClient(int id, String nom, String prenom, String adresse, String telph_client) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateLivraison(String nom_produit,int quantite,float prix,String date,int id)  throws SQLException {
        String req="select* from client where id_client='"+id+"'";
       
        try{
            stat=connection.createStatement();
            rs=stat.executeQuery(req);
            rs.last();
            
            int row=rs.getRow();
            if(row==1)
            {  
            String req1="update livraison set nom_produit='"+nom_produit+
                    "', quantite='"+quantite+
                    "', prix_produit='"+prix+
                    "', date='"+date+
                    "' where id_client='"+id+"'";
                  stat.executeUpdate(req1);
                    System.out.println("livraison bien modifier");
                    }
            
            else 
                System.out.println("livraison a modifier inexistant");
           
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void afficherLivraison() throws SQLException {
      String req="select * from livraison";
      try{
          stat=connection.createStatement();
          rs=stat.executeQuery(req);
          
          
          while(rs.next())
          {
              System.out.println(rs.getInt("id_livraison")+" " +rs.getString("nom_produit")+" "+rs.getString("quantite")+" "+rs.getString("prix_produit")+" "+rs.getString("date")+" "+rs.getString("id_client"));
              
          }
          
      } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        
              
              
      }
              
              }

    @Override
    public void afficherLivraisonClient(int id) throws SQLException {
       String req="select * from livraison where id_client="+id;
       
      try{
          stat=connection.createStatement();
          rs=stat.executeQuery(req);
          
          
          while(rs.next())
          {
              System.out.println(rs.getInt("id_livraison")+" " +rs.getString("nom_produit")+" "+rs.getFloat("prix_produit")+" "+rs.getInt("quantite")+" "+rs.getString("date"));
            
              String req1="select * from client where id_client="+id;
              stat=connection.createStatement();
              rs=stat.executeQuery(req1);
             while(rs.next())
          {
              System.out.println(rs.getInt("id_client")+" " +rs.getString("nom")+" "+rs.getString("prenom")+" "+rs.getString("adresse")+" "+rs.getString("telph_client"));
             
              
          }
          } 
      } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
      }
        }

    @Override
    public boolean AjoutClient(Client c) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        l.setQuantite(rs.getInt("quantite")); 
        l.setPrix_produit(rs.getInt("prix_produit"));
        l.setDate(rs.getString("date"));
        l.setId_client(rs.getInt("id_client"));
        groupe_list.add(l);
     }
     return groupe_list;
    }
}

    


    
    

