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
    @Transactional(readOnly = true)
    public Email getEmailById(long id) {
        return emailRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Email createEmail(Email email) {
        return emailRepository.save(email);
    }

    @Override
    @Transactional
    public void updateEmailById(long id, String newEmail) {
        Email email = emailRepository.findById(id).get();
        email.setEmail(newEmail);
        emailRepository.save(email);
    }
}
