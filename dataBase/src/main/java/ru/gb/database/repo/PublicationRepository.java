package ru.gb.database.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.gb.database.model.Publication;
import ru.gb.database.model.Rating;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PublicationRepository extends JpaRepository<Publication, Long>, JpaSpecificationExecutor<Publication> {

    Optional<Publication> findPublicationByPublicationDate(LocalDateTime publicationDate);

    Optional<Publication> findPublicationByRating(Rating rating);
}
