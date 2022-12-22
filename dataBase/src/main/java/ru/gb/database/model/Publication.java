package ru.gb.database.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "publications")
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String textMessage;

    @OneToMany
    private List<Like> likes;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "publications_media",
            joinColumns = @JoinColumn(name = "publications_id"),
            inverseJoinColumns = @JoinColumn(name = "media_id"))
    private List<Media> media = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "rating_id")
    private Rating rating;

    @OneToMany
    private List<Commentary> commentaries;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MenuItem item;

    @Column
    private LocalDateTime publicationDate;

    public Publication() {
    }

    public Publication(Long id, String title, String textMessage, List<Media> media, MenuItem item) {
        this.id = id;
        this.title = title;
        this.textMessage = textMessage;
        this.media = media;
        this.item = item;
    }

    public enum MenuItem {
        Design, WebDevelopment, MobileDevelopment, Marketing
    }
}