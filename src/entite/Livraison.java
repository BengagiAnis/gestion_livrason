/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;
import java.util.Date;
/**
 *
 * @author anous
 */
public class Livraison {
    private int id_livraison ;
    private String nom_produit;
    private int quantite;
    private int prix_produit;
    private String date;
    public int id_client ;

    public Livraison() {
    }

    
    
    
    
    public Livraison(int id_livraison, String nom_produit, int quantite, int prix_produit, String date, int id_client) {
        this.id_livraison = id_livraison;
        this.nom_produit = nom_produit;
        this.quantite = quantite;
        this.prix_produit = prix_produit;
        this.date = date;
        this.id_client = id_client;
    }

    public int getId_livraison() {
        return id_livraison;
    }

    public void setId_livraison(int id_livraison) {
        this.id_livraison = id_livraison;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getPrix_produit() {
        return prix_produit;
    }

    public void setPrix_produit(int prix_produit) {
        this.prix_produit = prix_produit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Livraison other = (Livraison) obj;
        if (this.id_livraison != other.id_livraison) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Livraison{" + "id_livraison=" + id_livraison + ", nom_produit=" + nom_produit + ", quantite=" + quantite + ", prix_produit=" + prix_produit + ", date=" + date + ", id_client=" + id_client + '}';
    }
    
    

   

    
    
    
    
}
