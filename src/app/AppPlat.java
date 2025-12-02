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
import entities.Plat;
import java.util.List;
import java.util.Scanner;
import services.Platservice;

public class AppPlat {

    public static void main(String[] args) {

        Platservice platService = new Platservice();

        System.out.println(" TEST CRUD PLAT ");

        System.out.println("\n Ajout d'un plat");

        Plat p1 = new Plat("Tacos", "FastFood", 35.0);
        Plat p2 = new Plat("Couscous", "Marocain", 55.0);
        Plat p3 = new Plat("Pizza", "FastFood", 55.0);
        Plat p4 = new Plat("Jawhara", "Dessert", 55.0);
        Plat p5 = new Plat("Shawarma", "FastFood", 55.0);
        Plat p6 = new Plat("Tiramissu", "Dessert", 55.0);

        if (platService.create(p1)) {
            System.out.println("Plat ajouté avec succès !");
        } else {
            System.out.println("Échec lors de l'ajout du plat.");
        }

        platService.create(p2);
        platService.create(p3);
        platService.create(p4);
        platService.create(p5);
        platService.create(p6);

        System.out.println("\n Liste des plats ");
        for (Plat p : platService.findAll()) {
            System.out.println(p.getId() + " | " + p.getNom() + " | " + p.getCategorie() + " | " + p.getPrix());
        }

        System.out.println("\n--- Recherche du plat ID = 1");
        Plat found = platService.findById(1);

        if (found != null) {
            System.out.println("Plat trouvé : " + found.getNom() + " | " + found.getPrix());
        } else {
            System.out.println("Aucun plat trouvé avec cet ID.");
        }

        System.out.println("\n Mise à jour du plat ID = 1");
        if (found != null) {
            found.setPrix(45.0);
            found.setCategorie("Spécialité");

            if (platService.update(found)) {
                System.out.println("Plat mis à jour !");
            } else {
                System.out.println("Échec de mise à jour.");
            }
        }

        System.out.println("\n Liste finale des plats ");
        for (Plat p : platService.findAll()) {
            System.out.println(p.getId() + " | " + p.getNom() + " | " + p.getCategorie() + " | " + p.getPrix());
        }

        System.out.println("\n Recherche par catégorie ");
        Scanner sc = new Scanner(System.in);

        System.out.print("Entrez la catégorie à rechercher : ");
        String cat = sc.nextLine();

        List<Plat> platsCat = platService.getByCategorie(cat);

        System.out.println("\n Plats de la catégorie : " + cat);

        if (platsCat.isEmpty()) {
            System.out.println("Aucun plat trouvé pour cette catégorie.");
        } else {
            for (Plat p : platsCat) {
                System.out.println(
                        p.getId() + " | " + p.getNom() + " | "
                        + p.getCategorie() + " | " + p.getPrix()
                );
            }
        }
    }

}
