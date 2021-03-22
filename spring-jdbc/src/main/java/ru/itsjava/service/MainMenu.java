package ru.itsjava.service;

import java.io.IOException;

public interface MainMenu {

    void printMenu() throws IOException;

    void dataEntryForUserCreation() throws IOException;

    void inputAndCheckIdForPrintUserById() throws IOException;

    void inputAndCheckIdForUpdateEmailUserById() throws IOException;

    void inputAndCheckIdForUpdatePetUserById() throws IOException;

    void inputAndCheckIdForDeleteUserById() throws IOException;
}
