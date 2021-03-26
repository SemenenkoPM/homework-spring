package ru.itsjava.dao;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.Pet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

@Repository
@RequiredArgsConstructor
@Data
public class PetJdbcImpl implements PetJdbc {
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

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
    public Pet getPetById(long id) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        return namedParameterJdbcOperations.queryForObject("select id, name, what_pet from pet where id =:id",
                params, new PetMapper());
    }

    @Override
    public void updatePetUserById(long id, String name, String whatPet) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        parameterSource.addValue("name", name);
        parameterSource.addValue("whatPet", whatPet);
        namedParameterJdbcOperations.update("update pet set name = :name, what_pet = :whatPet where id = :id", parameterSource);
    }

    @Override
    public void deletePetById(long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        namedParameterJdbcOperations.update("delete from pet where id = :id", parameterSource);
    }

    private static class PetMapper implements RowMapper<Pet> {

        @Override
        public Pet mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Pet(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getString("what_pet"));
        }
    }
}
