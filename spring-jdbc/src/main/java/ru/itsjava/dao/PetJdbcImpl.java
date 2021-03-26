package ru.itsjava.dao;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
    public long createPet(String name, String whatPet) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        KeyHolder keyHolderPetId = new GeneratedKeyHolder();
        parameterSource.addValue("name", name);
        parameterSource.addValue("whatPet", whatPet);
        namedParameterJdbcOperations.update("insert into pet (name, what_pet) values (:name, :whatPet)", parameterSource, keyHolderPetId);
        return (long) keyHolderPetId.getKey();
    }

    @Override
    public void updatePetUserById(long id, String name, String whatPet) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        parameterSource.addValue("name", name);
        parameterSource.addValue("whatPet", whatPet);
        namedParameterJdbcOperations.update("update pet set name = :name, what_pet = :whatPet where users_id = :id", parameterSource);
    }
}
