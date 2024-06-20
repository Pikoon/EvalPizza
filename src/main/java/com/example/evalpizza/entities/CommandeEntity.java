package com.example.evalpizza.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "commande")
public class CommandeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_pizza")
    private int idPizza;
    @Basic
    @Column(name = "quantite")
    private int quantite;
    @Basic
    @Column(name = "prix_total")
    private int prixTotal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(int idPizza) {
        this.idPizza = idPizza;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(int prixTotal) {
        this.prixTotal = prixTotal;
    }

}
