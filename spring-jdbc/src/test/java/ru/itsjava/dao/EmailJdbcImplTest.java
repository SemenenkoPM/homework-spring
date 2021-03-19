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
@DisplayName("Класс EmailJdbcImpl должен корректно: ")
@Import({UserJdbcImpl.class, EmailJdbcImpl.class, PetJdbcImpl.class})
public class EmailJdbcImplTest {
    @Autowired
    private EmailJdbc emailJdbc;
    @Autowired
    private UserJdbc userJdbc;

    @DisplayName("Корректно изменять email по id пользователя")
    @Test
    public void shouldHaveCorrectUpdateEmailUserById() {
        User testUser = new User(1L, "Test surname", "Test name", new Email("test email", 1L), new Pet("Test pet", "Test pet name", 1L));
        User receivedUser = userJdbc.createUser(testUser);
        emailJdbc.updateEmailUserById(receivedUser.getEmail().getUserId(), "new testEmail");
        User userAfterUpdatePetUserById = userJdbc.getUserById(receivedUser.getId()).get();
        Assertions.assertEquals("new testEmail", userAfterUpdatePetUserById.getEmail().getEmail());
    }
}
