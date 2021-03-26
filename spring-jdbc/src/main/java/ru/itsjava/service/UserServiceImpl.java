package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.dao.UserJdbc;
import ru.itsjava.domain.User;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserJdbc userJdbc;

    @Override
    public boolean checkingIfUserExistsById(long id) {
        Optional<User> optionalUser = userJdbc.getUserById(id);
        return optionalUser.isPresent();
    }

    @Override
    public User createUser(String surname, String name, long emailId, long petId) {
        long receivedId = userJdbc.createUser(surname, name, emailId, petId);
        return new User(receivedId, surname, name, emailId, petId);
    }

    @Override
    public List<User> getAllUsers() {
        return userJdbc.getAllUsers();
    }

    @Override
    public User getUserById(long id) {
        return userJdbc.getUserById(id).get();
    }

    @Override
    public void deleteUserById(long id) {
        userJdbc.deleteUserById(id);
    }
}
