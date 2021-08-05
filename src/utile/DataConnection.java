/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utile;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anous
 */
public class DataConnection {
    private String url="jdbc:mysql://localhost/elife";
    private String login="root";
    private String pwd="";
    private Connection cnx;
    private static DataConnection instance;
   
   
    
    private DataConnection(){
        try {
            cnx=(Connection) DriverManager.getConnection(url, login, pwd);
            System.out.println("connect");
        } catch (SQLException ex) {
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
           }
    public static DataConnection getInstance(){
        if(instance==null)
            instance=new DataConnection();
        return instance;
        
        
    }

    public Connection getCnx() {
        return cnx;
    }

    
    
    
}
