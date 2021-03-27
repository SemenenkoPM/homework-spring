package ru.itsjava.repository;

import ru.itsjava.domain.Email;
import ru.itsjava.domain.Pet;

public interface PetRepository {
    Pet savePet(Pet pet);

    void updatePetUserById(Pet pet);
}
