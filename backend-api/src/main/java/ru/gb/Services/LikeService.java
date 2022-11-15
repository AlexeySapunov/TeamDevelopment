package ru.gb.Services;

import ru.gb.database.model.Like;
import ru.gb.database.model.Publication;

import java.util.List;

public interface LikeService {
    Like findById(Long id);

    Like findLikBySenderAndPublicationId(Long senderId, Long publicationRecipientId);

    List<Like> findLikesByPublicationId(Publication publication);

    List<Like> findLikesByPublicationId(Long publicationRecipientId);

    void saveOrDelete(Like like);
}