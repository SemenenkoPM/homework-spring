package ru.itsjava.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import ru.itsjava.domain.User;

@JdbcTest
@Import(UserJdbcImpl.class)
@DisplayName("Класс UserJdbcImpl должен: ")
public class UserJdbcImplTest {

    @Autowired
    private UserJdbc userJdbc;



    @DisplayName("Корректно создавать пользователя")
    @Test
    public void shouldHaveCorrectCreateUser() {
        User testUser = new User("Test surname", "Test name");
        long testId = userJdbc.createUser(testUser);
        System.out.println(testId);
        Assertions.assertEquals(testUser, userJdbc.getUserById(testId));
        // получается, что я когда беру гетюзер, то создаю его с вместе с имайл и петом, или создавать пользователя по второму конструктору, тогда с id как быть?

    }
}
