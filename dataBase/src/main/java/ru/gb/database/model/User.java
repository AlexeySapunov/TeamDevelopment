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

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "roles_id"),
            inverseJoinColumns = @JoinColumn(name = "NULL", referencedColumnName = "NULL"))
    private Set<Role> roles;

    @Column
    private short age;

    @Column
    private String shortDescription;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_messages",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "messages_id"))
    private List<Message> messages;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
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

    public User(Long id, String username, String password, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
}
