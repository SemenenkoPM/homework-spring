package ru.itsjava.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itsjava.domain.Community;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.Pet;
import ru.itsjava.domain.User;
import ru.itsjava.service.CommunityService;
import ru.itsjava.service.PetService;
import ru.itsjava.service.UserService;

@Controller
@AllArgsConstructor
public class PreControllerForCreateUser {
    private final UserService userService;
    private final PetService petService;
    private final CommunityService communityService;

    @GetMapping("/formForCreateUser")
    public String formForCreateUser(Model model){
        model.addAttribute("User", new User());
        return "user/createUser";
    }

@PostMapping("/createUser")
    public String createUser(@RequestParam("surName") String surname, @RequestParam("name") String name,
                           @RequestParam("email") String email, @RequestParam("petName") String petName,
                           @RequestParam("whatPet") String whatPet, @RequestParam("community") String community){
    User createdUser;
    if (!(community.equals(""))) {
        Community createdCommunity = communityService.createCommunity(community);
        createdUser = userService.createUser(new User(0L, surname, name, new Email(0L, email), createdCommunity));
    } else {
        createdUser = userService.createUser(new User(0L, surname, name, new Email(0L, email)));
    }
    petService.createPet(new Pet(0L, petName, whatPet, createdUser.getId()));
      return "redirect:/";
    }
}
