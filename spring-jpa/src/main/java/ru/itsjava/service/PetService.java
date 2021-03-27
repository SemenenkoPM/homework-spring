package ru.itsjava.service;

import ru.itsjava.domain.Email;
import ru.itsjava.domain.Pet;

public interface PetService {
    Pet createPet(Pet pet);

    void updatePetUserById(long id, String name, String whatPet);
}
