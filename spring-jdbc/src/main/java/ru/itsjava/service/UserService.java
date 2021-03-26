package ru.itsjava.service;

import ru.itsjava.domain.User;

import java.util.List;

public interface UserService {

    boolean checkingIfUserExistsById(long id);

    User createUser(String surname, String name, long emailId, long petId);

    List<User> getAllUsers();

    User getUserById(long id);

    void deleteUserById(long id);
}
