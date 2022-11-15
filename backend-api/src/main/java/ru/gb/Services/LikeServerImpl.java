package ru.gb.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.gb.database.model.Like;
import ru.gb.database.model.Publication;
import ru.gb.database.model.User;
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
    public Like findLikBySenderIdAndPublicationId(Long senderId, Long publicationRecipientId) {
        return likeRepository.findBySenderIdAndPublicationRecipientId(senderId, publicationRecipientId);
    }

    @Override
    public List<Like> findLikesByPublication(Publication publication) {
        return findLikesByPublicationId(publication.getId());
    }

    @Override
    public List<Like> findLikesByPublicationId(Long publicationRecipientId) {
        return likeRepository.findByPublicationRecipientId(publicationRecipientId);
    }

    @Override
    @Transactional
    public void saveOrDelete(Like like) {
        Like entity = null;

        if (like.getSender() != null && like.getPublicationRecipient() != null ) {
            Like likeSave = likeRepository.findBySenderIdAndPublicationRecipientId(like.getSender().getId(), like.getPublicationRecipient().getId());

            // Лайк от пользователя у публикации уже есть, значит это повторное нажатие, то есть попытка отменить лайк, удаляем лайк
            // Когда такого лайка нет, то это попытка лайкнуть, сохраняем лайк
            if (likeSave != null) {
                likeRepository.delete(likeSave);
            }
            else {
                likeRepository.save(new Like(like.getSender(), like.getUserRecipient(), like.getPublicationRecipient()));
            }
        }
    }

    @Override
    public List<Like> findBySender(User sender) {
        return findBySenderId(sender.getId());
    }

    @Override
    public List<Like> findBySenderId(Long id) {
        return likeRepository.findBySenderId(id);
    }

    @Override
    public List<Like> findByUserRecipient(User userRecipient) {
        return findByUserRecipientId(userRecipient.getId());
    }

    @Override
    public List<Like> findByUserRecipientId(Long id) {
        return likeRepository.findByUserRecipientId(id);
    }
}
