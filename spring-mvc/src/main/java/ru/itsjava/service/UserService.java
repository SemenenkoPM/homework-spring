package ru.itsjava.service;

import ru.itsjava.domain.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    List<User> getAllUsers();

    boolean checkingIfUserExistsWithThisId(long id);

    User getUserById(long id);

    void deleteUserById(long id);

}
