package ru.gb.service;

import org.springframework.data.domain.Page;
import ru.gb.controler.dto.PublicationDto;

import java.util.Optional;

public interface PublicationService {

    Page<PublicationDto> findAll(Optional<String> authorName, Optional<String> menuItem, Optional<String> titleFilter,
                                 Integer page, Integer size, String sort);

    Optional<PublicationDto> findById(Long id);

    void save(PublicationDto publicationDto);

    void deleteById(Long id);
}
