package ru.itsjava.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.Pet;
import ru.itsjava.repository.PetRepositoryImpl;

@DataJpaTest
@Import({PetServiceImpl.class, PetRepositoryImpl.class})
@DisplayName("Класс PetServiceImpl должен: ")
public class PetServiceImplTest {
    @Autowired
    private PetService petService;

    @DisplayName(" создавать pet")
    @Test
    public void shouldHaveCorrectCreatePet(){
        Pet testPet = new Pet(0L, "testPetName3", "testPet3");
        Pet receivedPetFromDB = petService.createPet(testPet);
        testPet.setId(receivedPetFromDB.getId());
        Assertions.assertEquals(testPet, receivedPetFromDB);
    }
}
