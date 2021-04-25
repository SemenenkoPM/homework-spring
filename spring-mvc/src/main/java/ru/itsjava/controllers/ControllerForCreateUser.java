package ru.itsjava.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itsjava.controllers.dto.UserDto;
import ru.itsjava.domain.Community;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.Pet;
import ru.itsjava.domain.User;
import ru.itsjava.service.CommunityService;
import ru.itsjava.service.PetService;
import ru.itsjava.service.UserService;

/// Написал отдельный контроллер, т.к. он обращается к разным сервисам, как лучше сделать???
@Controller
@AllArgsConstructor
public class ControllerForCreateUser {
    private final UserService userService;
    private final PetService petService;
    private final CommunityService communityService;

    @GetMapping("/CreateUser")
    public String formForCreateUser(Model model) {
        model.addAttribute("userDto", new UserDto());
        model.addAttribute("pet", new Pet());
        return "user/createUser";
    }

    @PostMapping("/createUser")
    public String createUser(UserDto userDto, Pet pet) {
        User userFromForm = UserDto.toDomainObject(userDto);
        // ??? здесь он мне создает юзера с петом, хотя в методе toDomainObject в userDto я его не прошу создавать с петом????
        User savedUserDb;
        if (!(userFromForm.getCommunity().getName().equals(""))) {
            Community savedCommunityDb = communityService.createCommunity(userFromForm.getCommunity().getName());
            userFromForm.setCommunity(savedCommunityDb);
            savedUserDb = userService.createUser(userFromForm);
        } else {
            savedUserDb = userService.createUser(new User(0L, userFromForm.getSurname(), userFromForm.getName(), new Email(0L, userFromForm.getEmail().getEmail())));
        }
        pet.setUserId(savedUserDb.getId());
        petService.createPet(pet);
        return "redirect:/";
    }
}
