package ru.itsjava.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@DisplayName("Класс CoffeeHouseImplTest должен: ")
public class CoffeeHouseImplTest {
   // CoffeeServiceImpl coffeeService = Mockito.mock(CoffeeServiceImpl.class);
    CoffeeServiceImpl coffeeService = new CoffeeServiceImpl();
    // для чего в данном случае использовать мокито? если можно также обратиться к классу?
    // как по правильному  делать тесты на void?
    // если ты говоришь переопределять поток ввода вывода, как это сделать и где? прямо в тесте по идее?


//    @DisplayName("Корректно выводит на консоль кофе по стоимости")
//    @Test
//    public void shouldHaveCorrectPrintCoffeeByPrice(){
//        int price = 100;
//        CoffeeHouse coffeeHouse = new CoffeeHouseImpl(coffeeService);
//        Assertions.assertEquals("Ваш выбор " + coffeeService.getAmericano(), coffeeHouse.printCoffeeByPrice());
//    }


}
