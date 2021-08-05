/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_de_livraison;
import entite.Client;
import entite.Livraison;

import entite.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import service.ClientService;
import service.ListClient;
import service.ListLivraison;
import service.LivraisonService;
import service.MapClientLivraison;

import service.UserService;
import utile.DataConnection;
/**
 *
 * @author anous
 */
public class Gestion_de_livraison {

   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        DataConnection dc1=DataConnection.getInstance();
        System.out.println(dc1);
        
        
        
        
ClientService cs=new ClientService();
Client  c1=new Client("mohammed","ali", "beja" , "99999999");
Client  c2=new Client("aaaaa","vvvv", "tunis" , "77999999");
Client  c3=new Client("aabbba","v11vvv", "tunis" , "77999999");
//cs.deleteClient(3);
//
//
//
//
//Livraison l1=new Livraison(1, "yaourt", 500, 10, "22/04/2021", 3);
//Livraison l2=new Livraison(11, "yaour11t", 500, 10, "22/04/2021", 1);
//LivraisonService ls=new LivraisonService();
//
//ls.addLivrason(l1, 1);
//ls.deleteLivraison(l2, 2);
//cs.addClient(c3);
//cs.addClient(c2);
//cs.updateClient(1, "bengagi", "bengagi", "bouselem", "22222");
//cs.addClient(c1);
//cs.addClient(c1);
//Client  c2=new Client("aaaaa","vvvv", "tunis" , "77999999");
//Client  c3=new Client("aabbba","v11vvv", "tunis" , "77999999");
//cs.deleteClient(4);
//cs.deleteClient(5);
//cs.addClient(c3);
//cs.addClient(c2);
//cs.updateClient(1, "bengagi", "anis", "beja", "27281212");
//cs.updateClient(2, "bengagi", "anis", "bouselem", "27281212");


ListClient list=new ListClient();
list.ajouterClient(c3);
list.afficherClient();
////list.ajouterClient(c3);
////        list.afficherClient();
//        list.supprimerClient(c3);
//        list.afficherClient();


//cs.deleteClient(1);
//cs.addClient(c2);
//cs.addClient(c3);
////cs.addClient(c1);
////cs.deleteClient(1);
//Client  c2=new Client("aaaaa","vvvv", "tunis" , "77999999");
//Client  c3=new Client("ahmed","benahmed", "tunis" , "77999969");
//cs.updateClient(2, "bengagi", "anis", "bouselem", "27281212");
//cs.afficherClient();
//
//
//ListClient list=new ListClient();
//list.ajouterClient(c3);
//list.afficherClient();
//
Livraison l1=new Livraison(1, "yaourt", 500, 10, "22/04/2021", 3);
Livraison l2=new Livraison(11, "yaour11t", 500, 10, "22/04/2021", 1);
LivraisonService ls=new LivraisonService();
//ls.addLivrason(l2, 2);
//ls.addLivrason(l1, 1);
//ls.deleteLivraison(l2, 2);
////ls.addLivrason(l1, 2);
//ls.addLivrason(l2, 3);
//

//ListClient list=new ListClient();
//list.ajouterClient(c3);
//list.afficherClient();
//









//cs.rechercherClient(8);
//cs.updateClient(9, "updated", "updated", "updated", "updated");
//cs.deleteClient(8);

//cs.afficherClient();
//
//
//

//list.ajouterClient(c1);
//list.ajouterClient(c2);
//list.ajouterClient(c3);
//list.nombreClient();
//list.afficherClient();
//list.supprimerClient(c3);
//list.afficherClient();
//
//

//Livraison lv=new Livraison(10, "yaourt", 500, 10, "22/04/2021", 9);
//Livraison lv1=new Livraison(11, "yaour11t", 500, 10, "22/04/2021", 12);
//LivraisonService lvS =new LivraisonService();
//ListLivraison lisv=new ListLivraison();
//lvS.addLivrason(lv, 12);
//lvS.addLivrason(lv1, 9);
////
//
//
//       
//
MapClientLivraison  mapC=new MapClientLivraison();
mapC.ajouterLivraison(c1, l1);
mapC.afficherMap();

    }
}
