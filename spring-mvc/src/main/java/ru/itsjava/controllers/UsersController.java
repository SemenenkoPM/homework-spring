package ru.itsjava.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itsjava.controllers.dto.PetDto;
import ru.itsjava.controllers.dto.UserDto;
import ru.itsjava.domain.Pet;
import ru.itsjava.domain.User;
import ru.itsjava.service.UserService;

@Controller
@AllArgsConstructor
public class UsersController {
    private final UserService userService;

    @GetMapping("/CreateUser")
    public String formForCreateUser(Model model) {
        model.addAttribute("userDto", new UserDto());
        model.addAttribute("petDto", new PetDto());
        return "user/createUserNew";
    }

    @PostMapping("/createUser")
    public String createUser(UserDto userDto, PetDto petDto) {
        User userFromForm = UserDto.toDomainObject(userDto);
        Pet petFromForm = PetDto.toDomainObject(petDto);
        userService.createUser(userFromForm, petFromForm);
        return "redirect:/";
    }

    @GetMapping("/")
    public String mainMenu() {
        return "/menu/index";
    }

    @GetMapping("/printAllUsers")
    public String getUserList(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "/user/printAllUsersInDetail";
    }

    @GetMapping("/userMenu")
    public String userMenu(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user/userMenu";
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

    @GetMapping("/updateUserNameAndSurname/{id}")
    public String formForUpdateUserNameAndSurname(@PathVariable("id") String id, Model model) {
        model.addAttribute("user", userService.getUserById(Long.parseLong(id)));
        return "user/updateUserNameAndSurname";
    }

    @PostMapping("/updateUserNameAndSurname/{id}")
    public String updateUserNameAndSurname(@ModelAttribute(value = "id") long id, @ModelAttribute(value = "surname") String surname, @ModelAttribute(value = "name") String name) {
        userService.updateUserNameAndSurname(id, surname, name);
        return "redirect:/";
    }
}
