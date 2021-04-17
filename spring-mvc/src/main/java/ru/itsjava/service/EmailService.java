package ru.itsjava.service;

import ru.itsjava.domain.Email;

public interface EmailService {
    Email createEmail(Email email);

    void updateEmailById(long id, String newEmail);
}
