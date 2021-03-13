package ru.itsjava.dao;

import ru.itsjava.domain.Email;

public interface EmailJdbc {
    void createEmail(Email email);

    public void updateEmailUserById(long id, String newEmail);
}
