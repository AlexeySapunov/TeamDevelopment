package ru.gb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.gb.controler.NotFoundException;
import ru.gb.controler.dto.PublicationDto;
import ru.gb.database.model.Media;
import ru.gb.database.model.Publication;
import ru.gb.database.repo.PublicationRepository;
import ru.gb.database.repo.PublicationSpecification;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PublicationServiceImpl implements PublicationService {

    private final MediaService mediaService;

    private final PublicationRepository publicationRepository;

    @Autowired
    public PublicationServiceImpl(MediaService mediaService, PublicationRepository publicationRepository) {
        this.mediaService = mediaService;
        this.publicationRepository = publicationRepository;
    }

    @Override
    public Page<PublicationDto> findAll(Optional<String> authorName,
                                        Optional<String> menuItem, Optional<String> titleFilter,
                                        Integer page, Integer size, String sort) {

        Specification<Publication> spec = Specification.where(null);

        if (titleFilter.isPresent() && !titleFilter.get().isBlank()) {
            spec = spec.and(PublicationSpecification.titleLike(titleFilter.get()));
        }

        if (authorName.isPresent() && !authorName.get().isBlank()) {
            spec = spec.and(PublicationSpecification.byAuthorName(authorName.get()));
        }

        if (menuItem.isPresent() && menuItem.get().isBlank()) {
            spec = spec.and(PublicationSpecification.byMenuItem(menuItem.get()));
        }

        return publicationRepository.findAll(spec,
                        PageRequest.of(page, size, Sort.by(sort)))
                .map(PublicationServiceImpl::convertToDto);
    }

    @Override
    public Optional<PublicationDto> findById(Long id) {
        return publicationRepository.findById(id)
                .map(PublicationServiceImpl::convertToDto);
    }

    @Override
    public void save(PublicationDto publicationDto) {
        Publication publication = (publicationDto.getId() != null) ? publicationRepository.findById(publicationDto.getId())
                .orElseThrow(() -> new NotFoundException("")) : new Publication();

        publication.setTitle(publicationDto.getTitle());
        publication.setTextMessage(publicationDto.getTextMessage());

        if (publicationDto.getNewMedia() != null) {
            for (MultipartFile newMedia: publicationDto.getNewMedia()) {
                try {
                    publication.getMedia().add(new Media(null,
                            newMedia.getOriginalFilename(),
                            newMedia.getContentType(),
                            mediaService.createMedia(newMedia.getBytes()),
                            publication));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

        publicationRepository.save(publication);
    }

    @Override
    public void deleteById(Long id) {
        publicationRepository.deleteById(id);
    }

    private static PublicationDto convertToDto(Publication publication) {
        return new PublicationDto(
                publication.getId(),
                publication.getTitle(),
                publication.getTextMessage(),
                publication.getMedia()
                        .stream()
                        .map(Media::getId)
                        .collect(Collectors.toList()),
                publication.getItem());
    }
}
