package ru.gb.Services;

import ru.gb.database.model.Like;
import ru.gb.database.model.Publication;
import ru.gb.database.model.User;

import java.util.List;

public interface LikeService {
    Like findById(Long id);

    Like findLikBySenderAndPublicationId(Long senderId, Long publicationRecipientId);

    List<Like> findLikesByPublicationId(Publication publication);

    List<Like> findLikesByPublicationId(Long publicationRecipientId);

    void saveOrDelete(Like like);

    List<Like> findBySender(User sender);
    List<Like> findBySender(Long id);

    List<Like> findByUserRecipient(User userRecipient);
    List<Like> findByUserRecipient(Long id);
}