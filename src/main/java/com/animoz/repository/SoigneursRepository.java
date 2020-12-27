package com.animoz.repository;

import com.animoz.modele.Soigneur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class SoigneursRepository {

    @Autowired
    private EntityManager entityManager;

    public List<Soigneur> getListeSoigneurs() {
        return entityManager.createQuery("select s from Soigneur s order by s.nom", Soigneur.class)
                            .getResultList();
    }
}
