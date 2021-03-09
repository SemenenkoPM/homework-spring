package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import ru.itsjava.dao.UserJdbc;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.Pet;
import ru.itsjava.domain.User;

import java.util.Scanner;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{
    private final UserJdbc userJdbc;
    Scanner scanner = new Scanner(System.in);

    @Override
    public void printMenu(){
        System.out.println("выберите пункт меню \n" +
                "1. Создать пользователя");
        int selectedMenuNumber = scanner.nextInt();
        if(selectedMenuNumber == 1){
            createUser();
        }
    }


    @Override
    public void createUser() {
        System.out.println("Введите фамилию пользоателя");
        String surname = scanner.nextLine();
        System.out.println("Введите имя пользователя");
        String name = scanner.nextLine();
        System.out.println("Введите почту пользоателя");
        String email = scanner.nextLine();
        System.out.println("Какой зверушкой обладает пользователь");
        String whatPet = scanner.nextLine();
        System.out.println("Как зовут зверушку");
        String petName = scanner.nextLine();
        User user = new User(surname, name, new Email(email), new Pet(whatPet, petName));
        userJdbc.createUser(user);
    }
}
