package ru.itsjava;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itsjava.dao.UserJdbcImpl;
import ru.itsjava.domain.User;
import ru.itsjava.service.UserService;

import java.sql.SQLException;


@SpringBootApplication
public class Application {
    public static void main(String[] args) throws SQLException {
        var context = SpringApplication.run(Application.class);
        UserService userService = context.getBean(UserService.class);
        userService.printMenu();




        Console.main();
    }
}
