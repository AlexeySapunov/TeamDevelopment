package ru.gb.database.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.database.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
