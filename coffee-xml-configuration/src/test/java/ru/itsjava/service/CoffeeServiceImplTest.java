package ru.itsjava.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.itsjava.domain.Coffee;


@DisplayName("Класс CoffeeServiceImpl должен: ")
public class CoffeeServiceImplTest {

    @DisplayName("Корректно возвращать кофе по стоимости")
    @Test
    public void shouldHaveCorrectGetCoffeeByPrice() {
        CoffeeService coffeeService = new CoffeeServiceImpl();
        Coffee cappuccino = new Coffee("Cappuccino", "50ml", 50);
        Assertions.assertEquals(cappuccino, coffeeService.getCoffeeByPrice(50));
    }
}
