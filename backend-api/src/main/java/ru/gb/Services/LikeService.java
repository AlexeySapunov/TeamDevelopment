package ru.gb.Services;

import ru.gb.database.model.Like;
import ru.gb.database.model.Publication;
import ru.gb.database.model.User;

import java.util.List;

public interface LikeService {
    Like findById(Long id);

    Like findLikBySenderIdAndPublicationId(Long senderId, Long publicationRecipientId);

    List<Like> findLikesByPublication(Publication publication);

    List<Like> findLikesByPublicationId(Long publicationRecipientId);

    void saveOrDelete(Like like);

    List<Like> findBySender(User sender);
    List<Like> findBySenderId(Long id);

    List<Like> findByUserRecipient(User userRecipient);
    List<Like> findByUserRecipientId(Long id);
}