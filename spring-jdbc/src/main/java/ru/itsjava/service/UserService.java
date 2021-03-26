package ru.itsjava.service;

import ru.itsjava.domain.User;

public interface UserService {

//    boolean checkingIfUserExistsWithThisId(long id);

    User createUser(String surname, String name, long emailId, long petId);

//    void printAllUsers();
//
//    void printUserById(long id);
//
//    void deleteUserById(long id);
}
