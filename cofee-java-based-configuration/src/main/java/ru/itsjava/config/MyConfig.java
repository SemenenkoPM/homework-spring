package ru.itsjava.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itsjava.service.CoffeeHouse;
import ru.itsjava.service.CoffeeHouseImpl;
import ru.itsjava.service.CoffeeService;
import ru.itsjava.service.CoffeeServiceImpl;

@Configuration
public class MyConfig {

    @Bean
    public CoffeeService coffeeService(){
        return new CoffeeServiceImpl();
    }

    @Bean
    public CoffeeHouse coffeeHouse(CoffeeService coffeeService){
        return new CoffeeHouseImpl(coffeeService);
    }
}
