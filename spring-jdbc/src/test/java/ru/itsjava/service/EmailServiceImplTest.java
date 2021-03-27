package ru.itsjava.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.dao.EmailJdbcImpl;
import ru.itsjava.domain.Email;

@JdbcTest
@Import({EmailServiceImpl.class, EmailJdbcImpl.class})
@DisplayName("Класс EmailServiceImpl должен: ")
public class EmailServiceImplTest {
    @Autowired
    private EmailService emailService;

    private final Email testEmail = new Email(2L, "TestEmail");

    @DisplayName("Корректно создавать email")
    @Test
    public void shouldHaveCorrectCreateEmail() {
        Email emailFromDB = emailService.createEmail("TestEmail");
        testEmail.setId(emailFromDB.getId());
        Assertions.assertEquals(testEmail, emailFromDB);
    }

    @DisplayName("Корректно возвращать email по id")
    @Test
    public void shouldHaveCorrectGetEmailById() {
        Email emailFromDB = emailService.createEmail("TestEmail");
        testEmail.setId(emailFromDB.getId());
        Assertions.assertEquals(testEmail, emailService.getEmailById(testEmail.getId()));
    }

    @DisplayName("Корректно обновлять email по id")
    @Test
    public void shouldHaveCorrectUpdateEmailById() {
        Email emailFromDB = emailService.createEmail("TestEmail");
        long id = emailFromDB.getId();
        emailService.updateEmailUserById(id, "testEmail1");
        Assertions.assertEquals("testEmail1", emailService.getEmailById(id).getEmail());
    }
}
