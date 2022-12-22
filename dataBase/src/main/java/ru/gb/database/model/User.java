package ru.gb.database.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false)
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Column
    private short age;

    @Column
    private String shortDescription;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_publications",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "publication_id"))
    private List<Publication> publications;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Like> likes;

    @ManyToOne
    @JoinColumn(name = "rating_id")
    private Rating rating;

    public User() {
    }

    public User(Long id, String username, String password, String email, short age, String shortDescription) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.shortDescription = shortDescription;
    }

    public User(Long id, String username, String email, String password, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
