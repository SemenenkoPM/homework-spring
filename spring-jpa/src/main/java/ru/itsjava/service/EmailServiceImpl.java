package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.domain.Email;
import ru.itsjava.repository.EmailRepository;
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{
private final EmailRepository emailRepository;
    @Override
    public Email createEmail(Email email) {
        return emailRepository.saveEmail(email);
    }

    @Override
    public void updateEmailUserById(long id, String newEmail) {

    }
}
