package ru.gb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private NotificationStatus status;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User recipient;

    @Column
    private LocalDateTime dateGetStatus;

    public Notification() {
    }

    public Notification(Long id, NotificationStatus status, User recipient) {
        this.id = id;
        this.status = status;
        this.recipient = recipient;
    }

    private enum NotificationStatus {
        Blocked, Unblocked, Warn, Info
    }
}