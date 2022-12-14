package ru.gb.database.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "user_recipient_id")
    private User userRecipient;

    @ManyToOne
    @JoinColumn(name = "publication_recipient_id")
    private Publication publicationRecipient;

    public Like() {
    }
}