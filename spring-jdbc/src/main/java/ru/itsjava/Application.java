package ru.itsjava;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itsjava.menu.MainMenu;

import java.io.IOException;
import java.sql.SQLException;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws SQLException, IOException {
        var context = SpringApplication.run(Application.class);
        MainMenu mainMenu = context.getBean(MainMenu.class);

        Console.main();
        mainMenu.printMenu();
    }
}
