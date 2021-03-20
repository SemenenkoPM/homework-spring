package ru.itsjava.service;

import ru.itsjava.domain.User;

public interface UserService {

    boolean checkingIfUserExistsWithThisId(long id);

    User createUser(User user);

    void printAllUsers();

    void printUserById(long id);

    void deleteUserById(long id);
}
