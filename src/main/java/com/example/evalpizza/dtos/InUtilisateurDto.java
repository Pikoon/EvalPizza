package com.example.evalpizza.dtos;


import com.example.evalpizza.enumerations.TypeEnum;

import java.time.LocalDate;

//Peut etre a supprimer
public class InUtilisateurDto {

    private String nom, prenom;
    private TypeEnum type;

    private LocalDate date_inscription, date_naissance;

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

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public LocalDate getDate_inscription() {
        return date_inscription;
    }

    public void setDate_inscription(LocalDate date_inscription) {
        this.date_inscription = date_inscription;
    }

    public LocalDate getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(LocalDate date_naissance) {
        this.date_naissance = date_naissance;
    }
}
