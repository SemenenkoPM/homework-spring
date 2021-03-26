package ru.itsjava.dao;

import ru.itsjava.domain.Pet;

public interface PetJdbc {
    long createPet(String name, String whatPet);

    void updatePetUserById(long id, String whatPet, String name);
}
