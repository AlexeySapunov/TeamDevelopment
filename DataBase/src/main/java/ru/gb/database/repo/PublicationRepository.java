package ru.gb.database.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.database.model.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
}
