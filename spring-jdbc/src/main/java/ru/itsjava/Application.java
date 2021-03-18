package ru.itsjava;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itsjava.service.UserService;

import java.io.IOException;
import java.sql.SQLException;


@SpringBootApplication
public class Application {
    public static void main(String[] args) throws SQLException, IOException {
        var context = SpringApplication.run(Application.class);
        UserService userService = context.getBean(UserService.class);

        Console.main();
        while (true) {
            userService.printMenu();
        }
    }
}
