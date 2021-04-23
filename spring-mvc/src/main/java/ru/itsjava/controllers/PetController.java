package ru.itsjava.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itsjava.service.PetService;

@Controller
@RequiredArgsConstructor
public class PetController {
    private final PetService petService;

    @GetMapping("/getPetsByUserId/{id}")
    public String printPetsByUserId(@PathVariable("id") long id, Model model) {
        model.addAttribute("pets", petService.getPetByUserId(id));
        return "pet/printPetsByUserId";
    }

    @GetMapping("/deletePet/{id}")
    public String formForEditPet(@PathVariable("id") long id) {
        petService.deletePetById(id);
        return "redirect:/";
    }

    @GetMapping("/formForCreateNewPet/{id}")
    public String formForCreateNewPet(@PathVariable("id") long id, Model model){
        return "pet/formForCreateNewPet";
    }
}
