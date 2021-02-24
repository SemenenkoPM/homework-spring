package ru.itsjava.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Класс CoffeeServiceImpl должен: ")
public class CoffeeServiceImplTest {



    @DisplayName("Корректно возвращать кофе по стоимости")
    @Test
    public void shouldHaveCorrectGetCoffeeByPrice() {
        CoffeeServiceImpl coffeeService = new CoffeeServiceImpl();
        Assertions.assertEquals(coffeeService.getCappuccino(), coffeeService.getCoffeeByPrice(50));
    }

//    @DisplayName("Корректно печать кофе меню")
//    @Test
//    public void shouldHaveCorrectPrintCoffeeMenu(){
//        CoffeeServiceImpl coffeeService = new CoffeeServiceImpl();
//        Assertions.assertEquals(coffeeService.printCoffeeMenu(), coffeeService.printCoffeeMenu());
//    }

}
