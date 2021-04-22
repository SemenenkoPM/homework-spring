package ru.itsjava.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itsjava.domain.Email;
import ru.itsjava.service.EmailService;

@Controller
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @GetMapping("newEmail/{id}")
    public String formForEditEmail(@PathVariable("id") String id, Model model){
        model.addAttribute("email", emailService.getEmailById(Long.parseLong(id)));
        return "email/newEmail";
    }
@PostMapping("/newEmail/{id}")
    public String editEmailById(@ModelAttribute(value ="id") long id, @ModelAttribute(value ="email") String email){
        emailService.updateEmailById(id, email);
        return "redirect:/";
}
}
