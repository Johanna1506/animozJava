package com.animoz.repository;

import com.animoz.modele.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AnimalRepository {

    @Autowired
    private EntityManager entityManager;

    public List<Animal> getListeAnimaux() {
        return entityManager.createQuery("select a from Animal a order by a.nom", Animal.class)
                            .getResultList();
    }

    public List<Animal> searchAnimal(String animal) {
        return entityManager.createQuery("select a from Animal a where a.nom like :animal", Animal.class)
                            .setParameter("animal", "%" + animal + "%")
                            .getResultList();
    }

    public Animal findById(Long id) {
        return entityManager.createQuery("select a from Animal a where a.id = :id", Animal.class)
                            .setParameter("id", id)
                            .getSingleResult();
    }
}
