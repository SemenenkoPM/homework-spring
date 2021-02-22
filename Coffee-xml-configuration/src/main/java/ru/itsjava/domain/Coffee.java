package ru.itsjava.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
@Getter
public class Coffee {
    private final String name;
    private final String volume;
    private final int price;
}
