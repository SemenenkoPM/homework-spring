package ru.itsjava.dao;

import org.h2.tools.Console;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.Pet;
import ru.itsjava.domain.User;

import java.sql.SQLException;
import java.util.Optional;

@JdbcTest
@Import(UserJdbcImpl.class)
@DisplayName("Класс UserJdbcImpl должен: ")
public class UserJdbcImplTest {

    @Autowired
    private UserJdbc userJdbc;

    private final User testUser = new User(1, "Test surname", "Test name", new Email("Test@.com", 1), new Pet("Test Pet", "Test name pet", 1));


    @DisplayName("Корректно создавать пользователя")
    @Test
    public void shouldHaveCorrectCreateUser() throws SQLException {
        Console.main();
        long testId = userJdbc.createUser(testUser);

        Optional<User> user1 = userJdbc.getUserById(1);
        user1.get();

        Assertions.assertEquals(testUser, userJdbc.getUserById(1).get());

    }
}
