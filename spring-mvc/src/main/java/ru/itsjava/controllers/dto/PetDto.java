//package ru.itsjava.controllers.dto;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import ru.itsjava.domain.Community;
//import ru.itsjava.domain.Email;
//import ru.itsjava.domain.Pet;
//import ru.itsjava.domain.User;
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class PetDto {
//        private long id;
//        private String name;
//        private String whatPet;
//        private long userId;
//
//        public static Pet toDomainObject(PetDto petDtoDto) {
//            return new Pet(userDto.id, userDto.surname, userDto.name);
//        }
//
//        public static ru.itsjava.controllers.dto.UserDto toDto(User user) {
//            return new ru.itsjava.controllers.dto.UserDto(user.getId(), user.getSurname(), user.getName(),
//                    user.getEmail().getEmail(), user.getCommunity().getName());
//        }
//    }
//
//}
