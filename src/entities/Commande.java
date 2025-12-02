/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import java.util.Date;

public class Commande {

    private int id;
    private Client client;
    private Plat plat;
    private int quantite;
    private Date dateCommande;

    public Commande() {
    }

    public Commande(int id, Client client, Plat plat, int quantite, Date dateCommande) {
        this.id = id;
        this.client = client;
        this.plat = plat;
        this.quantite = quantite;
        this.dateCommande = dateCommande;
    }

    public Commande(Client client, Plat plat, int quantite, Date dateCommande) {
        this.client = client;
        this.plat = plat;
        this.quantite = quantite;
        this.dateCommande = dateCommande;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Plat getPlat() {
        return plat;
    }

    public void setPlat(Plat plat) {
        this.plat = plat;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public double getTotal() {
        return plat.getPrix() * quantite;
    }

    @Override
    public String toString() {
        return "Commande{id=" + id + ", client=" + client.getNom()
                + ", plat=" + plat.getNom() + ", quantite=" + quantite
                + ", total=" + getTotal() + "}";
    }
}
