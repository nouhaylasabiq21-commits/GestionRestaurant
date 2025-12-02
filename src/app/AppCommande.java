/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author aaa
 */

import entities.Client;
import entities.Plat;
import entities.Commande;
import services.Clientservice;
import services.Platservice;
import services.Commandeservice;

import java.util.Date;

public class AppCommande {

    public static void main(String[] args) {

        Commandeservice commandeService = new Commandeservice();
        Clientservice clientService = new Clientservice();
        Platservice platService = new Platservice();

        System.out.println(" TEST CRUD COMMANDE ");

        Client c1 = new Client("Sara Bennami", "0677889944", "Marrakech");
        clientService.create(c1);

        Plat p1 = new Plat("Tajine", "Marocain", 60.0);
        platService.create(p1);

        System.out.println("\n Ajout d'une commande");

        Commande cmd1 = new Commande(c1, p1, 2, new Date()
        );

        if (commandeService.create(cmd1)) {
            System.out.println("Commande ajoutée avec succès !");
        } else {
            System.out.println("Échec de l'ajout !");
        }

        System.out.println("\n Liste des commandes ");
        for (Commande c : commandeService.findAll()) {
            System.out.println(c.getId() + " | " + c.getClient().getNom() + " | " + c.getPlat().getNom() + " | Qte=" + c.getQuantite() + " | Total=" + c.getTotal());
        }

        System.out.println("\n Recherche commande ID = 1 ");
        Commande found = commandeService.findById(1);

        if (found != null) {
            System.out.println("Commande trouvée : " + found);
        } else {
            System.out.println("Aucune commande avec cet ID.");
        }

        System.out.println("\n Mise à jour commande ID = 1 ");
        if (found != null) {
            found.setQuantite(5);

            if (commandeService.update(found)) {
                System.out.println("Commande mise à jour !");
            } else {
                System.out.println("Échec de mise à jour.");
            }
        }
        System.out.println("\n Liste finale des commandes ");
        for (Commande c : commandeService.findAll()) {
            System.out.println(
                    c.getId() + " | "
                    + c.getClient().getNom() + " | "
                    + c.getPlat().getNom() + " | Qte=" + c.getQuantite()
                    + " | Total=" + c.getTotal()
            );
        }
    }
}
