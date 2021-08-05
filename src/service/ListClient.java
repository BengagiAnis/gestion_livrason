/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Client;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author anous
 */
public class ListClient {
     private HashSet<Client> setClient;

    public ListClient(){
        setClient=new HashSet<>();
    }

    public void ajouterClient(Client c) {
        setClient.add(c);
    }
    public void supprimerClient(Client c) {
        setClient.remove(c);
    }

   

    public void afficherClient() {
        setClient.stream().forEach(e->System.out.println(e));
    }
    
    public long nombreClient(){
        return setClient.size();
        
    }
    
   
    
    
}
