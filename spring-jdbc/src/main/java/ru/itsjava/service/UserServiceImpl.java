package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import ru.itsjava.dao.EmailJdbc;
import ru.itsjava.dao.PetJdbc;
import ru.itsjava.dao.UserJdbc;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.Pet;
import ru.itsjava.domain.User;

import java.util.Optional;
import java.util.Scanner;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserJdbc userJdbc;
    private final PetJdbc petJdbc;
    private final EmailJdbc emailJdbc;
    Scanner scanner = new Scanner(System.in);

    @Override
    public void printMenu() {
        System.out.println("выберите пункт меню \n" +
                "1. Создать пользователя\n" +
                "2. Вывести всех пользователей\n" +
                "3. Вывести пользователя по id\n" +
                "4. Изменить email пользователя\n" +
                "5. Изменить зверушку пользователя\n" +
                "6. Удалить пользователя по id");
        int selectedMenuNumber = scanner.nextInt();
        if (selectedMenuNumber == 1) {
            createUser();
        }
        if (selectedMenuNumber == 2) {
            printAllUsers();
        }
        if (selectedMenuNumber == 3) {
            getUserById();
        }
        if (selectedMenuNumber == 4) {
            updateEmailUserById();
        }
        if (selectedMenuNumber == 5) {
            updatePetUserById();
        }
        if (selectedMenuNumber == 6) {
            deleteUserById();
        }
    }

    @Override
    public void createUser() {
        scanner.nextLine(); // здесь если не поставить сканнер, то пропускает surname?
        System.out.println("Введите фамилию пользователя");
        String surname = scanner.nextLine();
        System.out.println("Введите имя пользователя");
        String name = scanner.nextLine();
        System.out.println("Введите почту пользователя");
        String inputEmail = scanner.nextLine();
        System.out.println("Какой зверушкой обладает пользователь");
        String whatPet = scanner.nextLine();
        System.out.println("Как зовут зверушку");
        String petName = scanner.nextLine();
        User user = new User(surname, name);
        long userIdReceived = userJdbc.createUser(user);
        user.setId(userIdReceived);
        Email email = new Email(inputEmail, userIdReceived);
        Pet pet = new Pet(whatPet, petName, userIdReceived);
        emailJdbc.createEmail(email); //id в имаил записать и пет
        petJdbc.createPet(pet);
    }

    @Override
    public void printAllUsers() {
        for (User user : userJdbc.getAllUsers()) { // без цикла печать идет в строчку?
            System.out.println(user);
        }
    }

    @Override
    public void getUserById() {
        System.out.println("Введите id пользователя");
        long id = scanner.nextLong();
        Optional<User> optionalUser = userJdbc.getUserById(id);

        if (optionalUser.isPresent()) {
            System.out.println(optionalUser.get());
        } else {
            System.err.println("Нет пользователя c таким id");
        }
    }

    // нужна проверка есть ли такой id пользователя
    @Override
    public void updateEmailUserById() {
        System.out.println("Введите id пользователя, кому меняем email");
        long id = scanner.nextLong();
        Optional<User> optionalUser = userJdbc.getUserById(id);
        if(optionalUser.isPresent()) {
            System.out.println("Введите новый email");
            scanner.nextLine(); // если не поставить, то не считывает следующую строчку
            String newEmail = scanner.nextLine();
            emailJdbc.updateEmailUserById(id, newEmail);
        } else {
            System.err.println("Нет пользователя c таким id, так что email не поменяем никак");
        }
    }

    @Override
    public void updatePetUserById() {
        System.out.println("Введите id пользователя, кому меняем зверушку");
        long id = scanner.nextLong();
        scanner.nextLine(); // если не поставить, то не считывает следующую строчку
        System.out.println("Введите какая теперь зверушка у пользователя");
        String whatPet = scanner.nextLine();
        System.out.println("Введите как зовут новую зверушку");
        String name = scanner.nextLine();
        petJdbc.updatePetUserById(id, whatPet, name);
    }

    @Override
    public void deleteUserById() {
        System.out.println("Введите id пользователя, которого удаляем");
        long id = scanner.nextLong();
        userJdbc.deleteUserById(id);
    }
}
