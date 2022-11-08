package ru.gb.database.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.database.model.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
