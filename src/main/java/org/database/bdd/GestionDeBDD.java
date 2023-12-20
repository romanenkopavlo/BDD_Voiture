package org.database.bdd;

import org.database.Marque;
import org.database.Voiture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestionDeBDD {
    public ConnectionDeBDD connectionDeBDD = new ConnectionDeBDD("ventes_de_voitures", "root", "");
    public Connection con = connectionDeBDD.getConnection();
    public ArrayList<Voiture> voitures = new ArrayList<>();

    public ArrayList<Voiture> getVoitures() {
        return voitures;
    }

    public GestionDeBDD() throws SQLException, ClassNotFoundException {
    }
    public void createCars() throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT v.id id, m.id id_marque, m.nom nom_marque, v.modele modele, v.nombre_ventes nombre_ventes FROM voiture v JOIN marque m ON v.id_marque = m.id ORDER BY v.id ASC");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Marque marque = new Marque(rs.getInt("id_marque"), rs.getString("nom_marque"));
            Voiture voiture = new Voiture(rs.getInt("id"), rs.getString("modele"), marque, rs.getInt("nombre_ventes"));
            voitures.add(voiture);
        }
        rs.close();
        ps.close();
        con.close();
    }

    public void sortBySellsIncreased() throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT v.id id, m.id id_marque, m.nom nom_marque, v.modele modele, v.nombre_ventes nombre_ventes FROM voiture v JOIN marque m ON v.id_marque = m.id ORDER BY v.nombre_ventes ASC");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Marque marque = new Marque(rs.getInt("id_marque"), rs.getString("nom_marque"));
            Voiture voiture = new Voiture(rs.getInt("id"), rs.getString("modele"), marque, rs.getInt("nombre_ventes"));
            voitures.add(voiture);
        }
        rs.close();
        ps.close();
        con.close();
    }
    public void sortBySellsDecreased() throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT v.id id, m.id id_marque, m.nom nom_marque, v.modele modele, v.nombre_ventes nombre_ventes FROM voiture v JOIN marque m ON v.id_marque = m.id ORDER BY v.nombre_ventes DESC");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Marque marque = new Marque(rs.getInt("id_marque"), rs.getString("nom_marque"));
            Voiture voiture = new Voiture(rs.getInt("id"), rs.getString("modele"), marque, rs.getInt("nombre_ventes"));
            voitures.add(voiture);
        }
        rs.close();
        ps.close();
        con.close();
    }

}
