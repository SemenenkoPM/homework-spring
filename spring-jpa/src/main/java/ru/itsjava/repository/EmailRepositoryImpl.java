package ru.itsjava.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.Email;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Transactional
@Repository
public class EmailRepositoryImpl implements EmailRepository{
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
}