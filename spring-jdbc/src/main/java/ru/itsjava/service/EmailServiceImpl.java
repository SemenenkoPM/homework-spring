package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.dao.EmailJdbc;
import ru.itsjava.domain.Email;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final EmailJdbc emailJdbc;

    @Override
    public Email createEmail(String email) {
        long receivedIdFromBD = emailJdbc.createEmail(email);
        return new Email(receivedIdFromBD, email);
    }

    @Override
    public Email getEmailById(long id) {
        return emailJdbc.getEmailById(id);
    }

    @Override
    public void updateEmailUserById(long id, String newEmail) {
        emailJdbc.updateEmailUserById(id, newEmail);
    }

    @Override
    public void deleteEmailById(long id) {
        emailJdbc.deleteEmailById(id);
    }
}
