package com.animoz.controller;

import com.animoz.modele.AnimalDto;
import com.animoz.modele.Soigneur;
import com.animoz.modele.SoigneurDto;
import com.animoz.service.SoigneursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SoigneursController {

    @Autowired
    private SoigneursService soigneursService;

    @GetMapping(path = "/soigneurs")
    public String afficherListeSoigneurs(Model model) {

        List<Soigneur> listeSoigneurs = soigneursService.getListeSoigneurs();

        model.addAttribute("liste", listeSoigneurs);

        return "soigneurs";
    }

    @GetMapping(path="/soigneur")
    public String afficherFormulaireCreation(@ModelAttribute("soigneur") SoigneurDto soigneurDto) {
        return "formSoigneur";
    }

    @PostMapping(path = "/soigneur")
    public String ajouterAnimal(@ModelAttribute("soigneur") SoigneurDto soigneurDto) {
        return "formSoigneur";
    }
}
