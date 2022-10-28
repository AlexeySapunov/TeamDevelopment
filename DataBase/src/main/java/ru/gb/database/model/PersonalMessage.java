package ru.gb.database.model;

import javax.persistence.*;

@Entity
@Table(name = "personal_message")
public class PersonalMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}