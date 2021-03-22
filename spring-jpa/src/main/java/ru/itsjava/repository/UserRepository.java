package ru.itsjava.repository;

import ru.itsjava.domain.User;

public interface UserRepository {
    User save(User user);
}
