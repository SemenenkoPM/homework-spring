package ru.itsjava.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Pet {
    @Id
    private long id;

    private String name;
    @Column(name = "what_pet")
    private String whatPet;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

//    @Column(name = "user_id")
//    private long userId;

}
