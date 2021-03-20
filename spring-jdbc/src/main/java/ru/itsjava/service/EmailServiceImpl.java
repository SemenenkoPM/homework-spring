package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.dao.EmailJdbc;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final EmailJdbc emailJdbc;

    @Override
    public void updateEmailUserById(long id, String newEmail) {
        emailJdbc.updateEmailUserById(id, newEmail);
    }
}
