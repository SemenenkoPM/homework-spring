package ru.itsjava.dao;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.Pet;

@Repository
@RequiredArgsConstructor
@Data
public class PetJdbcImpl implements PetJdbc {
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    // jdbcOperations
//    @Override
//    public void createPet(Pet pet) {
//        jdbcOperations.update("insert into pet(what_pet, name) values (?,?)", pet.getWhatPet(), pet.getName());
//        petId = jdbcOperations.queryForObject("select max(id) from pet", Long.class);
//    }

    @Override
    public void createPet(Pet pet) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("whatPet", pet.getWhatPet());
        parameterSource.addValue("name", pet.getName());
        parameterSource.addValue("userId", pet.getUserId());
        namedParameterJdbcOperations.update("insert into pet (what_pet, name, users_id) values (:whatPet, :name, :userId)", parameterSource);
    }

    @Override
    public void updatePetUserById(long id, String whatPet, String name) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        parameterSource.addValue("whatPet", whatPet);
        parameterSource.addValue("name", name);
        namedParameterJdbcOperations.update("update pet set what_pet = :whatPet, name = :name where users_id = :id", parameterSource);
    }
}
