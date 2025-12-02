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
import services.Clientservice;

public class AppClient {

    public static void main(String[] args) {

        Clientservice clientService = new Clientservice();

        System.out.println(" TEST CRUD CLIENT ");

        System.out.println(" Ajout d'un client");
        Client c1 = new Client("Sara bennami", "0677889944", "marrakech");
        Client c2 = new Client("nouhayla sabiq ", "06778784826", "nakhil");
        Client c3 = new Client("adam belami ", "065566772116", "mhamid");
        Client c4 = new Client("souka imali ", "06512890", "ahbass");
        Client c5 = new Client("hanane sidki", "0684783926", "marrakech");
        Client c6 = new Client("aya ahmal", "06847454886", "marrakech");

        if (clientService.create(c1)) {
            System.out.println("Client ajouté avec succès !");
        } else {
            System.out.println("Échec lors de l'ajout.");
        }
        clientService.create(c2);
        clientService.create(c3);
        clientService.create(c4);
        clientService.create(c5);
        clientService.create(c6);

        System.out.println("\n Liste des clients ");
        for (Client c : clientService.findAll()) {
            System.out.println(c.getId() + " | " + c.getNom() + " | " + c.getTelephone());
        }

        System.out.println("\n Recherche du client ID = 3 ");
        Client found = clientService.findById(3);

        if (found != null) {
            System.out.println("Client trouvé : " + found.getNom() + " " + found.getTelephone());
        } else {
            System.out.println("Aucun client avec cet ID.");
        }

        System.out.println("\n Mise à jour du client ID = 20 -");
        if (found != null) {
            found.setAdresse("Casablanca");
            found.setTelephone("0700000000");
            found.setAdresse("rabat");

            if (clientService.update(found)) {
                System.out.println("Client mis à jour !");
            } else {
                System.out.println("Échec de mise à jour.");
            }
        }

        System.out.println("\n Liste finale ");
        for (Client c : clientService.findAll()) {
            System.out.println(c.getId() + " | " + c.getNom() + " | " + c.getTelephone() + " | " + c.getAdresse());
        }

    }
}
