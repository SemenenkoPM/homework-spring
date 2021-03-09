package ru.itsjava.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.Pet;
import ru.itsjava.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@RequiredArgsConstructor
public class UserJdbcImpl implements UserJdbc{
    private final JdbcOperations jdbcOperations;
    private final PetJdbcImpl petJdbc;
    private final EmailJdbcImpl emailJdbc;

    @Override
    public void createUser(User user) {
    jdbcOperations.update("insert into users(surname, name, email_id, pet_id) values (?, ?, ?, ?)", user.getSurname(), user.getName(), emailJdbc.getEmailId() , petJdbc.getPetId());
    } // Как вернуть созданный id?

    @Override
    public void printAllUsers() {

    }

//    private static class UserMapper implements RowMapper<User>{
//
//        @Override
//        public User mapRow(ResultSet resultSet, int i) throws SQLException {
//            return new User(resultSet.getLong("id"), resultSet.getString("surname"), resultSet.getString("name")),
//            new Email(resultSet.getLong("id"), resultSet.getString("email")),
//            new Pet(resultSet.getLong("id"), resultSet.getString("whatPet"), resultSet.getString("name")));
//        }
//    }
}
