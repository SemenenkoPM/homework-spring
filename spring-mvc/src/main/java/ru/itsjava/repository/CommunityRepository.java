package ru.itsjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itsjava.domain.Community;

public interface CommunityRepository extends JpaRepository<Community, Long> {
}
