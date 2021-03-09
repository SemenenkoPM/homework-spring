package ru.itsjava.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class User {
    private long id;
    private final String surname;
    private final String name;
//    private final Email email;
//    private final Pet pet;
}
