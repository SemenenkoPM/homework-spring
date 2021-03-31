package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.Community;
import ru.itsjava.repository.CommunityRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {
    private final CommunityRepository communityRepository;

    @Override
    @Transactional
    public Community createCommunity(String name) {
        return communityRepository.save(new Community(0L, name));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Community> getCommunityById(long id) {
        return communityRepository.findById(id);
    }
}
