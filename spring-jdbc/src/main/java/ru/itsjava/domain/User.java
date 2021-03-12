package ru.itsjava.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class User {
    private long id;
    private final String surname;
    private final String name;
    private Email email;
    private Pet pet;

    public User(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

    public User(long id, String surname, String name, Email email, Pet pet) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.pet = pet;
    }
}
