package ru.itsjava;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.itsjava.service.CoffeeHouse;
@EnableAspectJAutoProxy
@ComponentScan({"ru.itsjava"})
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        context.getBean(CoffeeHouse.class).printCoffeeByPrice();
    }
}
