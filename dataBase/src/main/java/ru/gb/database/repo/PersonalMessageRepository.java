package ru.gb.database.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.database.model.PersonalMessage;

public interface PersonalMessageRepository extends JpaRepository<PersonalMessage, Long> {
}
