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
    public ArrayList<Marque> marques = new ArrayList<>();
    public int somme;
    public int status;
    public String voiture;

    public ArrayList<Voiture> getVoitures() {
        return voitures;
    }
    public ArrayList<Marque> getMarques() {
        return marques;
    }

    public GestionDeBDD() throws SQLException, ClassNotFoundException {
    }
    public void displayCars() throws SQLException {
        voitures = new ArrayList<>();
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
        voitures = new ArrayList<>();
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
        voitures = new ArrayList<>();
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
    public void displayChosenCars(int car) throws SQLException {
        voitures = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("SELECT v.id id, m.id id_marque, m.nom nom_marque, v.modele modele, v.nombre_ventes nombre_ventes FROM voiture v JOIN marque m ON v.id_marque = m.id WHERE m.id =?");
        ps.setInt(1, car);
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
    public void fillMarques() throws SQLException {
        marques = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("SELECT id, nom FROM marque ORDER BY id ASC");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Marque marque = new Marque(rs.getInt("id"), rs.getString("nom"));
            marques.add(marque);
        }
    }

    public int showChosenCarsSells(int car) throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT SUM(nombre_ventes) AS somme FROM voiture v JOIN marque m ON v.id_marque = m.id WHERE m.id =?");
        ps.setInt(1, car);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            somme = rs.getInt("somme");
        }
        rs.close();
        ps.close();
        con.close();
        return somme;
    }

    public void displayCarsByLetterC() throws SQLException {
        voitures = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("SELECT v.id id, m.id id_marque, m.nom nom_marque, v.modele modele, v.nombre_ventes nombre_ventes FROM voiture v JOIN marque m ON v.id_marque = m.id WHERE v.modele LIKE 'C%'");
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

    public int showCarsQuantity() throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) AS quantity FROM voiture");
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            somme = rs.getInt("quantity");
        }
        rs.close();
        ps.close();
        con.close();
        return somme;
    }

    public int showCarsSoldAmount() throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT SUM(nombre_ventes) AS quantity FROM voiture");
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            somme = rs.getInt("quantity");
        }
        rs.close();
        ps.close();
        con.close();
        return somme;
    }

    public void displayCarsByLetterI() throws SQLException {
        voitures = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("SELECT v.id id, m.id id_marque, m.nom nom_marque, v.modele modele, v.nombre_ventes nombre_ventes FROM voiture v JOIN marque m ON v.id_marque = m.id WHERE v.modele LIKE '%i%'");
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

    public void displayCarsBySecondLetterI() throws SQLException {
        voitures = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("SELECT v.id id, m.id id_marque, m.nom nom_marque, v.modele modele, v.nombre_ventes nombre_ventes FROM voiture v JOIN marque m ON v.id_marque = m.id WHERE m.nom LIKE '_i%'");
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

    public void displayCarsEndByLetterO() throws SQLException {
        voitures = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("SELECT v.id id, m.id id_marque, m.nom nom_marque, v.modele modele, v.nombre_ventes nombre_ventes FROM voiture v JOIN marque m ON v.id_marque = m.id WHERE v.modele LIKE '%o'");
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

    public String displayTheMostSoldCar(int numero) throws SQLException {
        voitures = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("SELECT v.id id, m.nom nom_marque, v.modele modele, v.nombre_ventes nombre_ventes FROM voiture v JOIN marque m ON v.id_marque = m.id ORDER BY v.nombre_ventes DESC LIMIT 1 OFFSET ?");
        ps.setInt(1, numero - 1);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            voiture = rs.getString("nom_marque") + " " + rs.getString("modele") + ". Le nombre de ventes: " + rs.getInt("nombre_ventes");
        }
        rs.close();
        ps.close();
        con.close();
        return voiture;
    }

    public int addNewCar(int id_marque, String modele, int nombre_ventes) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO voiture (id, id_marque, modele, nombre_ventes) VALUES (NULL, ?, ?, ?)");
        ps.setInt(1, id_marque);
        ps.setString(2, modele);
        ps.setInt(3, nombre_ventes);
        status = ps.executeUpdate();
        ps.close();
        con.close();
        return status;
    }
}