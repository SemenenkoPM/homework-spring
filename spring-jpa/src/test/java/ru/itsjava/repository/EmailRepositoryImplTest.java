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
public class EmailRepositoryImplTest {
    @Autowired
    private EmailRepository emailRepository;

    @DisplayName("создавать email")
    @Test
    public void shouldHaveCorrectCreateEmail(){
        Email testEmail = new Email(0L, "testEmail3");
        Email receivedEmailFromDB = emailRepository.saveEmail(testEmail);
        testEmail.setId(receivedEmailFromDB.getId());
        Assertions.assertEquals(testEmail, receivedEmailFromDB);
    }
}
