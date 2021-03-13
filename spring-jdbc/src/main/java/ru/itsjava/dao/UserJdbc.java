package ru.itsjava.dao;

import ru.itsjava.domain.User;

import java.util.List;


public interface UserJdbc {
    Long createUser(User user);

    List<User> printAllUsers();

    User getUserById(long id);

    void deleteUserById(long id);
}