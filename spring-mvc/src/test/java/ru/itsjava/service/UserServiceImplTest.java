package ru.itsjava.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.Community;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.Pet;
import ru.itsjava.domain.User;

import java.util.List;

@DataJpaTest
@Import({UserServiceImpl.class, PetServiceImpl.class, CommunityServiceImpl.class})
@DisplayName("Класс UserServiceImpl должен корректно: ")
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    private User user = new User(0L, "testSurname", "testName",
            new Email(0L, "testEmail"), new Community(0L, "testCommunity"));

    private Pet pet = new Pet(0L, "testPetName", "testWhatPet", 0L);

    @DisplayName("создавать user")
    @Test
    public void shouldHaveCorrectCreateUser() {
        User savedUserDb = userService.createUser(user, pet);
        user = userService.getUserById(savedUserDb.getId());
        Assertions.assertEquals(user, savedUserDb);
    }

    @DisplayName(" получать всех users")
    @Test
    public void shouldHaveCorrectGetAllUsers() {
        List<User> userList = List.of(userService.getUserById(1L));
        Assertions.assertEquals(userList, userService.getAllUsers());
    }

    @DisplayName("проверять есть ли пользователь с таким id")
    @Test
    public void shouldHaveCorrectCheckingIfUserExistsWithThisId(){
        Assertions.assertTrue(userService.checkingIfUserExistsWithThisId(1L));
        Assertions.assertFalse(userService.checkingIfUserExistsWithThisId(2L));
    }

    @DisplayName("получать user по id")
    @Test
    public void shouldHaveCorrectUserById(){
        User savedUserDb = userService.createUser(user, pet);
        Assertions.assertEquals(savedUserDb, userService.getUserById(savedUserDb.getId()));
    }

    @DisplayName("изменять имя и фамилию у user")
    @Test
    public void shouldHaveCorrectUpdateUserNameAndSurname(){
        User savedUserDB = userService.createUser(user, pet);
        savedUserDB.setName("new Name");
        savedUserDB.setSurname("new Surname");
        Assertions.assertEquals(savedUserDB,
                userService.updateUserNameAndSurname(savedUserDB.getId(),"new Surname", "new Name"));

    }
}
