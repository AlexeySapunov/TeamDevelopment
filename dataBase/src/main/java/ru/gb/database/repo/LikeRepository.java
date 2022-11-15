package ru.gb.database.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.database.model.Like;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByPublicationRecipientId(Long publicationRecipientId);

    Like findBySenderIdAndPublicationRecipientId(Long senderId, Long publicationRecipientId);

    List<Like> findBySenderId(Long id);

    List<Like> findByUserRecipientId(Long id);
}
