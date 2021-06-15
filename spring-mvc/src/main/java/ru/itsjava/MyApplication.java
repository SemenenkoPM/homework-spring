package ru.itsjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itsjava.service.UserService;
import ru.itsjava.service.UserServiceImpl;

@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        var context = SpringApplication.run(MyApplication.class);
//        UserService userService = context.getBean(UserServiceImpl.class);
//        userService.updateUserNameAndSurname(1L, "Andreev", "Andrey");
//        System.out.println("Update complete");
//        System.out.println("userService.getUserById(1L) = " + userService.getUserById(1L));
    }


}
