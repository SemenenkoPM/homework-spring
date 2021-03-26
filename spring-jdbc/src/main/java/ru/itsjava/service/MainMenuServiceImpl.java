package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.Pet;
import ru.itsjava.domain.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
@RequiredArgsConstructor
public class MainMenuServiceImpl implements MainMenuService {
    private final UserService userService;
    private final EmailService emailService;
    private final PetService petService;

    private final BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void getDataAndPrintCreatedUser() throws IOException {
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
        Email email = emailService.createEmail(inputEmail);
        Pet pet = petService.createPet(petName, whatPet);
        User user = userService.createUser(surname, name, email.getId(), pet.getId());
        System.out.println("Создали нового пользователя с Email и Pet: " + user + email + pet);
    }

    @Override
    public void printAllUsers() {
        for (User user : userService.getAllUsers()) {
            System.out.println(user);
        }
    }

    @Override
    public void getDataAndCheckIdPrintUserById() throws IOException {
        try {
            System.out.println("Введите id пользователя");
            long id = Long.parseLong(consoleReader.readLine());
            if (userService.checkingIfUserExistsById(id)) {
                User user = userService.getUserById(id);
                Email email = emailService.getEmailById(user.getEmailId());
                Pet pet = petService.getPetById(user.getPetId());
                System.out.println("вот твой пользователь " + user + email + pet);
            } else {
                System.err.println("Нет пользователя c таким id");
            }
        } catch (NumberFormatException numberFormatException) {
            System.err.println("Некорректно введен Id пользователя, числа вводи!");
        }
    }

    @Override
    public void getDataAndCheckIdForUpdateEmailByUserId() throws IOException {
        try {
            System.out.println("Введите id пользователя, кому меняем email");
            long id = Long.parseLong(consoleReader.readLine());
            if (userService.checkingIfUserExistsById(id)) {
                System.out.println("Введите новый email");
                String newEmail = consoleReader.readLine();
                User user = userService.getUserById(id);
                emailService.updateEmailUserById(user.getEmailId(), newEmail);
            } else {
                System.err.println("Нет пользователя c таким id, так что email не поменяем никак");
            }
        } catch (NumberFormatException numberFormatException) {
            System.err.println("Некорректно введен Id пользователя, числа вводи!");
        }
    }

    @Override
    public void getDataAndCheckIdForUpdatePetByUserId() throws IOException {
        try {
            System.out.println("Введите id пользователя, кому меняем зверушку");
            long id = Long.parseLong(consoleReader.readLine());
            if (userService.checkingIfUserExistsById(id)) {
                System.out.println("Введите как зовут новую зверушку");
                String name = consoleReader.readLine();
                System.out.println("Введите какая теперь зверушка у пользователя");
                String whatPet = consoleReader.readLine();
                User user = userService.getUserById(id);
                petService.updatePetUserById(user.getPetId(), name, whatPet);
            } else System.err.println("Нет пользователя с таким id, так что зверушку мы не поменяем никак");
        } catch (NumberFormatException numberFormatException) {
            System.err.println("Некорректно введен Id пользователя, числа вводи!");
        }
    }

    @Override
    public void inputAndCheckIdForDeleteUserById() throws IOException {
        try {
            System.out.println("Введите id пользователя, которого удаляем");
            long id = Long.parseLong(consoleReader.readLine());
            if (userService.checkingIfUserExistsById(id)) {
                User user = userService.getUserById(id);
                emailService.deleteEmailById(user.getEmailId());
                petService.deletePetById(user.getPetId());
                userService.deleteUserById(id);
            } else System.err.println("Нет пользователя с таким id, так что некого удалять");
        } catch (NumberFormatException numberFormatException) {
            System.err.println("Некорректно введен Id пользователя, числа вводи!");
        }
    }
}
