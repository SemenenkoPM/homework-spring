package ru.itsjava.domain;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class User {
    private long id;
    private final String surname;
    private final String name;
    private Email email;
    private Pet pet;

//    public User(String surname, String name) {
//        this.surname = surname;
//        this.name = name;
//    }
//
//    public User(long id, String surname, String name, Email email, Pet pet) {
//        this.id = id;
//        this.surname = surname;
//        this.name = name;
//        this.email = email;
//        this.pet = pet;
//    }
//
//    public String toString() {
//        return "User(id=" + id + ", surname=" + surname + ", name=" + name
//                + ", email=" + email + ", pet=" + pet + ")";
//    }
}
