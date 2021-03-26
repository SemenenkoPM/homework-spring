package ru.itsjava.service;

import ru.itsjava.domain.Email;

public interface EmailService {

    Email createEmail(String email);

    void updateEmailUserById(long id, String newEmail);
}
