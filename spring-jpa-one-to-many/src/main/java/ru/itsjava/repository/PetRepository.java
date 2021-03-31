package ru.itsjava.repository;

import ru.itsjava.domain.Pet;

import java.util.List;

public interface PetRepository {
    Pet savePet(Pet pet);

    void updatePetUserById(Pet pet);

    List<Pet> getPetByUserId(long userId);

    Pet getPetById(long id);

    void deletePetById(Pet pet);
}
