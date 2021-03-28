package ru.itsjava.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.Email;

@DataJpaTest
@Import(EmailRepositoryImpl.class)
@DisplayName("Класс EmailRepositoryImpl должен корректно: ")
public class EmailRepositoryImpl {
    @Autowired
    private EmailRepository emailRepository;

    @DisplayName("сохранять email")
    @Test
    public void shouldHaveCorrectSaveEmail(){
        Email testEmail = new Email(0L, "testEmail3");
        Email receivedEmailFromDB = emailRepository.saveEmail(testEmail);
        testEmail.setId(receivedEmailFromDB.getId());
        Assertions.assertEquals(testEmail, receivedEmailFromDB);
    }
}
