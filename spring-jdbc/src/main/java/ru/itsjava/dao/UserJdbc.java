package ru.itsjava.dao;

import ru.itsjava.domain.User;

public interface UserJdbc {
    Long createUser(User user);

    void printAllUsers();

    User getUserById(long id);
}
