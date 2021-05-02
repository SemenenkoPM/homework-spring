package ru.itsjava.service;

import ru.itsjava.domain.Email;

public interface EmailService {

    Email getEmailById(long id);

    Email createEmail(Email email);

    Email updateEmailById(long id, String newEmail);
}
