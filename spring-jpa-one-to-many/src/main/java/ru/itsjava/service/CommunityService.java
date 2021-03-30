package ru.itsjava.service;

import ru.itsjava.domain.Community;

public interface CommunityService {

    Community createCommunity(String name);

    Community getCommunityById(long id);
}
