package ru.itsjava.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.dao.UserJdbcImpl;
import ru.itsjava.domain.User;

import java.util.List;

@JdbcTest
@Import({UserServiceImpl.class, UserJdbcImpl.class})
@DisplayName("Класс UserServiceImpl должен: ")
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    private final User testUser = new User(2L, "Test surname", "Test name", 1L, 1L);

    @DisplayName("Корректно проверять существует ли пользователь с таким id")
    @Test
    public void shouldHaveCorrectCheckingIfUserExistsWithThisId() {
        User userFromDB = userService.createUser("Test surname", "Test name", 1L, 1L);
        long id = userFromDB.getId();
        Assertions.assertTrue(userService.checkingIfUserExistsById(id));
    }

    @DisplayName("Корректно создавать пользователя")
    @Test
    public void shouldHaveCorrectCreateUser() {
        User userFromDB = userService.createUser("Test surname", "Test name", 1L, 1L);
        testUser.setId(userFromDB.getId());
        Assertions.assertEquals(testUser, userFromDB);
    }

    @DisplayName("Корректно возвращать всех пользователей")
    @Test
    public void shouldHaveCorrectGetAllUsers() {
        userService.createUser("Test surname", "Test name", 1L, 1L);
        List<User> listUsersFromDB = List.of(userService.getUserById(1L), userService.getUserById(2L));
        Assertions.assertEquals(listUsersFromDB, userService.getAllUsers());
    }

    @DisplayName("Корректно возвращать пользователя по id")
    @Test
    public void shouldHaveCorrectGetUserById() {
        User userFromDB = userService.createUser("Test surname", "Test name", 1L, 1L);
        testUser.setId(userFromDB.getId());
        Assertions.assertEquals(testUser, userService.getUserById(testUser.getId()));
    }

    @DisplayName("Корректно удалять пользователя по id")
    @Test
    public void shouldHaveCorrectDeleteUserById(){
        User userFromDB = userService.createUser("Test surname", "Test name", 1L, 1L);
        long userId = userFromDB.getId();
        userService.deleteUserById(userId);
        Assertions.assertFalse(userService.checkingIfUserExistsById(userId));
    }
}
