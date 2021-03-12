package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import ru.itsjava.dao.EmailJdbc;
import ru.itsjava.dao.PetJdbc;
import ru.itsjava.dao.UserJdbc;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.Pet;
import ru.itsjava.domain.User;

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
                "3. Вывести пользователя по id");
        int selectedMenuNumber = scanner.nextInt();
        if (selectedMenuNumber == 1) {
            createUser();
        } else if (selectedMenuNumber == 2) {

        } else if (selectedMenuNumber == 3) {
            getUserById();
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
        long userIdReseived = userJdbc.createUser(user);
        Email email = new Email(inputEmail, userIdReseived);
        Pet pet = new Pet(whatPet, petName, userIdReseived);
        emailJdbc.createEmail(email);
        petJdbc.createPet(pet);
    }

    @Override
    public void printAllUsers() {


    }

    @Override
    public void getUserById() {
        System.out.println("Введите id пользователя");
        long id = scanner.nextLong();
        System.out.println(userJdbc.getUserById(id));
    }
}
