package ru.itsjava.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.dao.PetJdbcImpl;
import ru.itsjava.domain.Pet;

@JdbcTest
@Import({PetServiceImpl.class, PetJdbcImpl.class})
@DisplayName("Класс PetServiceImpl должен: ")
public class PetServiceImplTest {
    @Autowired
    private PetService petService;

    private final Pet testPet = new Pet(2L, "TestName", "TestPet");

    @DisplayName("Корректно создавать Pet")
    @Test
    public void shouldHaveCorrectCreatePet() {
        Pet petFromDB = petService.createPet("TestName", "TestPet");
        testPet.setId(petFromDB.getId());
        Assertions.assertEquals(testPet, petFromDB);
    }

    @DisplayName("Корректно возвращать Pet по id")
    @Test
    public void shouldHaveCorrectGetPetById() {
        Pet petFromDB = petService.createPet("TestName", "TestPet");
        testPet.setId(petFromDB.getId());
        Assertions.assertEquals(testPet, petService.getPetById(testPet.getId()));
    }

    @DisplayName("Корректно обновлять Pet по id")
    @Test
    public void shouldHaveCorrectUpdatePetById() {
        Pet petFromDB = petService.createPet("TestName", "TestPet");
        long id = petFromDB.getId();
        petService.updatePetUserById(id, "TestName1", "TestPet1");
        Assertions.assertEquals("TestName1", petService.getPetById(id).getName());
    }
}
