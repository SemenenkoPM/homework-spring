package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.dao.EmailJdbc;
import ru.itsjava.dao.PetJdbc;
import ru.itsjava.dao.UserJdbc;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.Pet;
import ru.itsjava.domain.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserJdbc userJdbc;
    private final PetJdbc petJdbc;
    private final EmailJdbc emailJdbc;
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
                createUser();
            } else if (selectedMenuNumber.equals("2")) {
                printAllUsers();
            } else if (selectedMenuNumber.equals("3")) {
                printUserById();
            } else if (selectedMenuNumber.equals("4")) {
                updateEmailUserById();
            } else if (selectedMenuNumber.equals("5")) {
                updatePetUserById();
            } else if (selectedMenuNumber.equals("6")) {
                deleteUserById();
            } else {
                System.err.println("Нет такого пункта меню, выбери существующий пункт меню");
            }
        }
    }

    @Override
    public void createUser() throws IOException {
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
        User user = new User(1L, surname, name, new Email(inputEmail, 1L), new Pet(petName, whatPet, 1L));
        userJdbc.createUser(user);
        System.out.println("Создали нового пользователя: " + user);
    }

    @Override
    public void printAllUsers() {
        for (User user : userJdbc.getAllUsers()) {
            System.out.println(user);
        }
    }

    @Override
    public void printUserById() throws IOException {
        System.out.println("Введите id пользователя");
        long id = Long.parseLong(consoleReader.readLine());
        Optional<User> optionalUser = userJdbc.getUserById(id);
        if (optionalUser.isPresent()) {
            System.out.println(optionalUser.get());
        } else {
            System.err.println("Нет пользователя c таким id");
        }
    }

    @Override
    public void updateEmailUserById() throws IOException {
        System.out.println("Введите id пользователя, кому меняем email");
        long id = Long.parseLong(consoleReader.readLine());
        Optional<User> optionalUser = userJdbc.getUserById(id);
        if (optionalUser.isPresent()) {
            System.out.println("Введите новый email");
            String newEmail = consoleReader.readLine();
            emailJdbc.updateEmailUserById(id, newEmail);
        } else {
            System.err.println("Нет пользователя c таким id, так что email не поменяем никак");
        }
    }

    @Override
    public void updatePetUserById() throws IOException {
        System.out.println("Введите id пользователя, кому меняем зверушку");
        long id = Long.parseLong(consoleReader.readLine());
        Optional<User> optionalUser = userJdbc.getUserById(id);
        if (optionalUser.isPresent()) {
            System.out.println("Введите как зовут новую зверушку");
            String name = consoleReader.readLine();
            System.out.println("Введите какая теперь зверушка у пользователя");
            String whatPet = consoleReader.readLine();
            petJdbc.updatePetUserById(id, name, whatPet);
        } else System.err.println("Нет пользователя с таким id, так что зверушку мы не поменяем никак");
    }

    @Override
    public void deleteUserById() throws IOException {
        System.out.println("Введите id пользователя, которого удаляем");
        long id = Long.parseLong(consoleReader.readLine());
        Optional<User> optionalUser = userJdbc.getUserById(id);
        if (optionalUser.isPresent()) {
            userJdbc.deleteUserById(id);
        } else System.err.println("Нет пользователя с таким id, так что некого удалять");
    }
}
