package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.Pet;
import ru.itsjava.repository.PetRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;

    @Override
    @Transactional
    public Pet createPet(Pet pet) {
        return petRepository.savePet(pet);
    }

    @Transactional(readOnly = true)
    public List<Pet> getPetByUserId(long userId) {
        return petRepository.getPetByUserId(userId);
    }

    @Override
    @Transactional
    public void deletePetById(long id) {
        petRepository.deletePetById(petRepository.getPetById(id));
    }
}
