package ru.itsjava.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Pet {
    private long id;
    private final String whatPet;
    private final String name;
    private long userId;

    public Pet(String whatPet, String name, long userId) {
        this.whatPet = whatPet;
        this.name = name;
        this.userId = userId;
    }
}
