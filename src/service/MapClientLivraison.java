/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entite.Client;
import  entite.Livraison;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author anous
 */
public class MapClientLivraison {
   public Map<Client, Livraison> clientlivraison;

    public MapClientLivraison() {
      clientlivraison =new TreeMap<>((a,b)->a.getId()-b.getId());
    }
    
public void ajouterLivraison(Client c, Livraison l) {
    clientlivraison.put(c, l);
}
  

    public void afficherMap() {
        
       clientlivraison.forEach((k,v)->System.out.println(k+"**"+v));
        
    }

        }

    

  

