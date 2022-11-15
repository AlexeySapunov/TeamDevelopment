package ru.gb.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.gb.database.model.Like;
import ru.gb.database.model.Publication;
import ru.gb.database.repo.LikeRepository;

import java.util.List;

@Service
public class LikeServerImpl implements LikeService{
    private final LikeRepository likeRepository;

    @Autowired
    public LikeServerImpl(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Override
    public Like findById(Long id) {
        return likeRepository.findById(id).get();
    }

    @Override
    public Like findLikBySenderAndPublicationId(Long senderId, Long publicationRecipientId) {
        return likeRepository.findBySenderAndPublicationRecipient(senderId, publicationRecipientId);
    }

    @Override
    public List<Like> findLikesByPublicationId(Publication publication) {
        return findLikesByPublicationId(publication.getId());
    }

    @Override
    public List<Like> findLikesByPublicationId(Long publicationRecipientId) {
        return likeRepository.findByPublicationRecipient(publicationRecipientId);
    }

    @Override
    @Transactional
    public void saveOrDelete(Like like) {
        Like entity = null;

        if (like.getSender() != null && like.getPublicationRecipient() != null ) {
            Like likeSave = likeRepository.findBySenderAndPublicationRecipient(like.getSender().getId(), like.getPublicationRecipient().getId());

            // Лайк от пользователя публикации уже есть, значит это повторное нажатие, то есть попытка оменить лайк, удаляем лайк
            // Когда такого лайка нет, то это попытка лайкнуть, сохраняем лайк
            if (likeSave != null) {
                likeRepository.delete(likeSave);
            }
            else {
                likeRepository.save(new Like(like.getSender(), like.getUserRecipient(), like.getPublicationRecipient()));
            }
        }
    }
}
