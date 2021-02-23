package ru.itsjava.service;

import ru.itsjava.domain.Coffee;

import java.util.List;
import java.util.NoSuchElementException;

public class CoffeeServiceImpl implements CoffeeService{
    public final Coffee cappuccino = new Coffee("Cappuccino", "50ml", 50);
    private final Coffee latte = new Coffee("Latte", "150ml", 150);
    private final Coffee americano = new Coffee("Americano", "100ml", 100);
    private final List<Coffee> coffeeList = List.of(cappuccino, latte, americano);

    @Override
    public Object getCoffeeByPrice(int price) {
        for (Coffee coffee : coffeeList) {
            if (coffee.getPrice() == price) {
                return coffee;
            }
        }
        return new NoSuchElementException();
    }

    @Override
    public void printCoffeeMenu() {
        System.out.println(coffeeList);
    }
}
