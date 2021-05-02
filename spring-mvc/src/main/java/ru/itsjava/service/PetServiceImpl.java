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
        return petRepository.save(pet);
    }

    @Override
    @Transactional(readOnly = true)
    public Pet getPetById(long id) {
        return petRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<Pet> getPetByUserId(long userId) {
        return petRepository.findByUserId(userId);
    }

    @Override
    @Transactional
    public void deletePetById(long id) {
        petRepository.deleteById(id);
    }
}
