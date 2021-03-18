package ru.itsjava.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    public Pet(String whatPet, String name) {
        this.whatPet = whatPet;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "whatPet='" + whatPet + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
