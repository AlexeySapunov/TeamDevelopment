package ru.gb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.model.Picture;

public interface PictureRepository extends JpaRepository<Picture, Long> {
}
