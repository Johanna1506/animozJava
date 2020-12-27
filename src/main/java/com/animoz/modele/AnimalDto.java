package com.animoz.modele;

import javax.validation.constraints.NotBlank;

public class AnimalDto {

    @NotBlank(message = "Le nom de l''animal est obligatoire")
    public String nom;


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
