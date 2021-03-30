package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.domain.Community;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.Pet;
import ru.itsjava.domain.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MainMenuServiceImpl implements MainMenuService {
    private final UserService userService;
    private final EmailService emailService;
    private final PetService petService;
//    private final CommunityService communityService;

    private final BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void getDataAndPrintCreatedUser() throws IOException {
        System.out.println("Введите фамилию пользователя");
        String surname = consoleReader.readLine();
        System.out.println("Введите имя пользователя");
        String name = consoleReader.readLine();
        System.out.println("если пользователь состоит в сообществе, введите его название, если нет, нажмите Enter");
        String community = consoleReader.readLine();
        System.out.println("Введите почту пользователя");
        String inputEmail = consoleReader.readLine();
        System.out.println("Как зовут зверушку");
        String petName = consoleReader.readLine();
        System.out.println("Какой зверушкой обладает пользователь");
        String whatPet = consoleReader.readLine();
        User createdUser;
        if (!(community == null)){
            createdUser = userService.createUser(new User(0L, surname, name, new Email(0L, inputEmail), new Community(0L, community)));
        } else {
            createdUser = userService.createUser(new User(0L, surname, name, new Email(0L, inputEmail)));
        }
        petService.createPet(new Pet(0L, petName, whatPet, createdUser.getId()));
        System.out.println("Создали нового пользователя: " + userService.getUserById(createdUser.getId()));
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
            if (userService.checkingIfUserExistsWithThisId(id)) {
                System.out.println(userService.getUserById(id));
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
            if (userService.checkingIfUserExistsWithThisId(id)) {
                System.out.println("Введите новый email");
                String newEmail = consoleReader.readLine();
                emailService.updateEmailUserById(id, newEmail);
            } else {
                System.err.println("Нет пользователя c таким id, так что email не поменяем никак");
            }
        } catch (NumberFormatException numberFormatException) {
            System.err.println("Некорректно введен Id пользователя, числа вводи!");
        }
    }

//    @Override
//    public void getDataAndCheckIdForUpdatePetByUserId() throws IOException {
//        try {
//            System.out.println("Введите id пользователя, кому меняем зверушку");
//            long id = Long.parseLong(consoleReader.readLine());
//            if (userService.checkingIfUserExistsWithThisId(id)) {
//                // получить пет по ид пользователя
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

    @Override
    public void inputAndCheckIdForDeleteUserById() throws IOException {
        try {
            System.out.println("Введите id пользователя, которого удаляем");
            long id = Long.parseLong(consoleReader.readLine());
            if (userService.checkingIfUserExistsWithThisId(id)) {
                userService.deleteUserById(id);
            } else System.err.println("Нет пользователя с таким id, так что некого удалять");
        } catch (NumberFormatException numberFormatException) {
            System.err.println("Некорректно введен Id пользователя, числа вводи!");
        }
    }
}
