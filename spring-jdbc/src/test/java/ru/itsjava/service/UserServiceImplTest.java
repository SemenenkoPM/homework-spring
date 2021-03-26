//package ru.itsjava.service;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
//import org.springframework.context.annotation.Import;
//import ru.itsjava.dao.*;
//import ru.itsjava.domain.Email;
//import ru.itsjava.domain.Pet;
//import ru.itsjava.domain.User;
//
//@JdbcTest
//@Import({UserServiceImpl.class, UserJdbcImpl.class, EmailJdbcImpl.class, PetJdbcImpl.class})
//@DisplayName("Класс UserServiceImpl должен: ")
//public class UserServiceImplTest {
//    @Autowired
//    private UserService userService;
//
//    private final User testUser = new User(1L, "Test surname", "Test name", new Email("test email", 1L), new Pet("Test pet name", "Test pet", 1L));
//
//    @DisplayName("Корректно проверять существует ли пользователь с таким id")
//    @Test
//    public void shouldHaveCorrectCheckingIfUserExistsWithThisId() {
//        User receivedUserFromDB = userService.createUser(testUser);
//        long id = receivedUserFromDB.getId();
//        Assertions.assertEquals(true, userService.checkingIfUserExistsWithThisId(id));
//    }
//
//    @DisplayName("Корректно создавать пользователя")
//    @Test
//    public void shouldHaveCorrectCreateUser() {
//        User receivedUserFromDB = userService.createUser(testUser);
//        System.out.println("receivedUserFromDB = " + receivedUserFromDB);
//        Assertions.assertEquals(testUser, receivedUserFromDB);
//    }
//}
