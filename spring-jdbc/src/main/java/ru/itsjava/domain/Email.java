package ru.itsjava.domain;

import lombok.*;

@AllArgsConstructor
@Data
public class Email {
    private long id;
    private final String email;
//    private long userId;

//    public Email(String email, long userId) {
//        this.email = email;
//        this.userId = userId;
//    }
}
