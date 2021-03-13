package ru.itsjava.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
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

@Repository
@RequiredArgsConstructor
public class UserJdbcImpl implements UserJdbc {
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    KeyHolder keyHolderUserId = new GeneratedKeyHolder();


    // jdbcOperations
//    @Override
//    public void createUser(User user) {
//        HashMap<String, Object> params = new HashMap<>();
//        params.put("surname", user.getSurname());
//        params.put("name", user.getName());
//        jdbcOperations.update("insert into users(surname, name, email_id, pet_id) values (?, ?, ?, ?)", user.getSurname(), user.getName(), emailJdbc.getEmailId() , petJdbc.getPetId());
//    }

    // NamedParameterJdbcOperations
//    @Override
//    public void createUser(User user) {
//        HashMap<String, Object> params = new HashMap<>();
//        params.put("surname", user.getSurname());
//        params.put("name", user.getName());
//        namedParameterJdbcOperations.update("insert into users(surname, name) values (:surname, :name)", params);
//    }

    // KeyHolder
    @Override
    public Long createUser(User user) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("surname", user.getSurname());
        parameterSource.addValue("name", user.getName());
        namedParameterJdbcOperations.update("insert into users(surname, name) values (:surname, :name)", parameterSource, keyHolderUserId);
        System.out.println("keyHolderUserId.getKey(): " + keyHolderUserId.getKey());
        return (Long) keyHolderUserId.getKey();
    }

    @Override
    public List<User> printAllUsers() {
        HashMap<String, Integer> params = new HashMap<>();
        params.put("id", 1);
// как правильно задать params, ведь получается в запросе я беру u.id>0
        return namedParameterJdbcOperations.query("select u.id, u.surname, u.name, e.email, p.what_pet, p.name from users u, email e, pet p where u.id >0 and e.users_id = u.id and p.users_id = u.id", params, new UserMapper());
    }

    @Override
    public User getUserById(long id) throws EmptyResultDataAccessException {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        return namedParameterJdbcOperations.queryForObject("select u.id, u.surname, u.name, e.email, p.what_pet, p.name from users u, email e, pet p where u.id =:id and e.users_id = u.id and p.users_id = u.id",
                params, new UserMapper());
    }

    @Override
    public void deleteUserById(long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        namedParameterJdbcOperations.update("delete from pet where users_id = :id", parameterSource);
        namedParameterJdbcOperations.update("delete from email where users_id = :id", parameterSource);
        namedParameterJdbcOperations.update("delete from users where id = :id", parameterSource);
        // написать один запрос на все таблицы
    }
// сокращения в запросе

    private static class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            return new User(resultSet.getLong("id"), resultSet.getString("surname"), resultSet.getString("name"),
                    new Email(resultSet.getString("email.email")),
                    new Pet(resultSet.getString("what_pet"), resultSet.getString("pet.name")));
            // почему в мапере при совпадении а разных обьектах name, если не указывать pet.name берет имя из user
            // как работает мапер
        }
    }
}
