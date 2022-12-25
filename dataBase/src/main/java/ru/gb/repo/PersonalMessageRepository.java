package ru.gb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.model.PersonalMessage;

public interface PersonalMessageRepository extends JpaRepository<PersonalMessage, Long> {
}
