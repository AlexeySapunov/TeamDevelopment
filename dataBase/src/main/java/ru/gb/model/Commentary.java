package ru.gb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "commentaries")
public class Commentary {

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
    private User author;

    @Column
    private LocalDateTime commentaryDate;

    public Commentary() {
    }

    public Commentary(Long id, String title, String textMessage) {
        this.id = id;
        this.title = title;
        this.textMessage = textMessage;
    }
}