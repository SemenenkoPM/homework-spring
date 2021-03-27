package ru.itsjava;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itsjava.mainMenu.MainMenu;
import ru.itsjava.repository.UserRepository;

import java.io.IOException;
import java.sql.SQLException;

@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) throws SQLException, IOException {
        var context = SpringApplication.run(MyApplication.class);
        MainMenu mainMenu = context.getBean(MainMenu.class);
        Console.main();
        mainMenu.printMenu();
//        MainMenu mainMenu = context.getBean(MainMenu.class);
//        UserService userService = context.getBean(UserService.class);
//        System.out.println("userService.checkingIfUserExistsWithThisId(1L) = " + userService.checkingIfUserExistsWithThisId(2L));

//       userService.createUser(new User(0L, "testSurname", "name"));
//         userService.createUser(new User(1L, "testSurname", "name", new Email(0L, "inputEmail" ), new Pet(0L, "petName", "whatPet")));
//        mainMenu.printMenu();
//        UserRepository userRepository = context.getBean(UserRepository.class);
//userRepository.getAllUsers();
    }
}
