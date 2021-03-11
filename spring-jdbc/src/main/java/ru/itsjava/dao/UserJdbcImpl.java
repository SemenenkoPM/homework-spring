package ru.itsjava.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcOperations;
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

@Repository
@RequiredArgsConstructor
public class UserJdbcImpl implements UserJdbc{
    private final JdbcOperations jdbcOperations;
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;
    private final PetJdbcImpl petJdbc;
    private final EmailJdbcImpl emailJdbc;


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
    public void createUser(User user) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("surname", user.getSurname());
        parameterSource.addValue("name", user.getName());
        KeyHolder keyHolderUserId = new GeneratedKeyHolder();
        namedParameterJdbcOperations.update("insert into users(surname, name) values (:surname, :name)", parameterSource, keyHolderUserId);
        System.out.println("keyHolderUserId.getKey(): " + keyHolderUserId.getKey());
        System.out.println("keyHolderUserId from pet: " + petJdbc.getKeyHolderPetId().getKey());
    }


    @Override
    public void printAllUsers() {

    }

    @Override
    public User getUserById(long id) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        return namedParameterJdbcOperations.queryForObject("select id, surname, name from users where id =:id",
                params, new UserMapper());
    }

    private static class UserMapper implements RowMapper<User>{

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            return new User(resultSet.getLong("id"), resultSet.getString("surname"), resultSet.getString("name"));
        }
    }
}
