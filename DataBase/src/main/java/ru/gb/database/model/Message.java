package ru.gb.database.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Publication> publications;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Commentary> commentaries;

    @OneToMany(fetch = FetchType.EAGER)
    private List<PersonalMessage> personalMessages;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Notification> notifications;

    public Message() {
    }
}