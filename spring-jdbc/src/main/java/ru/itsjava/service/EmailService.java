package ru.itsjava.service;

import ru.itsjava.domain.Email;

public interface EmailService {

    Email createEmail(String email);

    Email getEmailById(long id);

    void updateEmailUserById(long id, String newEmail);

    void deleteEmailById(long id);
}
