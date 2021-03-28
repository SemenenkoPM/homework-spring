package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.Email;
import ru.itsjava.repository.EmailRepository;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final EmailRepository emailRepository;

    @Override
    @Transactional
    public Email createEmail(Email email) {
        return emailRepository.saveEmail(email);
    }

    @Override
    @Transactional
    public void updateEmailUserById(long id, String newEmail) {
        emailRepository.updateEmailUserById(new Email(id, newEmail));
    }
}
