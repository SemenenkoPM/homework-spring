package ru.itsjava.repository;

import org.springframework.stereotype.Repository;
import ru.itsjava.domain.Community;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CommunityRepositoryImpl implements CommunityRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Community saveCommunity(Community community) {
        if (community.getId() == 0) {
            entityManager.persist(community);
            return community;
        }
        return entityManager.merge(community);
    }

    @Override
    public Community getCommunityById(long id) {
        return entityManager.find(Community.class, id);
    }
}
