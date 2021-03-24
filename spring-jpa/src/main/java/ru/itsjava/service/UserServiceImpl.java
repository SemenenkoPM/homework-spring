package ru.itsjava.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.domain.User;
import ru.itsjava.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.saveUser(user);
    }

    @Override
    public void printUserById(long id) {
        System.out.println(userRepository.getUserById(id));
    }

    @Override
    public boolean checkingIfUserExistsWithThisId(long id) {
        return userRepository.checkingIfUserExistsWithThisId(id);
    }
}
