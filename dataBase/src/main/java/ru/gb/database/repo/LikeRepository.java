package ru.gb.database.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.database.model.Like;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByPublicationRecipient(Long publicationRecipientId);

    Like findBySenderAndPublicationRecipient(Long senderId, Long publicationRecipientId);
}
