package ru.itsjava.domain;

import lombok.*;

@AllArgsConstructor
@Data
public class Email {
    private long id;
    private final String email;
}
