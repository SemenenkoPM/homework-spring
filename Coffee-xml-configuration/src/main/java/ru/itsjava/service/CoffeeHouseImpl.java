package ru.itsjava.service;

import java.util.Scanner;

public class CoffeeHouseImpl implements CoffeeHouse {
    private final CoffeeService coffeeService;

    public CoffeeHouseImpl(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @Override
    public void printCoffeeByPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("В нашем меню: ");
        coffeeService.printCoffeeMenu();
        System.out.println("за какую стоимость кофе хочешь?");
        int price = scanner.nextInt();
        System.out.println("Ваш выбор " + coffeeService.getCoffeeByPrice(price));

    }
}
