package com.animoz.service;

import com.animoz.modele.Animal;
import com.animoz.modele.Soigneur;
import com.animoz.repository.AnimalRepository;
import com.animoz.repository.PopulationSoigneurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private PopulationSoigneurRepository populationSoigneurRepository;

    public List<Animal> getListeAnimaux(){
        return animalRepository.getListeAnimaux();
    }

    public List<Animal> searchAnimal(String animal) {
        return animalRepository.searchAnimal(animal);
    }

    public Animal get(long id) throws AnimalNonTrouveException {
        return animalRepository.findById(id);
    }

    public Soigneur getSoigneur(long id) {
        return populationSoigneurRepository.getSoigneur(id);
    }
}
