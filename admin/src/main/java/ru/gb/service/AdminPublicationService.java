package ru.gb.service;

import org.springframework.data.domain.Page;
import ru.gb.dto.AdminPublicationDto;

import java.util.Optional;

public interface AdminPublicationService {

    Page<AdminPublicationDto> findAll(Optional<String> authorName, Optional<String> menuItem, Optional<String> titleFilter,
                                      Integer page, Integer size, String sort);

    Optional<AdminPublicationDto> findById(Long id);

    void save(AdminPublicationDto adminPublicationDto);

    void deleteById(Long id);
}
