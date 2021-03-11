package ru.itsjava.dao;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.Pet;

@Repository
@RequiredArgsConstructor
@Data
public class PetJdbcImpl implements PetJdbc{
    private final JdbcOperations jdbcOperations;
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;
    private long petId;
    private KeyHolder keyHolderPetId = new GeneratedKeyHolder();

    // jdbcOperations
//    @Override
//    public void createPet(Pet pet) {
//        jdbcOperations.update("insert into pet(what_pet, name) values (?,?)", pet.getWhatPet(), pet.getName());
//        petId = jdbcOperations.queryForObject("select max(id) from pet", Long.class);
//    }


    @Override
    public void createPet(Pet pet) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("what_pet", pet.getWhatPet());
        parameterSource.addValue("name", pet.getName());
        namedParameterJdbcOperations.update("insert into pet (what_pet, name) values (:what_pet, :name)", parameterSource, keyHolderPetId);
        System.out.println("keyHolderPetId: " + keyHolderPetId.getKey());
    }
}
