package ru.itsjava;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itsjava.domain.User;
import ru.itsjava.service.UserService;

import java.io.IOException;
import java.sql.SQLException;

@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) throws SQLException, IOException {
        var context = SpringApplication.run(MyApplication.class);
        Console.main();
    }
}
