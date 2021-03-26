package ru.itsjava.dao;

import ru.itsjava.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserJdbc {
    long createUser(String surname, String name, long emailId, long petId);

    List<User> getAllUsers();

    Optional<User> getUserById(long id);

    void deleteUserById(long id);
}