package ru.gb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.model.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
