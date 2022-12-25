package ru.gb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "personal_messages")
public class PersonalMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String textMessage;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "user_recipient_id")
    private User recipient;

    @Column
    private LocalDateTime personalMessageDate;

    public PersonalMessage() {
    }

    public PersonalMessage(Long id, String title, String textMessage) {
        this.id = id;
        this.title = title;
        this.textMessage = textMessage;
    }
}