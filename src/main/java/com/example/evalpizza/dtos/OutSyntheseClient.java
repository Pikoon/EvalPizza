package com.example.evalpizza.dtos;

public class OutSyntheseClient {

    private String nom, prenom;

    private int nbCommandes, montant;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getNbCommandes() {
        return nbCommandes;
    }

    public void setNbCommandes(int nbCommandes) {
        this.nbCommandes = nbCommandes;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
}
