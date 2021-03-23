package ru.itsjava.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
// почему такие конструкторы, не файнал поля

public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "email_id", nullable = false)
    private long id;

    private String email;

    @OneToOne(fetch = FetchType.EAGER) // при ленивой загрузке падает почему
    @MapsId
    User user;


}
