package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.dao.PetJdbc;
import ru.itsjava.domain.Pet;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {
    private final PetJdbc petJdbc;

    @Override
    public Pet createPet(String name, String whatPet) {
        long receivedIdFromBD = petJdbc.createPet(name, whatPet);
        return new Pet(receivedIdFromBD, name, whatPet);
    }

    @Override
    public Pet getPetById(long id) {
        return petJdbc.getPetById(id);
    }

    @Override
    public void updatePetUserById(long id, String name, String whatPet) {
        petJdbc.updatePetUserById(id, name, whatPet);
    }

    @Override
    public void deletePetById(long id) {
        petJdbc.deletePetById(id);
    }
}
