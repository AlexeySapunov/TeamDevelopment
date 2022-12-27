package ru.gb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.gb.controller.NotFoundException;
import ru.gb.dto.BackendPublicationDto;
import ru.gb.model.Picture;
import ru.gb.model.Publication;
import ru.gb.repo.PublicationRepository;
import ru.gb.repo.PublicationSpecification;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BackendPublicationServiceImpl implements BackendPublicationService {

    private final PublicationRepository publicationRepository;
    private final PictureService pictureService;

    @Autowired
    public BackendPublicationServiceImpl(PublicationRepository publicationRepository, PictureService pictureService) {
        this.publicationRepository = publicationRepository;
        this.pictureService = pictureService;
    }

    @Override
    public Page<BackendPublicationDto> findAll(Optional<String> authorName, Optional<String> menuItem,
                                               Optional<String> titleFilter, Integer page, Integer size, String sort) {
        Specification<Publication> spec = Specification.where(null);

        if (titleFilter.isPresent() && !titleFilter.get().isBlank()) {
            spec = spec.and(PublicationSpecification.titleLike(titleFilter.get()));
        }

        if (authorName.isPresent() && !authorName.get().isBlank()) {
            spec = spec.and(PublicationSpecification.titleLike(authorName.get()));
        }

        if (menuItem.isPresent() && !menuItem.get().isBlank()) {
            spec = spec.and(PublicationSpecification.titleLike(menuItem.get()));
        }

        return publicationRepository.findAll(spec, PageRequest.of(page, size, Sort.by(sort)))
                .map(BackendPublicationServiceImpl::convertToDto);
    }

    @Override
    public Optional<BackendPublicationDto> findById(Long id) {
        return publicationRepository.findById(id)
                .map(BackendPublicationServiceImpl::convertToDto);
    }

    @Override
    public void save(BackendPublicationDto publicationDto) {
        Publication publication = (publicationDto.getId() != null) ? publicationRepository.findById(publicationDto.getId())
                .orElseThrow(() -> new NotFoundException("")) : new Publication();

        publication.setTitle(publicationDto.getTitle());
        publication.setTextMessage(publicationDto.getTextMessage());

        if (publicationDto.getNewPicture() != null) {
            for (MultipartFile newPicture: publicationDto.getNewPicture()) {
                try {
                    publication.getPictures().add(new Picture(null,
                            newPicture.getOriginalFilename(),
                            newPicture.getContentType(),
                            pictureService.createPicture(newPicture.getBytes()),
                            publication));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

        publicationRepository.save(publication);
    }

    private static BackendPublicationDto convertToDto(Publication publication) {
        return new BackendPublicationDto(
                publication.getId(),
                publication.getTitle(),
                publication.getTextMessage(),
                publication.getPictures()
                        .stream().map(Picture::getId)
                        .collect(Collectors.toList()),
                publication.getItem());
    }
}
