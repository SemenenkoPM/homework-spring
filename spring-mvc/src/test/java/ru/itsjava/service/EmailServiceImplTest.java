package ru.itsjava.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.Email;

@DataJpaTest
@Import({EmailServiceImpl.class})
@DisplayName("Класс EmailServiceImpl должен корректно: ")
public class EmailServiceImplTest {
    @Autowired
    private EmailService emailService;

    private Email email = new Email(0L, "testEmail");

    @DisplayName("получать email по id")
    @Test
    public void shouldHaveCorrectGetEmailById(){
        Email savedEmailDb = emailService.createEmail(email);
        Assertions.assertEquals(savedEmailDb, emailService.getEmailById(savedEmailDb.getId()));
    }

    @DisplayName("создавать email")
    @Test
    public void shouldHaveCorrectCreateEmail(){
        Email savedEmailDb = emailService.createEmail(email);
        email.setId(savedEmailDb.getId());
        Assertions.assertEquals(email, savedEmailDb);
    }

    @DisplayName("корректно обновлять email по id")
    @Test
    public void shouldHaveCorrectUpdateEmailById(){
        Email savedEmailDb = emailService.createEmail(email);
        Assertions.assertEquals("testEmail2", emailService.updateEmailById(savedEmailDb.getId(), "testEmail2").getEmail());
    }
}
