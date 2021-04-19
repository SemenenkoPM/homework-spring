package ru.itsjava.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itsjava.service.UserService;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserService userService;

//    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
//    public String createUser(@ModelAttribute()){
//
//        return "createUser";
//    }

    @RequestMapping(value = "/printAllUsers", method = RequestMethod.GET)
    public String getUserList(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user/users-list";
    }

    @RequestMapping(value = "inputUserId", method = RequestMethod.POST)
    public String inputUserId(@RequestParam("id") long id) {
        return "/";
    }
}
