package ru.itsjava.dao;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.Email;

@Repository
@RequiredArgsConstructor
@Data
public class EmailJdbcImpl implements EmailJdbc {
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    @Override
    public long createEmail(String email) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        KeyHolder keyHolderEmailId = new GeneratedKeyHolder();
        parameterSource.addValue("email", email);
        namedParameterJdbcOperations.update("insert into email(email) values(:email)", parameterSource, keyHolderEmailId);
        return (long) keyHolderEmailId.getKey();
    }

    @Override
    public void updateEmailUserById(long id, String newEmail) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        parameterSource.addValue("newEmail", newEmail);
        namedParameterJdbcOperations.update("update email set email = :newEmail where users_id = :id", parameterSource);
    }
}