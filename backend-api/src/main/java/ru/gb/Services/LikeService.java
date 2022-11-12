package ru.gb.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.database.model.Like;
import ru.gb.database.repo.LikeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;

    public Like findById(Long id) {
        return likeRepository.findById(id).get();
    }

    public Like findLikBySenderAndPublicationId(Long senderId, Long publicationRecipientId) {
        return likeRepository.findBySenderAndPublicationRecipient(senderId, publicationRecipientId);
    }

    public List<Like> findLikesByPublicationId(Long publicationRecipientId) {
        return likeRepository.findByPublicationRecipient(publicationRecipientId);
    }

    public void saveOrDelete(Like like) {
        Like entity = null;

        if (like.getSender() != null && like.getPublicationRecipient() != null ) {
            Like likeSave = likeRepository.findBySenderAndPublicationRecipient(like.getSender().getId(), like.getPublicationRecipient().getId());

            if (likeSave != null) {
                likeRepository.delete(likeSave);
            }
            else {
                likeRepository.save(new Like(like.getSender(), like.getUserRecipient(), like.getPublicationRecipient()));
            }
        }
    }
}