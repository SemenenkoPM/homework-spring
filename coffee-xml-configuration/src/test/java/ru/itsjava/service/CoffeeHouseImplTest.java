package ru.itsjava.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.itsjava.domain.Coffee;

import java.io.*;
import java.util.Scanner;

import static org.mockito.Mockito.when;

@DisplayName("Класс CoffeeHouseImplTest должен: ")
public class CoffeeHouseImplTest {
    CoffeeServiceImpl coffeeService = Mockito.mock(CoffeeServiceImpl.class);

    public void printCoffeeByPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("В нашем меню: ");
        coffeeService.printCoffeeMenu();
        System.out.println("за какую стоимость кофе хочешь?");
        int price = scanner.nextInt();
//        System.out.println("Ваш выбор " + coffeeService.getCoffeeByPrice(price));

        File fileTestShouldHaveCorrectPrintCoffeeByPrice = new File("src/main/resources/fileTestShouldHaveCorrectPrintCoffeeByPrice.txt");

        try {
            FileWriter fileWriter = new FileWriter(fileTestShouldHaveCorrectPrintCoffeeByPrice);
            fileWriter.write("Ваш выбор " + coffeeService.getCoffeeByPrice(price));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("Корректно выводит на консоль кофе по стоимости")
    @Test
    public void shouldHaveCorrectPrintCoffeeByPrice(){
        CoffeeHouse coffeeHouse = new CoffeeHouseImpl(coffeeService);
        Coffee americano = new Coffee("Americano", "100ml", 100);
        when(coffeeService.getCoffeeByPrice(100)).thenReturn(americano);
        Assertions.assertEquals(, coffeeHouse.printCoffeeByPrice());


//    @DisplayName("Корректно выводит на консоль кофе по стоимости")
//    @Test
//    public void shouldHaveCorrectPrintCoffeeByPrice(){
//        int price = 100;
//        CoffeeHouse coffeeHouse = new CoffeeHouseImpl(coffeeService);
//        Assertions.assertEquals("Ваш выбор " + coffeeService.getAmericano(), coffeeHouse.printCoffeeByPrice());
    }


}
