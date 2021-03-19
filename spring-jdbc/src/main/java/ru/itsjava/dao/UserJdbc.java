package ru.itsjava.dao;

import ru.itsjava.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserJdbc {
    User createUser(User user);

    List<User> getAllUsers();

    Optional<User> getUserById(long id);

    void deleteUserById(long id);
}