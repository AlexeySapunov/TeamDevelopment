package ru.gb.database.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.database.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
