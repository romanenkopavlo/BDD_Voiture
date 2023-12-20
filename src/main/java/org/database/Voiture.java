package org.database;
public class Voiture {
    private int id;
    private int nombre_de_ventes;
    private String modele;
    private Marque marque;
    public Voiture() {
    }

    public Voiture(int id, String modele, Marque marque, int nombre_de_ventes) {
        this.id = id;
        this.nombre_de_ventes = nombre_de_ventes;
        this.modele = modele;
        this.marque = marque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNombre_de_ventes() {
        return nombre_de_ventes;
    }

    public void setNombre_de_ventes(int nombre_de_ventes) {
        this.nombre_de_ventes = nombre_de_ventes;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }
}
