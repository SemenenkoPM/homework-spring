package ru.itsjava.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Pet {
    private long id;
    private final String whatPet;
    private final String name;
}
