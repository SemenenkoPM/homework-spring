package ru.itsjava.dao;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.Pet;

@Repository
@RequiredArgsConstructor
@Data
public class PetJdbcImpl implements PetJdbc{
    private final JdbcOperations jdbcOperations;
    private long petId;

    @Override
    public void createPet(Pet pet) {
        jdbcOperations.update("insert into pet(what_pet, name) values (?,?)", pet.getWhatPet(), pet.getName());
        petId = jdbcOperations.queryForObject("select max(id) from pet", Long.class);
    }
}
