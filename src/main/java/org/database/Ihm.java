package org.database;
import org.database.bdd.GestionDeBDD;

import java.sql.*;

public class Ihm {
    public static void main(String[] args) {
        try {
            int choice = 0;
            GestionDeBDD gestionDeBDD = new GestionDeBDD();
            while (choice != 25) {
                System.out.println("........Les voitures........");
                System.out.println("Pour afficher les voitures tapez 1");
                System.out.println("Pour afficher les voitures par le nombre de ventes croissant tapez 2");
                System.out.println("Pour afficher les voitures par le nombre de ventes decroissant tapez 3");
                System.out.println("Pour afficher les voitures par la marque choisie tapez 4");
            }
            System.out.println("\nConnection effectue");
        } catch (ClassNotFoundException e) {
            System.err.println("Le connecteur n'a pas ete installe " + e.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
