package ru.itsjava.domain;

import lombok.Getter;

@Getter
// вопрос, когда делал маппер, то для создания сделал конструктор руками, ???
public class Email {
    private long id;
    private final String email;
    private long userId;

    public Email(String email, long userId) {
        this.email = email;
        this.userId = userId;
    }

    public Email(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Email{" +
                "email='" + email + '\'' +
                '}';
    }
}
