package ru.itsjava.service;

import java.io.IOException;

public interface UserService {
    void printMenu() throws IOException;

    void createUser() throws IOException;

    void printAllUsers();

    void getUserById() throws IOException;

    void updateEmailUserById() throws IOException;

    void updatePetUserById() throws IOException;

    void deleteUserById() throws IOException;


}
