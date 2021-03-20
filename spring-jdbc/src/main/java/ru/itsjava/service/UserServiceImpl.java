package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.dao.UserJdbc;
import ru.itsjava.domain.User;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserJdbc userJdbc;

    @Override
    public boolean checkingIfUserExistsWithThisId(long id) {
        Optional<User> optionalUser = userJdbc.getUserById(id);
        return optionalUser.isPresent();
    }

    @Override
    public User createUser(User user) {
        return userJdbc.createUser(user);
    }

    @Override
    public void printAllUsers() {
        for (User user : userJdbc.getAllUsers()) {
            System.out.println(user);
        }
    }

    @Override
    public void printUserById(long id) {
        System.out.println(userJdbc.getUserById(id).get());
    }

    @Override
    public void deleteUserById(long id) {
        userJdbc.deleteUserById(id);
    }
}
