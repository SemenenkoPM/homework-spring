package ru.itsjava.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itsjava.controllers.dto.UserDto;
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

    @GetMapping("/CreateUser")
    public String formForCreateUser(Model model){
        model.addAttribute("userDto", new UserDto());
        model.addAttribute("pet", new Pet());
        return "user/createUser";
    }

@PostMapping("/createUser")
    public String createUser(UserDto userDto, Pet pet){
        User user = UserDto.toDomainObject(userDto);
    System.out.println(user);
    // здесь он мне создает обьект с петом, хотя в методе я его не прошу создавать с петом????




//    System.out.println(pet);
//    if (!(community.equals(""))) {
//        Community createdCommunity = communityService.createCommunity(new Community(0L, community));
//        createdUser = userService.createUser(new User(0L, surname, name, new Email(0L, email), createdCommunity));
//    } else {
//        createdUser = userService.createUser(new User(0L, surname, name, new Email(0L, email)));
//    }
//    petService.createPet(new Pet(0L, petName, whatPet, createdUser.getId()));
      return "redirect:/";
    }
}
