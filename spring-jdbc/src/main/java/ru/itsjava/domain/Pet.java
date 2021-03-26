package ru.itsjava.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Pet {
    private long id;
    private final String name;
    private final String whatPet;
}
