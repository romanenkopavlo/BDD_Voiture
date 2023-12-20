package org.database;
import org.database.bdd.GestionDeBDD;
import org.database.clavier.In;
import java.sql.*;

public class Ihm {
    static GestionDeBDD gestionDeBDD;
    public static void main(String[] args) {
        try {
            int choice = 0;
            int choice_top;
            int choice_marque;
            int choice_nombre_de_ventes;
            String choice_modele;
            while (choice != 14) {
                gestionDeBDD = new GestionDeBDD();
                System.out.println("........Les voitures........");
                System.out.println("Pour afficher les voitures, tapez 1");
                System.out.println("Pour afficher les voitures par le nombre de ventes croissant, tapez 2");
                System.out.println("Pour afficher les voitures par le nombre de ventes decroissant, tapez 3");
                System.out.println("Pour afficher les voitures par la marque choisie, tapez 4");
                System.out.println("Pour afficher la somme de ventes de la voiture choisie, tapez 5");
                System.out.println("Pour afficher les voitures dont les modeles commence par un C, tapez 6");
                System.out.println("Pour afficher le nombre total des voitures, tapez 7");
                System.out.println("Pour afficher le nombre total des voitures vendues, tapez 8");
                System.out.println("Pour afficher les voitures qui contiennent le lettre i, tapez 9");
                System.out.println("Pour afficher les voitures dont modele contient un i pour la deuxieme lettre, tapez 10");
                System.out.println("Pour afficher les voitures dont modele finit par la lettre o, tapez 11");
                System.out.println("Pour afficher la Nieme voiture la plus vendue ou N est un numero choisi par vous, tapez 12");
                System.out.println("Pour ajouter la nouvelle voiture dans la base de donnees, tapez 13");
                System.out.println("Pour arreter votre session, tapez 14");
                System.out.println("Votre choix: ");
                choice = In.readInteger();
                switch (choice) {
                    case 1:
                        gestionDeBDD.displayCars();
                        display();
                        break;
                    case 2:
                        gestionDeBDD.sortBySellsIncreased();
                        display();
                        break;
                    case 3:
                        gestionDeBDD.sortBySellsDecreased();
                        display();
                        break;
                    case 4:
                        System.out.println("Choisissez la marque de voiture...");
                        gestionDeBDD.fillMarques();
                        for (int i = 0; i < gestionDeBDD.marques.size(); i++) {
                            System.out.println(gestionDeBDD.marques.get(i).getId() + " pour " + gestionDeBDD.marques.get(i).getNom());
                        }
                        choice_marque = In.readInteger();
                        gestionDeBDD.displayChosenCars(choice_marque);
                        display();
                        break;
                    case 5:
                        System.out.println("Choisissez la marque de voiture...");
                        gestionDeBDD.fillMarques();
                        for (int i = 0; i < gestionDeBDD.marques.size(); i++) {
                            System.out.println(gestionDeBDD.marques.get(i).getId() + " pour " + gestionDeBDD.marques.get(i).getNom());
                        }
                        choice_marque = In.readInteger();
                        System.out.println("La somme des voitures vendues de la marque " + gestionDeBDD.marques.get(choice_marque - 1).getNom() + " est " + gestionDeBDD.showChosenCarsSells(choice_marque));
                        break;
                    case 6:
                        gestionDeBDD.displayCarsByLetterC();
                        display();
                        break;
                    case 7:
                        System.out.println("Le nombre des voitures est " + gestionDeBDD.showCarsQuantity());
                        break;
                    case 8:
                        System.out.println("Le nombre des voitures vendues est " + gestionDeBDD.showCarsSoldAmount());
                        break;
                    case 9:
                        gestionDeBDD.displayCarsByLetterI();
                        display();
                        break;
                    case 10:
                        gestionDeBDD.displayCarsBySecondLetterI();
                        display();
                        break;
                    case 11:
                        gestionDeBDD.displayCarsEndByLetterO();
                        display();
                        break;
                    case 12:
                        System.out.println("La voiture de quelle position vous voulez afficher?");
                        System.out.println("Votre choix: ");
                        choice_top = In.readInteger();
                        System.out.println("Le numero " + choice_top + " est " + gestionDeBDD.displayTheMostSoldCar(choice_top));
                        break;
                    case 13:
                        System.out.println("Choisissez la marque pour votre voiture...");
                        gestionDeBDD.fillMarques();
                        for (int i = 0; i < gestionDeBDD.marques.size(); i++) {
                            System.out.println(gestionDeBDD.marques.get(i).getId() + " pour " + gestionDeBDD.marques.get(i).getNom());
                        }
                        System.out.println("Votre choix: ");
                        choice_marque = In.readInteger();
                        System.out.println("Choisissez la modele pour votre voiture: ");
                        choice_modele = In.readString();
                        System.out.println("Entrez un nombre de ventes de votre voiture: ");
                        choice_nombre_de_ventes = In.readInteger();
                        if (gestionDeBDD.addNewCar(choice_marque, choice_modele, choice_nombre_de_ventes) == 1) {
                            System.out.println("La voiture " + gestionDeBDD.marques.get(choice_marque - 1).getNom() + " " + choice_modele + " a ete ajoute");
                        } else {
                            System.out.println("La voiture n'a pas ete ajoute");
                        }
                        break;
                    case 14:
                        System.out.print("Votre session est arretee");
                        break;
                }
                if (choice != 14) {
                    System.out.println("\nConnection effectue");
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Le connecteur n'a pas ete installe " + e.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void display() {
        for (int i = 0; i < gestionDeBDD.voitures.size(); i++) {
            System.out.println(gestionDeBDD.voitures.get(i).getId() + " " + gestionDeBDD.voitures.get(i).getMarque().getId() + " " + gestionDeBDD.voitures.get(i).getMarque().getNom() + " " + gestionDeBDD.voitures.get(i).getModele() + " " + gestionDeBDD.voitures.get(i).getNombre_de_ventes());
        }
    }
}
