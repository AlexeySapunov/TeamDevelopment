package ru.gb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Setter
@Getter
@Entity
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    @OneToMany
    private List<Like> countLikes;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User userRecipient;

    @OneToOne
    @JoinColumn(name = "publication_id")
    private Publication publicationRecipient;

    public Rating() {
    }
}