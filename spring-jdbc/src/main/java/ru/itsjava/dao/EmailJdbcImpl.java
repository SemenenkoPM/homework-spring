package ru.itsjava.dao;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.Email;
@Repository
@RequiredArgsConstructor
@Data
public class EmailJdbcImpl implements EmailJdbc{
    private final JdbcOperations jdbcOperations;
    private long emailId;

    @Override
    public void createEmail(Email email) {
        jdbcOperations.update("insert into email(email) values (?)", email.getEmail());
        emailId = jdbcOperations.queryForObject("select max(id) from email", Long.class);
    }
}
