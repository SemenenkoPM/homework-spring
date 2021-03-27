package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.Pet;
import ru.itsjava.domain.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MainMenuImpl implements MainMenu {
    private final UserService userService;
    private final EmailService emailService;
    private final PetService petService;

    private final BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void printMenu() throws IOException {
        while (true) {
            System.out.println("выберите пункт меню \n" +
                    "1. Создать пользователя\n" +
                    "2. Вывести всех пользователей\n" +
                    "3. Вывести пользователя по id\n" +
                    "4. Изменить email пользователя\n" +
                    "5. Изменить зверушку пользователя\n" +
                    "6. Удалить пользователя по id");
            String selectedMenuNumber = consoleReader.readLine();
            if (selectedMenuNumber.equals("1")) {
                dataEntryForUserCreation();
            } else if (selectedMenuNumber.equals("2")) {
//                userService.printAllUsers();
            } else if (selectedMenuNumber.equals("3")) {
                inputAndCheckIdForPrintUserById();
            } else if (selectedMenuNumber.equals("4")) {
//                inputAndCheckIdForUpdateEmailUserById();
            } else if (selectedMenuNumber.equals("5")) {
//                inputAndCheckIdForUpdatePetUserById();
            } else if (selectedMenuNumber.equals("6")) {
//                inputAndCheckIdForDeleteUserById();
            } else {
                System.err.println("Нет такого пункта меню, выбери существующий пункт меню");
            }
        }
    }

    @Override
    public void dataEntryForUserCreation() throws IOException {
        System.out.println("Введите фамилию пользователя");
        String surname = consoleReader.readLine();
        System.out.println("Введите имя пользователя");
        String name = consoleReader.readLine();
        System.out.println("Введите почту пользователя");
        String inputEmail = consoleReader.readLine();
        System.out.println("Как зовут зверушку");
        String petName = consoleReader.readLine();
        System.out.println("Какой зверушкой обладает пользователь");
        String whatPet = consoleReader.readLine();
        User createdUser = userService.createUser(new User(0L, surname, name , new Email(0L, inputEmail), new Pet(0L, petName, whatPet)));
        System.out.println("Создали нового пользователя: " + createdUser);
    }

    @Override
    public void inputAndCheckIdForPrintUserById() throws IOException {
        try {
            System.out.println("Введите id пользователя");
            long id = Long.parseLong(consoleReader.readLine());
            if (userService.checkingIfUserExistsWithThisId(id)) {
                userService.printUserById(id);
            } else {
                System.err.println("Нет пользователя c таким id");
            }
        } catch (NumberFormatException numberFormatException) {
            System.err.println("Некорректно введен Id пользователя, числа вводи!");
        }
    }
//
//    @Override
//    public void inputAndCheckIdForUpdateEmailUserById() throws IOException {
//        try {
//            System.out.println("Введите id пользователя, кому меняем email");
//            long id = Long.parseLong(consoleReader.readLine());
//            if (userService.checkingIfUserExistsWithThisId(id)) {
//                System.out.println("Введите новый email");
//                String newEmail = consoleReader.readLine();
//                emailService.updateEmailUserById(new Email(id, newEmail, userService.));
//            } else {
//                System.err.println("Нет пользователя c таким id, так что email не поменяем никак");
//            }
//        } catch (NumberFormatException numberFormatException) {
//            System.err.println("Некорректно введен Id пользователя, числа вводи!");
//        }
//    }
//
//    @Override
//    public void inputAndCheckIdForUpdatePetUserById() throws IOException {
//        try {
//            System.out.println("Введите id пользователя, кому меняем зверушку");
//            long id = Long.parseLong(consoleReader.readLine());
//            if (userService.checkingIfUserExistsWithThisId(id)) {
//                System.out.println("Введите как зовут новую зверушку");
//                String name = consoleReader.readLine();
//                System.out.println("Введите какая теперь зверушка у пользователя");
//                String whatPet = consoleReader.readLine();
//                petService.updatePetUserById(id, name, whatPet);
//            } else System.err.println("Нет пользователя с таким id, так что зверушку мы не поменяем никак");
//        } catch (NumberFormatException numberFormatException) {
//            System.err.println("Некорректно введен Id пользователя, числа вводи!");
//        }
//    }
//
//    @Override
//    public void inputAndCheckIdForDeleteUserById() throws IOException {
//        try {
//            System.out.println("Введите id пользователя, которого удаляем");
//            long id = Long.parseLong(consoleReader.readLine());
//            if (userService.checkingIfUserExistsWithThisId(id)) {
//                userService.deleteUserById(id);
//            } else System.err.println("Нет пользователя с таким id, так что некого удалять");
//        } catch (NumberFormatException numberFormatException) {
//            System.err.println("Некорректно введен Id пользователя, числа вводи!");
//        }
//    }
}
