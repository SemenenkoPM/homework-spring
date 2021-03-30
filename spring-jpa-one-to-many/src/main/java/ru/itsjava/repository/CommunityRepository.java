package ru.itsjava.repository;

import ru.itsjava.domain.Community;

public interface CommunityRepository {

    Community saveCommunity(Community community);

    Community getCommunityById(long id);
}
