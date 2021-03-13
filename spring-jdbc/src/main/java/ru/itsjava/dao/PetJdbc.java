package ru.itsjava.dao;

import ru.itsjava.domain.Pet;

public interface PetJdbc {
    void createPet(Pet pet);

    void updatePetUserById(long id, String whatPet, String name);
}
