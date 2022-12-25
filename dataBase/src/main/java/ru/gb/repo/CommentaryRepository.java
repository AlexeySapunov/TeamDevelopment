package ru.gb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.model.Commentary;

public interface CommentaryRepository extends JpaRepository<Commentary, Long> {
}
