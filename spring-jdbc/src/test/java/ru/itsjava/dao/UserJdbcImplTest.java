package ru.itsjava.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.Pet;
import ru.itsjava.domain.User;

@JdbcTest
@Import({UserJdbcImpl.class, EmailJdbcImpl.class, PetJdbcImpl.class})
@DisplayName("Класс UserJdbcImpl должен: ")
public class UserJdbcImplTest {

    @Autowired
    private UserJdbc userJdbc;

    private final User testUser = new User(1L, "Test surname", "Test name", new Email("test email", 1L), new Pet("Test pet", "Test pet name", 1L));


    @DisplayName("Корректно создавать пользователя")
    @Test
    public void shouldHaveCorrectCreateUser() {
        User receivedUser = userJdbc.createUser(testUser);
        Assertions.assertEquals(testUser, userJdbc.getUserById(receivedUser.getId()).get());

    }
}
