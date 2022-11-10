package ru.gb.database.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.database.model.Media;

public interface MediaRepository extends JpaRepository<Media, Long> {
}
