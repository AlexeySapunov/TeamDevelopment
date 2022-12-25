package ru.gb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
