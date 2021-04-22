package ru.itsjava.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itsjava.domain.Email;
import ru.itsjava.service.EmailService;

@Controller
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @GetMapping("newEmail/{id}")
    public String formForEditEmail(@PathVariable("id") long id, Model model){
        model.addAttribute("email", new Email(id, "new"));
        return "email/newEmail";
    }
@PostMapping("/editEmailById")
    public String editEmailById(@ModelAttribute("email") Email email){
        emailService.updateEmailById(email.getId(), email.getEmail());
        return "redirect:/";
}
}
