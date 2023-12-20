package org.database;
import org.database.bdd.GestionDeBDD;

import java.sql.*;

public class Ihm {
    public static void main(String[] args) {
        try {
            GestionDeBDD gestionDeBDD = new GestionDeBDD();
            gestionDeBDD.createCars();
            for (int i = 0; i < gestionDeBDD.getVoitures().size(); i++) {
                System.out.println(gestionDeBDD.getVoitures().get(i).getId() + " " + gestionDeBDD.getVoitures().get(i).getModele() + " " + gestionDeBDD.getVoitures().get(i).getMarque().getId());
            }
            System.out.print("\nConnection effectue");
        } catch (ClassNotFoundException e) {
            System.err.println("Le connecteur n'a pas ete installe " + e.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
