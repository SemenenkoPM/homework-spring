package ru.itsjava.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.Community;

@DataJpaTest
@Import({CommunityServiceImpl.class})
@DisplayName("Класс CommunityServiceImpl должен корректно: ")
public class CommunityServiceImplTest {
    @Autowired
    private CommunityService communityService;

    private Community community = new Community(0L, "testName");

    @DisplayName("создавать community")
    @Test
    public void shouldHaveCorrectCreateCommunity() {
        Community savedCommunityDb = communityService.createCommunity(community.getName());
        community.setId(savedCommunityDb.getId());
        Assertions.assertEquals(community, savedCommunityDb);
    }

    @DisplayName("корректно получать community по id")
    @Test
    public void shouldHaveCorrectGetCommunityById() {
        Community savedCommunityDb = communityService.createCommunity(community.getName());
        Assertions.assertEquals(savedCommunityDb, communityService.getCommunityById(savedCommunityDb.getId()).get());
    }
}
