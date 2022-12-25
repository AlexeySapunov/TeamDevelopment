package ru.gb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.gb.controller.NotFoundException;
import ru.gb.dto.AdminPublicationDto;
import ru.gb.model.Picture;
import ru.gb.model.Publication;
import ru.gb.repo.PublicationRepository;
import ru.gb.repo.PublicationSpecification;


import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminPublicationServiceImpl implements AdminPublicationService {

    private final PictureService pictureService;

    private final PublicationRepository publicationRepository;

    @Autowired
    public AdminPublicationServiceImpl(PictureService pictureService, PublicationRepository publicationRepository) {
        this.pictureService = pictureService;
        this.publicationRepository = publicationRepository;
    }

    @Override
    public Page<AdminPublicationDto> findAll(Optional<String> authorName,
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
                .map(AdminPublicationServiceImpl::convertToDto);
    }

    @Override
    public Optional<AdminPublicationDto> findById(Long id) {
        return publicationRepository.findById(id)
                .map(AdminPublicationServiceImpl::convertToDto);
    }

    @Override
    public void save(AdminPublicationDto adminPublicationDto) {
        Publication publication = (adminPublicationDto.getId() != null) ? publicationRepository.findById(adminPublicationDto.getId())
                .orElseThrow(() -> new NotFoundException("")) : new Publication();

        publication.setTitle(adminPublicationDto.getTitle());
        publication.setTextMessage(adminPublicationDto.getTextMessage());

        if (adminPublicationDto.getNewPicture() != null) {
            for (MultipartFile newPicture: adminPublicationDto.getNewPicture()) {
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

    @Override
    public void deleteById(Long id) {
        publicationRepository.deleteById(id);
    }

    private static AdminPublicationDto convertToDto(Publication publication) {
        return new AdminPublicationDto(
                publication.getId(),
                publication.getTitle(),
                publication.getTextMessage(),
                publication.getPictures()
                        .stream()
                        .map(Picture::getId)
                        .collect(Collectors.toList()),
                publication.getItem());
    }
}
