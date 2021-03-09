package ru.itsjava.dao;

import ru.itsjava.domain.User;

public interface UserJdbc {
    void createUser(User user);
    void printAllUsers();
}
