package ru.itsjava.repository;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.Pet;
import ru.itsjava.domain.User;

import java.util.List;

@DataJpaTest
@Import(UserRepositoryImpl.class)
@DisplayName("Класс UserRepositoryImpl должен корректно: ")
public class UserRepositoryImplTest {
    @Autowired
    private UserRepository userRepository;

    private User testUser = new User(0L, "testSurname3", "testName3", new Email(0L, "testEmail3"), new Pet(0L, "testPetName3", "testPet3"));

    @DisplayName("сохранять пользователя")
    @Test
    public void shouldHaveCorrectSaveUser() {
        User receivedUserFromDB = userRepository.saveUser(testUser);
        testUser.setId(receivedUserFromDB.getId());
        testUser.getEmail().setId(receivedUserFromDB.getEmail().getId());
        testUser.getPet().setId(receivedUserFromDB.getPet().getId());
        Assertions.assertEquals(testUser, receivedUserFromDB);
    }

    @DisplayName("вызвращать всех пользователей")
    @Test
    public void shouldHaveCorrectGetAllUsers() {
        List<User> userList = List.of(userRepository.getUserById(1), userRepository.getUserById(2));
        Assertions.assertEquals(userList, userRepository.getAllUsers());
    }

    @DisplayName("проверять, существует ли пользователь по id")
    @Test
    public void shouldHaveCorrectCheckingIfUserExistsWithThisId() {
        Assertions.assertTrue(userRepository.checkingIfUserExistsWithThisId(1));
        Assertions.assertFalse(userRepository.checkingIfUserExistsWithThisId(3));
    }

    @DisplayName("корректно возвращать пользователя по id")
    @Test
    public void shouldHaveCorrectGetUserById() {
        User receivedUserFromDB = userRepository.saveUser(testUser);
        testUser.setId(receivedUserFromDB.getId());
        testUser.getEmail().setId(receivedUserFromDB.getEmail().getId());
        testUser.getPet().setId(receivedUserFromDB.getPet().getId());
        Assertions.assertEquals(testUser, userRepository.getUserById(testUser.getId()));
    }

    @DisplayName("удалять пользователя по id")
    @Test
    public void shouldHaveCorrectDeleteUserById() {
        userRepository.deleteUserById(userRepository.getUserById(1));
        Assertions.assertFalse(userRepository.checkingIfUserExistsWithThisId(1));
    }
}
