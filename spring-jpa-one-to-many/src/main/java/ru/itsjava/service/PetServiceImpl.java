package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.Pet;
import ru.itsjava.repository.PetRepository;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;

    @Override
    @Transactional
    public Pet createPet(Pet pet) {
        return petRepository.savePet(pet);
    }

//    @Override
//    @Transactional
//    public void updatePetUserById(long id, String name, String whatPet) {
//        petRepository.updatePetUserById(new Pet(id, name, whatPet));
//    }
}
