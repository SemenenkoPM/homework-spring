package ru.itsjava.repository;

import ru.itsjava.domain.User;

import java.util.List;

public interface UserRepository {
    User saveUser(User user);

    List<User> getAllUsers();

    boolean checkingIfUserExistsWithThisId(long id);

    User getUserById(long id);

    void deleteUserById(User user);

}
