package ru.itsjava.service;


import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Класс CoffeeServiceImpl должен: ")
public class CoffeeServiceImplTest {


    @SneakyThrows
    @DisplayName("Корректно возвращать кофе по стоимости")
    @Test
    public void shouldHaveCorrectGetCoffeeByPrice(){
        CoffeeService coffeeService = new CoffeeServiceImpl();
        Assertions.assertEquals(coffeeService.getClass().getMethod("getCappuccino").invoke(coffeeService), coffeeService.getCoffeeByPrice(50));
    }
    }
