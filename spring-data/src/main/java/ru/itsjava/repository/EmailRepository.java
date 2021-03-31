package ru.itsjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itsjava.domain.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {

}
