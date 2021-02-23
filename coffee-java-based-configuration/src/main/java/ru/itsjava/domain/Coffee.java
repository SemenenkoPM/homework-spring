package ru.itsjava.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Coffee {
    private final String name;
    private final String volume;
    private final int price;

}
