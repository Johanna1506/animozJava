package com.animoz.repository;

import com.animoz.modele.Soigneur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class PopulationSoigneurRepository {

    @Autowired
    private EntityManager entityManager;

    public Soigneur getSoigneur(Long id) {
        return entityManager.createQuery("select s from PopulationSoigneur s where s.soigneur = :id", Soigneur.class)
                            .setParameter("id", id)
                            .getSingleResult();
    }

}
