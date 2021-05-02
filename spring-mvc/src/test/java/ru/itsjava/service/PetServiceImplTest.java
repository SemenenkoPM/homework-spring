package ru.itsjava.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.Pet;

import java.util.List;

@DataJpaTest
@Import({PetServiceImpl.class})
@DisplayName("Класс PetServiceImpl должен корректно: ")
public class PetServiceImplTest {
    @Autowired
    private PetService petService;

    private Pet pet = new Pet(0L, "testName", "testWhatPet", 1L);

    @DisplayName("создавать pet")
    @Test
    public void shouldHaveCorrectCreatePet(){
        Pet savedPetDb = petService.createPet(pet);
        pet.setId(savedPetDb.getId());
        Assertions.assertEquals(pet, savedPetDb);
    }

    @DisplayName("получать pet по id")
    @Test
    public void shouldHaveCorrectGetPetById() {
        Pet savedPetDb = petService.createPet(pet);
        Assertions.assertEquals(savedPetDb, petService.getPetById(savedPetDb.getId()));
    }

    @DisplayName("получать pet по userId")
    @Test
    public void shouldHaveCorrectGetPetsByUserId(){
        Pet pet = petService.getPetById(1L);
        List<Pet> petList = List.of(pet);
        Assertions.assertEquals(petList, petService.getPetByUserId(pet.getUserId()));
    }
}
