package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.domain.Pet;
import ru.itsjava.repository.PetRepository;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService{
private final PetRepository petRepository;

    @Override
    public Pet createPet(Pet pet) {
        return petRepository.savePet(pet);
    }
}
