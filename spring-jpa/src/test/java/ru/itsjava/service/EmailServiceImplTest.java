package ru.itsjava.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.Email;
import ru.itsjava.repository.EmailRepositoryImpl;

@DataJpaTest
@Import({EmailServiceImpl.class, EmailRepositoryImpl.class})
@DisplayName("Класс EmailServiceImpl должен корректно: ")
public class EmailServiceImplTest {
    @Autowired
    private EmailService emailService;

    @DisplayName("сохранять email")
    @Test
    public void shouldHaveCorrectSaveEmail(){
        Email testEmail = new Email(0L, "testEmail3");
        Email receivedEmailFromDB = emailService.createEmail(testEmail);
        testEmail.setId(receivedEmailFromDB.getId());
        Assertions.assertEquals(testEmail, receivedEmailFromDB);
    }
}
