/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Interface.Interfaceuser;
import entite.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utile.DataConnection;

/**
 *
 * @author anous
 */
public class UserService implements Interfaceuser{
   
   private Connection connection;
    private Statement stat;
    private ResultSet rs;
    

    public UserService() {
        connection=DataConnection.getInstance().getCnx();
   
        
    }

    

    @Override
    public void chercher(int id) throws SQLException {
       String req="select* from user where id_user='"+id+"'";
       
        try{
            stat=connection.createStatement();
            rs=stat.executeQuery(req);
            rs.last();
            
            int row=rs.getRow();
            if(row==1)
            {  
                System.out.println("connecter");
            }
       else 
                System.out.println(" inexistant");
           
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    @Override
    public boolean Connecter(String login, String pass) throws SQLException {
      String req="select * from user where login='"+login+"' and pass='"+pass+ "'";
       
        try{
            stat=connection.createStatement();
            rs=stat.executeQuery(req);
            rs.last();
            
            int row=rs.getRow();
            if(row==1)
            {  
                
                return true;
                
            }
       else 
                return false ;
                
           
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;
        
 

    
}
    public void addUser(User c) throws SQLException {
        String requete="insert into user(login,pass)values( '"+c.getLogin()+"','"+c.getPass()+"')";  
        try {
            stat=connection.createStatement();
            stat.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
      
 
    





