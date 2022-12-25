package ru.gb.service;

import org.springframework.data.domain.Page;
import ru.gb.dto.BackendPublicationDto;

import java.util.Optional;

public interface BackendPublicationService {

    Page<BackendPublicationDto> findAll(Optional<String> authorName, Optional<String> menuItem, Optional<String> titleFilter,
                                        Integer page, Integer size, String sort);

    Optional<BackendPublicationDto> findById(Long id);
}
