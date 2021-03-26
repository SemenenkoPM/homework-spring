package ru.itsjava.service;

import ru.itsjava.domain.Pet;

public interface PetService {

    Pet createPet(String name, String whatPet);

    Pet getPetById(long id);

    void updatePetUserById(long id, String name, String whatPet);

    void deletePetById(long id);
}
