package ru.itsjava.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itsjava.domain.Community;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.Pet;
import ru.itsjava.domain.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDto {
    private long id;
    private String petName;
    private String whatPet;
    private long userId;


    public static Pet toDomainObject(PetDto petDto) {
        return new Pet(0L, petDto.petName, petDto.whatPet, 0L);
    }
}

