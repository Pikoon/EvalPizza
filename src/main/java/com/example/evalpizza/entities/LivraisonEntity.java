package com.example.evalpizza.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "livraison")
public class LivraisonEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_client")
    private int idClient;
    @Basic
    @Column(name = "id_livreur")
    private int idLivreur;
    @Basic
    @Column(name = "id_commande")
    private int idCommande;
    @Basic
    @Column(name = "adresse_depart")
    private String adresseDepart;
    @Basic
    @Column(name = "adresse_arrivee")
    private String adresseArrivee;
    @Basic
    @Column(name = "date_course")
    private Date dateCourse;
    @Basic
    @Column(name = "temps_trajet")
    private Time tempsTrajet;
    @Basic
    @Column(name = "distance_parcourue")
    private int distanceParcourue;
    @Basic
    @Column(name = "prix_livraison")
    private int prixLivraison;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdLivreur() {
        return idLivreur;
    }

    public void setIdLivreur(int idLivreur) {
        this.idLivreur = idLivreur;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public String getAdresseDepart() {
        return adresseDepart;
    }

    public void setAdresseDepart(String adresseDepart) {
        this.adresseDepart = adresseDepart;
    }

    public String getAdresseArrivee() {
        return adresseArrivee;
    }

    public void setAdresseArrivee(String adresseArrivee) {
        this.adresseArrivee = adresseArrivee;
    }

    public Date getDateCourse() {
        return dateCourse;
    }

    public void setDateCourse(Date dateCourse) {
        this.dateCourse = dateCourse;
    }

    public Time getTempsTrajet() {
        return tempsTrajet;
    }

    public void setTempsTrajet(Time tempsTrajet) {
        this.tempsTrajet = tempsTrajet;
    }

    public int getDistanceParcourue() {
        return distanceParcourue;
    }

    public void setDistanceParcourue(int distanceParcourue) {
        this.distanceParcourue = distanceParcourue;
    }

    public int getPrixLivraison() {
        return prixLivraison;
    }

    public void setPrixLivraison(int prixLivraison) {
        this.prixLivraison = prixLivraison;
    }



}
