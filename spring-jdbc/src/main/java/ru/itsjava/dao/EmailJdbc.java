package ru.itsjava.dao;

import ru.itsjava.domain.Email;

public interface EmailJdbc {
    long createEmail(String email);

    Email getEmailById(long id);

    void updateEmailUserById(long id, String newEmail);

    void deleteEmailById(long id);
}
