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
@Import({PetJdbcImpl.class, EmailJdbcImpl.class, UserJdbcImpl.class})
@DisplayName("Класс PetJdbcImpl должен: ")
public class PetJdbcImplTest {

    @Autowired
    private PetJdbc petJdbc;
    @Autowired
    private UserJdbc userJdbc;

    @DisplayName("Корректно изменять зверушку по id пользователя")
    @Test
    public void shouldHaveCorrectUpdatePetUserById(){
        User testUser = new User(1L, "Test surname", "Test name", new Email("test email", 1L), new Pet("Test pet", "Test pet name", 1L));
        User receivedUser = userJdbc.createUser(testUser);
        petJdbc.updatePetUserById(receivedUser.getPet().getUserId(), "new testPet", "new testName");
        User userAfterUpdatePetUserById = userJdbc.getUserById(receivedUser.getId()).get();
        Assertions.assertEquals("new testPet", userAfterUpdatePetUserById.getPet().getWhatPet());
        Assertions.assertEquals("new testName", userAfterUpdatePetUserById.getPet().getName());
    }
}
