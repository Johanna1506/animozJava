package com.animoz.service;

import com.animoz.modele.Soigneur;
import com.animoz.repository.SoigneursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoigneursService {

    @Autowired
    private SoigneursRepository soigneursRepository;

    public List<Soigneur> getListeSoigneurs() { return soigneursRepository.getListeSoigneurs(); }
}
