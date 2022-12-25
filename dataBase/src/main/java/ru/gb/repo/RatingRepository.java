package ru.gb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.model.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
