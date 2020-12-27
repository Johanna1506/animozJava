package com.animoz.service;

import com.animoz.modele.Espece;
import com.animoz.repository.EspeceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspeceService {

    @Autowired
    private EspeceRepository especeRepository;

    public List<Espece> getListeEspece() { return especeRepository.getListeEspece(); }
}
