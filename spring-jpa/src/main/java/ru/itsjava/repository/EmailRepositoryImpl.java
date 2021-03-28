package ru.itsjava.repository;

import org.springframework.stereotype.Repository;
import ru.itsjava.domain.Email;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class EmailRepositoryImpl implements EmailRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Email saveEmail(Email email) {
        if (email.getId() == 0L) {
            entityManager.persist(email);
            return email;
        }
        return entityManager.merge(email);
    }

    @Override
    public void updateEmailUserById(Email email) {
        entityManager.merge(email);
    }
}
