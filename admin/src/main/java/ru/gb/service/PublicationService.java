package ru.gb.service;

import org.springframework.data.domain.Page;
import ru.gb.controler.dto.MenuItem;
import ru.gb.controler.dto.PublicationDto;

import java.util.List;
import java.util.Optional;

public interface PublicationService {

    List<PublicationDto> findAll();

    Page<PublicationDto> findWithFilter(MenuItem item);

    Optional<PublicationDto> findById(Long id);

    void save(PublicationDto publicationDto);

    void deleteById(Long id);
}
