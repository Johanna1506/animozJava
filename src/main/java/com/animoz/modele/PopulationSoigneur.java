package com.animoz.modele;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PopulationSoigneur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "populationsoigneur",
            joinColumns = @JoinColumn(name = "animal_id"),
            inverseJoinColumns = @JoinColumn(name = "soigneur_id"))
    private List<PopulationSoigneur> populationSoigneurList = new ArrayList<>();
}
