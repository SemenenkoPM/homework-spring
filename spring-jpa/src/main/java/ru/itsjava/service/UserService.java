package ru.itsjava.service;

import ru.itsjava.domain.User;

public interface UserService {
    User createUser(User user);

    void printUserById(long id);

    boolean checkingIfUserExistsWithThisId(long id);
}
