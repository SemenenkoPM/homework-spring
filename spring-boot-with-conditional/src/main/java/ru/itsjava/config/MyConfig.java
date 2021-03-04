package ru.itsjava.config;


import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ru.itsjava.conditional.ConditionalOnCoffee;
import ru.itsjava.service.*;


@Configuration
public class MyConfig {

    @Bean
    @ConditionalOnMissingBean(CoffeeService.class)
    @ConditionalOnCoffee
    public CoffeeService hotCoffeeService() {
        return new HotCoffeeServiceImpl();
    }

    @Bean
    @ConditionalOnMissingBean(CoffeeService.class)

    public CoffeeService iceCoffeeService() {
        return new IceCoffeeServiceImpl();
    }


    @Bean
    public CoffeeHouse coffeeHouse(CoffeeService coffeeService) {
        return new CoffeeHouseImpl(coffeeService);
    }
}



