package com.animoz.modele;

import javax.persistence.*;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String origine;
    private String description;



    @ManyToOne
    private Espece espece;

    public Espece getEspece() {
        return espece;
    }

    public void setEspece(Espece espece) {
        this.espece = espece;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
