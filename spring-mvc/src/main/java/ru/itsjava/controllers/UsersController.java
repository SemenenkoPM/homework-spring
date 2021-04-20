package ru.itsjava.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itsjava.service.UserService;

@Controller
@AllArgsConstructor
public class UsersController {
    private final UserService userService;

//    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
//    public String createUser(@ModelAttribute()){
//
//        return "createUser";
//    }

    @GetMapping( "/printAllUsers")
    public String getUserList(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "/user/printAllUsers";
    }

//    @GetMapping("{id}/inputUserId")
//    public String inputUserId(@PathVariable("id") long id, Model model) {
//        model.addAttribute("user", userService.getUserById(id));
//        return "user/inputUserId";
//    }
    @GetMapping("/printUserById")
    public String printUserById(@RequestParam("id") long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "/user/printUserById";
    }
}
