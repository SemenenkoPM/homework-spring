package ru.itsjava.repository;

import org.springframework.stereotype.Repository;
import ru.itsjava.domain.Pet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PetRepositoryImpl implements PetRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Pet savePet(Pet pet) {
        if (pet.getId() == 0L) {
            entityManager.persist(pet);
            return pet;
        }
        return entityManager.merge(pet);
    }

    @Override
    public void updatePetUserById(Pet pet) {
        entityManager.merge(pet);
    }
}
