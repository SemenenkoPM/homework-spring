//package ru.itsjava.dao;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
//import org.springframework.context.annotation.Import;
//import ru.itsjava.domain.Email;
//import ru.itsjava.domain.Pet;
//import ru.itsjava.domain.User;
//
//
//import java.util.List;
//
//@JdbcTest
//@Import({UserJdbcImpl.class, EmailJdbcImpl.class, PetJdbcImpl.class})
//@DisplayName("Класс UserJdbcImpl должен: ")
//public class UserJdbcImplTest {
//
//    @Autowired
//    private UserJdbc userJdbc;
//
//    private final User testUser = new User(1L, "Test surname", "Test name", new Email("test email", 1L), new Pet("Test pet name","Test pet",  1L));
//
//    @DisplayName("Корректно создавать пользователя")
//    @Test
//    public void shouldHaveCorrectCreateUser() {
//        User receivedUser = userJdbc.createUser(testUser);
//        Assertions.assertEquals(testUser, userJdbc.getUserById(receivedUser.getId()).get());
//    }
//
//    @DisplayName("Корректно получать всех пользователей")
//    @Test
//    public void shouldHaveCorrectGetAllUsers() {
//        List<User> listUsersFromDB = List.of(userJdbc.getUserById(1L).get(), userJdbc.getUserById(2L).get());
//        Assertions.assertEquals(listUsersFromDB, userJdbc.getAllUsers());
//    }
//
//    @DisplayName("Корректно получать пользователя по id")
//    @Test
//    public void shouldHaveCorrectGetUserById() {
//        User receivedUser = userJdbc.createUser(testUser);
//        Assertions.assertEquals(receivedUser, userJdbc.getUserById(receivedUser.getId()).get());
//    }
//
//    @DisplayName("Корректно удалять пользователя по id")
//    @Test
//    public void shouldHaveCorrectDeleteUserById() {
//        User receivedUser = userJdbc.createUser(testUser);
//        userJdbc.deleteUserById(receivedUser.getId());
//        Assertions.assertEquals(false, userJdbc.getUserById(receivedUser.getId()).isPresent());
//    }
//}
