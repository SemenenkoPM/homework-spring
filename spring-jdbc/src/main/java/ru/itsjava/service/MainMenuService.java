package ru.itsjava.service;

import java.io.IOException;

public interface MainMenuService {
    void getDataAndPrintCreatedUser() throws IOException;

    void printAllUsers();

    void getDataAndCheckIdPrintUserById() throws IOException;

    void getDataAndCheckIdForUpdateEmailByUserId() throws IOException;

    void getDataAndCheckIdForUpdatePetByUserId() throws IOException;

    void inputAndCheckIdForDeleteUserById() throws IOException;
}
