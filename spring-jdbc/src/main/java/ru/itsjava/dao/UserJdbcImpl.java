package ru.itsjava.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.User;

@Repository
@RequiredArgsConstructor
public class UserJdbcImpl implements UserJdbc{
    private final JdbcOperations jdbcOperations;

    @Override
    public void createUser(User user) {
    jdbcOperations.update("insert into pet(what_pet, name) values (?,?)", user.getPet().getWhatPet(), user.getPet().getName());
    long petId = jdbcOperations.queryForObject("select max(id) from pet", Long.class);
    jdbcOperations.update("insert into email(email) values (?)", user.getEmail().getEmail());
    long emailId = jdbcOperations.queryForObject("select max(id) from email", Long.class);
    jdbcOperations.update("insert into users(surname, name, email_id, pet_id) values (?, ?, ?, ?)", user.getSurname(), user.getName(), emailId, petId);
    }
}
