package ru.gb.database.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.database.model.Commentary;

public interface CommentaryRepository extends JpaRepository<Commentary, Long> {
}
