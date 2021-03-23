package ru.itsjava.repository;

import ru.itsjava.domain.Email;

public interface EmailRepository {
    Email saveEmail(Email email);
}
