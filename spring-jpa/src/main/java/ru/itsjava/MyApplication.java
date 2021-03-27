package ru.itsjava;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itsjava.mainMenu.MainMenu;

import java.io.IOException;
import java.sql.SQLException;

@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) throws SQLException, IOException {
        var context = SpringApplication.run(MyApplication.class);
        MainMenu mainMenu = context.getBean(MainMenu.class);
        Console.main();
        mainMenu.printMenu();
    }
}
