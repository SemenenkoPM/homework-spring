package ru.itsjava.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.Pet;

@JdbcTest
@Import(PetJdbcImpl.class)
@DisplayName("Класс PetJdbcImpl должен: ")
public class PetJdbcImplTest {

    @Autowired
    private PetJdbc petJdbc;

    @DisplayName("Корректно создавать зверушку")
    @Test
    public void shouldHaveCorrectCreateEmail() {
        Pet testPet = new Pet(0L, "testName", "testPet");
        long testPetId = petJdbc.createPet(testPet.getName(), testPet.getWhatPet());
        testPet.setId(testPetId);
        Assertions.assertEquals(testPet, petJdbc.getPetById(testPetId));
    }

    @DisplayName("Корректно получать pet по id")
    @Test
    public void shouldHaveCorrectGetPetById() {
        Pet testPet = new Pet(1, "Test name pet", "Test Pet");
        Assertions.assertEquals(testPet, petJdbc.getPetById(1L));
    }

    @DisplayName("Корректно изменять pet по id пользователя")
    @Test
    public void shouldHaveCorrectUpdateEmailUserById() {
        Pet testPet = new Pet(0L, "testName", "testPet");
        long testPetId = petJdbc.createPet(testPet.getName(), testPet.getWhatPet());
        petJdbc.updatePetUserById(testPetId, "testName1", "testPet1");
        Assertions.assertEquals("testName1", petJdbc.getPetById(testPetId).getName());
    }
}
