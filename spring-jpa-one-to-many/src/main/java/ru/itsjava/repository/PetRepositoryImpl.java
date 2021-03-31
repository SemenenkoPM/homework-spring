package ru.itsjava.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.Pet;
import ru.itsjava.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

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

    @Override
    public List<Pet> getPetByUserId(long userId) {
        TypedQuery<Pet> query = entityManager.createQuery("select p from Pet p where user_id = :userId", Pet.class);
        query.setParameter("userId", userId);
        List<Pet> result = query.getResultList();
        return result;
    }

    @Override
    public Pet getPetById(long id) {
        return entityManager.find(Pet.class, id);
    }

    @Override
    public void deletePetById(Pet pet) {
        entityManager.remove(pet);
    }
}
