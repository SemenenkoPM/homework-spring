package ru.itsjava.service;

import ru.itsjava.domain.Community;

import java.util.Optional;

public interface CommunityService {

    Community createCommunity(String name);

    Optional<Community> getCommunityById(long id);
}
