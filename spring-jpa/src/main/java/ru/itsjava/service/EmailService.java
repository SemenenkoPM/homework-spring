package ru.itsjava.service;

import ru.itsjava.domain.Email;

public interface EmailService {
    Email createEmail(Email email);

    void updateEmailUserById(long id, String newEmail);
}
