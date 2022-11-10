package ru.gb.database.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.database.model.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
