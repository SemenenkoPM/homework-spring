package ru.itsjava.mainMenu;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.service.MainMenuService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
@RequiredArgsConstructor
public class MainMenuImpl implements MainMenu {
    private final MainMenuService mainMenuService;

    private final BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void printMenu() throws IOException {
        while (true) {
            System.out.println("выберите пункт меню \n" +
                    "1. Создать пользователя\n" +
                    "2. Вывести всех пользователей\n" +
                    "3. Вывести пользователя по id\n" +
                    "4. Изменить email пользователя\n" +
                    "5. Добавить новую зверушку пользователю по id\n" +
                    "6. Удалить зверушку по id пользователя\n" +
                    "7. Удалить пользователя по id");
            String selectedMenuNumber = consoleReader.readLine();
            if (selectedMenuNumber.equals("1")) {
                mainMenuService.getDataAndPrintCreatedUser();
            } else if (selectedMenuNumber.equals("2")) {
                mainMenuService.printAllUsers();
            } else if (selectedMenuNumber.equals("3")) {
                mainMenuService.getDataAndCheckIdPrintUserById();
            } else if (selectedMenuNumber.equals("4")) {
                mainMenuService.getDataAndCheckIdForUpdateEmailByUserId();
            } else if (selectedMenuNumber.equals("5")) {
                mainMenuService.getDataAndCheckIdForCreateNewPetByUserId();
            } else if (selectedMenuNumber.equals("6")) {
                mainMenuService.getDataAndCheckIdForDeletePetByUserId();
            } else if (selectedMenuNumber.equals("7")) {
                mainMenuService.inputAndCheckIdForDeleteUserById();
            } else {
                System.err.println("Нет такого пункта меню, выбери существующий пункт меню");
            }
        }
    }
}
