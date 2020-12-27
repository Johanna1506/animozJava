package com.animoz.controller;

import com.animoz.modele.Animal;
import com.animoz.modele.AnimalDto;
import com.animoz.modele.Espece;
import com.animoz.service.AnimalNonTrouveException;
import com.animoz.service.AnimalService;
import com.animoz.service.EspeceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Controller
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private EspeceService especeService;

    @GetMapping(path = "/animaux")
    public String afficherListeAnimaux(Model model, @ModelAttribute("animal") AnimalDto animalDto) {

        if(animalDto.getNom() == null) {
            model.addAttribute("liste", animalService.getListeAnimaux());
        }
        else {
            model.addAttribute("liste", animalService.searchAnimal(animalDto.getNom()));
        }

        return "listeAnimaux";
    }

    @GetMapping(path="/animal")
    public String afficherFormulaireCreation(@ModelAttribute("animal") AnimalDto animalDto, Model model) {

        List<Espece> listeEspece = especeService.getListeEspece();

        model.addAttribute("especes", listeEspece);

        return "formAnimal";
    }

    @PostMapping(path = "/animal")
    public String ajouterAnimal(@Validated @ModelAttribute("animal") AnimalDto animalDto, BindingResult bindingResult, Model model) {

        List<Espece> listeEspece = especeService.getListeEspece();

        model.addAttribute("especes", listeEspece);

        if(bindingResult.hasErrors()) {
            return afficherFormulaireCreation(animalDto, (Model) listeEspece);
        }
        return "listeAnimaux";
    }

    @GetMapping(path = "/animal/{idAnimal}")
    public String afficherAnimal(Model model, @PathVariable long idAnimal) throws AnimalNonTrouveException {
        model.addAttribute("animal", animalService.get(idAnimal));
        return "animalDetail";
    }

    @ExceptionHandler(AnimalNonTrouveException.class)
    @ResponseStatus(NOT_FOUND)
    public String handleException(AnimalNonTrouveException e) {
        return "animalNonTrouve";
    }
}
