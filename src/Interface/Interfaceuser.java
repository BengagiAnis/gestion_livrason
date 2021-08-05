/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import entite.Client;
import entite.User;
import java.sql.SQLException;

/**
 *
 * @author anous
 */
public interface Interfaceuser {
    
    
     
     public void chercher(int id )throws SQLException;
     public boolean Connecter(String login,String pass)throws SQLException;
    }

