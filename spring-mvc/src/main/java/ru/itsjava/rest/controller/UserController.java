package ru.itsjava.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itsjava.service.UserService;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @RequestMapping(value = "/printAllUsers", method = RequestMethod.GET)
    public String getUserList(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "users-list";
    }
}
