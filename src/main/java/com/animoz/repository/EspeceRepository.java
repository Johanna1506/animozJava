package com.animoz.repository;

import com.animoz.modele.Espece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EspeceRepository {

    @Autowired
    private EntityManager entityManager;

    public List<Espece> getListeEspece() {
        return entityManager.createQuery("select e from Espece e order by e.nom", Espece.class)
                            .getResultList();
    }
}
