package ru.itsjava.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.User;

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
}
