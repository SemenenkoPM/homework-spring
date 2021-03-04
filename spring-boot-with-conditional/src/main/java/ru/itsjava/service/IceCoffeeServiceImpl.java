package ru.itsjava.service;

import ru.itsjava.domain.Coffee;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class IceCoffeeServiceImpl implements CoffeeService {

    private final Coffee NobleColdBru = new Coffee("Noble Cold Bru", "100ml", 100);
    private final Coffee DeliciousCoffee = new Coffee("Delicious Coffee", "50ml", 150);
    private final Coffee GreekCoffeeFrappe = new Coffee("Greek Coffee Frappe", "200ml", 200);
    private final List<Coffee> coffeeList = new ArrayList(List.of(NobleColdBru, DeliciousCoffee, GreekCoffeeFrappe));

    @Override
    public Coffee getCoffeeByPrice(int price) {
        for (Coffee coffee: coffeeList){
            if(coffee.getPrice() == price){
                return coffee;
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public void printCoffeeMenu() {
        System.out.println(coffeeList);
    }
}
