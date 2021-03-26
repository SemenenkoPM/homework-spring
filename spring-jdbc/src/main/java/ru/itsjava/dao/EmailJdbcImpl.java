package ru.itsjava.dao;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.Email;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

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
    public Email getEmailById(long id) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        return namedParameterJdbcOperations.queryForObject("select id, email, from email where id =:id",
                params, new EmailMapper());
    }

    @Override
    public void updateEmailUserById(long id, String newEmail) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        parameterSource.addValue("newEmail", newEmail);
        namedParameterJdbcOperations.update("update email set email = :newEmail where id = :id", parameterSource);
    }

    @Override
    public void deleteEmailById(long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        namedParameterJdbcOperations.update("delete from email where id = :id", parameterSource);
    }

    private static class EmailMapper implements RowMapper<Email> {

        @Override
        public Email mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Email(resultSet.getLong("id"), resultSet.getString("email"));
        }
    }
}