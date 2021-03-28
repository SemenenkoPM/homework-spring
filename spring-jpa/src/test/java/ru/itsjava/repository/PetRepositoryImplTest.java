package ru.itsjava.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.Pet;

@DataJpaTest
@Import(PetRepositoryImpl.class)
@DisplayName("Класс PetRepositoryImpl должен: ")
public class PetRepositoryImplTest {
    @Autowired
    private PetRepository petRepository;

    @DisplayName(" сохранять pet")
    @Test
    public void shouldHaveCorrectSavePet(){
        Pet testPet = new Pet(0L, "testPetName3", "testPet3");
        Pet receivedPetFromDB = petRepository.savePet(testPet);
        testPet.setId(receivedPetFromDB.getId());
        Assertions.assertEquals(testPet, receivedPetFromDB);
    }
}
