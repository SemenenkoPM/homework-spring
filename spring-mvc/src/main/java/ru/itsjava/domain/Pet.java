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
    public Pet(long id, String name, String whatPet) {
        this.id = id;
        this.name = name;
        this.whatPet = whatPet;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    @Column(name = "what_pet")
    private String whatPet;

    @Column(name = "user_id")
    private long userId;
}
