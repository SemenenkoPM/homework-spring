package ru.itsjava.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.Pet;
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

    // jdbcOperations
//    @Override
//    public void createUser(User user) {
//        HashMap<String, Object> params = new HashMap<>();
//        params.put("surname", user.getSurname());
//        params.put("name", user.getName());
//        jdbcOperations.update("insert into users(surname, name, email_id, pet_id) values (?, ?, ?, ?)", user.getSurname(), user.getName(), emailJdbc.getEmailId() , petJdbc.getPetId());
//    }

    @Override
    public long createUser(User user) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("surname", user.getSurname());
        parameterSource.addValue("name", user.getName());
        KeyHolder keyHolderUserId = new GeneratedKeyHolder();
        namedParameterJdbcOperations.update("insert into users(surname, name) values (:surname, :name)", parameterSource, keyHolderUserId);
        return (long) keyHolderUserId.getKey();
    }

    @Override
    public List<User> getAllUsers() {
        return namedParameterJdbcOperations.query("select u.id, u.surname, u.name, e.email, p.what_pet, p.name from users u, email e, pet p where e.users_id = u.id and p.users_id = u.id", new UserMapper());
    }

    @Override
    public Optional<User> getUserById(long id) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        try {
            return Optional.ofNullable(namedParameterJdbcOperations.queryForObject("select u.id, u.surname, u.name, e.email, p.what_pet, p.name from users u, email e, pet p where u.id =:id and e.users_id = u.id and p.users_id = u.id",
                    params, new UserMapper()));
        } catch (DataAccessException ex) {
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
            return new User(resultSet.getLong("id"), resultSet.getString("surname"), resultSet.getString("name"),
                    new Email(resultSet.getString("email.email")),
                    new Pet(resultSet.getString("what_pet"), resultSet.getString("pet.name")));
        }
    }
}
