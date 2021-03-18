package ru.itsjava.dao;

import ru.itsjava.domain.Email;

public interface EmailJdbc {
    long createEmail(Email email);

    void updateEmailUserById(long id, String newEmail);
}
