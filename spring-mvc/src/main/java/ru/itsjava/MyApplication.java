package ru.itsjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itsjava.service.UserService;
import ru.itsjava.service.UserServiceImpl;

@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        var context = SpringApplication.run(MyApplication.class);
    }
}
