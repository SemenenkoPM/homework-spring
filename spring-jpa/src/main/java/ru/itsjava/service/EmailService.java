package ru.itsjava.service;

import ru.itsjava.domain.Email;
import ru.itsjava.domain.User;

public interface EmailService {
    Email createEmail(Email email);

    void updateEmailUserById(long id, String newEmail);
}
