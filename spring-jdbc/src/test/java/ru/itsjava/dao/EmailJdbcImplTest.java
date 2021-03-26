package ru.itsjava.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.Email;

@JdbcTest
@DisplayName("Класс EmailJdbcImpl должен корректно: ")
@Import(EmailJdbcImpl.class)
public class EmailJdbcImplTest {
    @Autowired
    private EmailJdbc emailJdbc;

    @DisplayName("Корректно создавать email")
    @Test
    public void shouldHaveCorrectCreateEmail() {
        Email testEmail = new Email(0L, "test@mail.com");
        long testEmailId = emailJdbc.createEmail(testEmail.getEmail());
        testEmail.setId(testEmailId);
        Assertions.assertEquals(testEmail, emailJdbc.getEmailById(testEmailId));
    }

    @DisplayName("Корректно получать email по id")
    @Test
    public void shouldHaveCorrectGetEmailById() {
        Email testEmail = new Email(1, "Test@.com");
        Assertions.assertEquals(testEmail, emailJdbc.getEmailById(1L));
    }

    @DisplayName("Корректно изменять email по id пользователя")
    @Test
    public void shouldHaveCorrectUpdateEmailUserById() {
        Email testEmail = new Email(0L, "test@mail.com");
        long testEmailId = emailJdbc.createEmail(testEmail.getEmail());
        emailJdbc.updateEmailUserById(testEmailId, "test@yandex.ru");
        Assertions.assertEquals("test@yandex.ru", emailJdbc.getEmailById(testEmailId).getEmail());
    }
}
