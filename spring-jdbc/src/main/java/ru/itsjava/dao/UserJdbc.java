package ru.itsjava.dao;

import ru.itsjava.domain.User;

import java.util.List;
import java.util.Map;

public interface UserJdbc {
    Long createUser(User user);

    List<User> printAllUsers();

    User getUserById(long id);
}