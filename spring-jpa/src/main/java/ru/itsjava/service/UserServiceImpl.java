package ru.itsjava.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.domain.User;
import ru.itsjava.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.saveUser(user);
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public boolean checkingIfUserExistsWithThisId(long id) {
        return userRepository.checkingIfUserExistsWithThisId(id);
    }

    @Override
    public void printUserById(long id) {
        System.out.println(userRepository.getUserById(id));
    }



}
