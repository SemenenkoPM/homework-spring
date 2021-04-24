package ru.itsjava.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itsjava.domain.Community;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private long id;
    private String surname;
    private String name;
    private String emailName;
    private String communityName;

    public static User toDomainObject(UserDto userDto) {
        return new User(userDto.id, userDto.surname, userDto.name,
                new Email(0L, userDto.emailName), new Community(0L, userDto.communityName));
    }

    public static UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getSurname(), user.getName(),
                user.getEmail().getEmail(), user.getCommunity().getName());
    }
}
