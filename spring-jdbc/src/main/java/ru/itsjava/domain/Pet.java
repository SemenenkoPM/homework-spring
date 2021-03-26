package ru.itsjava.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Pet {
    private long id;
    private final String name;
    private final String whatPet;
//    private long userId;

//    public Pet(String name, String whatPet, long userId) {
//        this.name = name;
//        this.whatPet = whatPet;
//        this.userId = userId;
//    }
}
