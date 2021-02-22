package ru.itsjava.service;

import ru.itsjava.domain.Coffee;

public interface CoffeeService {
    Coffee getCoffeeByPrice(int price);

}
