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

    @GetMapping("/")
    public String mainMenu(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "/main/mainPage";
    }

    @GetMapping( "/printAllUsers")
    public String getUserList(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "/user/printAllUsers";
    }

    @GetMapping("/printUserById/{id}")
    public String printUserById(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user/printUserById";
    }

    @GetMapping("/deleteUserById/{id}")
    public String deleteUserById(@PathVariable("id") long id){
        userService.deleteUserById(id);
        return "redirect:/";
    }

    // метод работает
//    @GetMapping("/printUserById")
//    public String printUserById(@RequestParam("id") long id, Model model){
//        model.addAttribute("user", userService.getUserById(id));
//        return "/user/printUserById";
//    }

//        @GetMapping("/inputUserId")
//    public String inputUserId() {
//        return "user/inputUserId";
//    }


//    @PostMapping("/{id}/printUserById")
//    public String printUserById(@PathVariable("id") String id, Model model){
//        model.addAttribute("user", userService.getUserById(Long.parseLong(id)));
//        return "/user/printUserById";
//    }



}
