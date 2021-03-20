package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.dao.PetJdbc;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {
    private final PetJdbc petJdbc;

    @Override
    public void updatePetUserById(long id, String name, String whatPet) {
        petJdbc.updatePetUserById(id, name, whatPet);
    }
}
