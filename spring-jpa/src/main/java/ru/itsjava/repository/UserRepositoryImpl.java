package ru.itsjava.repository;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Transactional
@Repository
public class UserRepositoryImpl implements UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User saveUser(User user) {
        if (user.getId() == 0L) {
            entityManager.persist(user);
            return user;
        }
        return entityManager.merge(user);
    }

    @Override
    public boolean checkingIfUserExistsWithThisId(long id) {
        Optional<User> user = Optional.ofNullable(entityManager.find(User.class, id));
        if(user.isPresent()){
            return true;
        }
        return false;
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

}
