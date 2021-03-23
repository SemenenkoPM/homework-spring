package ru.itsjava.repository;

import ru.itsjava.domain.User;

public interface UserRepository {
    User saveUser(User user);
}
