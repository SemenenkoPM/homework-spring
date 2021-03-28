package ru.itsjava.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.Pet;
import ru.itsjava.domain.User;
import ru.itsjava.repository.UserRepository;
import ru.itsjava.repository.UserRepositoryImpl;

import java.util.List;

@DataJpaTest
@Import({UserServiceImpl.class, UserRepositoryImpl.class})
@DisplayName("Класс UserServiceImpl должен корректно: ")
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    private User testUser = new User(0L, "testSurname3", "testName3", new Email(0L, "testEmail3"), new Pet(0L, "testPetName3", "testPet3"));

    @DisplayName("создавать пользователя")
    @Test
    public void shouldHaveCorrectCreateUser(){
        User receivedUserFromDB = userService.createUser(testUser);
        testUser.setId(receivedUserFromDB.getId());
        Assertions.assertEquals(testUser, receivedUserFromDB);
    }

    @DisplayName("получать всех пользователей")
    @Test
    public void shouldHaveCorrectGetAllUsers(){
        List<User> userList = List.of(userService.getUserById(1L), userService.getUserById(2L));
        Assertions.assertEquals(userList, userService.getAllUsers());
    }

    @DisplayName("проверять есть ли пользователь по id")
    @Test
    public void shouldHaveCorrectCheckingIfUserExistsWithThisId(){
        Assertions.assertTrue(userService.checkingIfUserExistsWithThisId(1L));
        Assertions.assertFalse(userService.checkingIfUserExistsWithThisId(3L));
    }

    @DisplayName("возвращать пользователя по id")
    @Test
    public void shouldHaveCorrectGetUserById(){
        User receivedUserFromDB = userService.createUser(testUser);
        testUser.setId(receivedUserFromDB.getId());
        testUser.getEmail().setId(receivedUserFromDB.getEmail().getId());
        testUser.getPet().setId(receivedUserFromDB.getPet().getId());
        Assertions.assertEquals(testUser, userService.getUserById(testUser.getId()));
    }

    @DisplayName("удалять пользователя по id")
    @Test
    public void shouldHaveCorrectDeleteUserById() {
        userService.deleteUserById(1L);
        Assertions.assertFalse(userService.checkingIfUserExistsWithThisId(1L));
    }
}
