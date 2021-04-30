package ru.itsjava.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itsjava.service.UserService;

@Controller
@AllArgsConstructor
public class UsersController {
    private final UserService userService;





    @GetMapping("/")
    public String mainMenu(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "/main/mainPage";
    }

    @GetMapping("/printAllUsers")
    public String getUserList(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user/printAllUsers";
    }

    @GetMapping("/printUserById/{id}")
    public String printUserById(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user/printUserById";
    }

    @GetMapping("/deleteUserById/{id}")
    public String deleteUserById(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }
}
