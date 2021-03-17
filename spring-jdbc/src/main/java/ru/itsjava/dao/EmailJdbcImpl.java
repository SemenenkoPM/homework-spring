package ru.itsjava.dao;

import lombok.Data;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.Email;

@Repository
@Data
public class EmailJdbcImpl implements EmailJdbc {
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

//
    @Override
    public void createEmail(Email email) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("email", email.getEmail());
        parameterSource.addValue("userId", email.getUserId());
        namedParameterJdbcOperations.update("insert into email(email, users_id) values(:email, :userId)", parameterSource);

//        jdbcOperations.update("insert into email(email) values (?)", email.getEmail());
//        emailId = jdbcOperations.queryForObject("select max(id) from email", Long.class);
    }

    @Override
    public void updateEmailUserById(long id, String newEmail) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        parameterSource.addValue("newEmail", newEmail);
        namedParameterJdbcOperations.update("update email set email = :newEmail where users_id = :id", parameterSource);
    }
}