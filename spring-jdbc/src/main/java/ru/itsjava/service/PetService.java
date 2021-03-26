package ru.itsjava.service;

import ru.itsjava.domain.Pet;

public interface PetService {

    Pet createPet(String name, String whatPet);

    void updatePetUserById(long id, String name, String whatPet);
}
