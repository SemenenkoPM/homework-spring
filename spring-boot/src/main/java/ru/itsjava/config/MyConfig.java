package ru.itsjava.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itsjava.property.CoffeeProperty;
import ru.itsjava.service.*;

@EnableConfigurationProperties(CoffeeProperty.class)
@Configuration
// может быть больше одного проперти?
public class MyConfig {

    @Bean
    @ConditionalOnMissingBean(CoffeeService.class)
    @ConditionalOnProperty(value = "coffee.is-coffee-hot", havingValue = "true") // почему Ide здесь не помогает прописывать?
    public CoffeeService hotCoffeeService(){
        return new HotCoffeeServiceImpl();
    }

    @Bean
    @ConditionalOnMissingBean(CoffeeService.class)
    @ConditionalOnProperty(value = "coffee.is-coffee-hot", havingValue = "false")
    public CoffeeService iceCoffeeService(){
        return new IceCoffeeServiceImpl();
    }


    @Bean
    public CoffeeHouse coffeeHouse(CoffeeService coffeeService){
        return new CoffeeHouseImpl(coffeeService);
    }
}



