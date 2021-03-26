package ru.itsjava.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserJdbcImpl implements UserJdbc {
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    @Override
    public long createUser(String surname, String name, long emailId, long petId) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("surname", surname);
        parameterSource.addValue("name", name);
        parameterSource.addValue("email_id", emailId);
        parameterSource.addValue("pet_id", petId);
        KeyHolder keyHolderUserId = new GeneratedKeyHolder();
        namedParameterJdbcOperations.update("insert into users(surname, name, email_id, pet_id) values (:surname, :name, :email_id, :pet_id)", parameterSource, keyHolderUserId);
        return (long) keyHolderUserId.getKey();
    }

    @Override
    public List<User> getAllUsers() {
        return namedParameterJdbcOperations.query("select id, surname, name, email_id, pet_id from users", new UserMapper());
    }

    @Override
    public Optional<User> getUserById(long id) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        try {
            return Optional.ofNullable(namedParameterJdbcOperations.queryForObject("select id, surname, name, email_id, pet_id from users where id =:id",
                    params, new UserMapper()));
        } catch (EmptyResultDataAccessException exception) {
            return Optional.empty();
        }
    }

    @Override
    public void deleteUserById(long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        namedParameterJdbcOperations.update("delete from users where id = :id", parameterSource);
    }

    private static class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            return new User(resultSet.getLong("id"), resultSet.getString("surname"), resultSet.getString("name"), resultSet.getLong("email_id"), resultSet.getLong("pet_id"));
        }
    }
}
