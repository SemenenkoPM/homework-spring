package ru.itsjava.domain;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class User {
    private long id;
    private final String surname;
    private final String name;
    private final long emailId;
    private final long petId;
//    private final Email email;
//    private final Pet pet;
}
