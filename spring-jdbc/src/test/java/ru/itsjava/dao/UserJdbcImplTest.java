package ru.itsjava.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.User;

import java.util.List;

@JdbcTest
@Import(UserJdbcImpl.class)
@DisplayName("Класс UserJdbcImpl должен: ")
public class UserJdbcImplTest {

    @Autowired
    private UserJdbc userJdbc;

    private final User testUser = new User(2L, "Test surname", "Test name", 1L, 1L);

    @DisplayName("Корректно создавать пользователя")
    @Test
    public void shouldHaveCorrectCreateUser() {
        long userIdFromDB = userJdbc.createUser(testUser.getSurname(), testUser.getName(), testUser.getEmailId(), testUser.getPetId());
        testUser.setId(userIdFromDB);
        Assertions.assertEquals(testUser, userJdbc.getUserById(userIdFromDB).get());
    }

    @DisplayName("Корректно получать всех пользователей")
    @Test
    public void shouldHaveCorrectGetAllUsers() {
        userJdbc.createUser(testUser.getSurname(), testUser.getName(), testUser.getEmailId(), testUser.getPetId());
        List<User> listUsersFromDB = List.of(userJdbc.getUserById(1L).get(), userJdbc.getUserById(2L).get());
        Assertions.assertEquals(listUsersFromDB, userJdbc.getAllUsers());
    }

    @DisplayName("Корректно получать пользователя по id")
    @Test
    public void shouldHaveCorrectGetUserById() {
        long userIdFromDB = userJdbc.createUser(testUser.getSurname(), testUser.getName(), testUser.getEmailId(), testUser.getPetId());
        testUser.setId(userIdFromDB);
        Assertions.assertEquals(testUser, userJdbc.getUserById(testUser.getId()).get());
    }

    @DisplayName("Корректно удалять пользователя по id")
    @Test
    public void shouldHaveCorrectDeleteUserById() {
        userJdbc.createUser(testUser.getSurname(), testUser.getName(), testUser.getEmailId(), testUser.getPetId());
        userJdbc.deleteUserById(testUser.getId());
        Assertions.assertFalse(userJdbc.getUserById(testUser.getId()).isPresent());
    }
}
