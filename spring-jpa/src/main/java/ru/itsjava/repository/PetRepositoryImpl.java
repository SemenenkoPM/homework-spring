package ru.itsjava.repository;

import jdk.jfr.Registered;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.Pet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
@Repository
public class PetRepositoryImpl implements PetRepository{
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
}
