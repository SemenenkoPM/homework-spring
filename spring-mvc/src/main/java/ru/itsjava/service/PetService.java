package ru.itsjava.service;

import ru.itsjava.domain.Pet;

import java.util.List;

public interface PetService {
    Pet createPet(Pet pet);

    List<Pet> getPetByUserId(long userId);

    void deletePetById(long id);
}
