package ru.itsjava.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {
    public User() {

    }

    public User(String surname, String name, Email email, List<Pet> pets, Community community) {
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.pets = pets;
        this.community = community;
    }

    public User(long id, String surname, String name, Email email, Community community) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.community = community;
    }

    public User(long id, String surname, String name, Email email) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "email_id", nullable = false)
    private Email email;

    @OneToMany(targetEntity = Pet.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Pet> pets;

    @ManyToOne(targetEntity = Community.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "community_id")
    private Community community;
}
