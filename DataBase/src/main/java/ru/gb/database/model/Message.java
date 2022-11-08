package ru.gb.database.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "message_publication",
            joinColumns = @JoinColumn(name = "message_id", referencedColumnName = "publication_id"))
    private List<Publication> publications;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Commentary> commentaries;

    @OneToMany(fetch = FetchType.EAGER)
    private List<PersonalMessage> personalMessages;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Notification> notifications;

    public Message() {
    }

    public Message(Long id, List<Publication> publications) {
        this.id = id;
        this.publications = publications;
    }
}