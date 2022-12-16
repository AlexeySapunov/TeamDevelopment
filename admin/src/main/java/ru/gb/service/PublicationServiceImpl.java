package ru.gb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.gb.controler.dto.MenuItem;
import ru.gb.controler.dto.PublicationDto;
import ru.gb.database.repo.PublicationRepository;
import ru.gb.database.repo.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PublicationServiceImpl implements PublicationService {

    private final UserRepository userRepository;

    private final PublicationRepository publicationRepository;

    @Autowired
    public PublicationServiceImpl(UserRepository userRepository, PublicationRepository publicationRepository) {
        this.userRepository = userRepository;
        this.publicationRepository = publicationRepository;
    }

    @Override
    public List<PublicationDto> findAll() {
        return null;
    }

    @Override
    public Page<PublicationDto> findWithFilter(MenuItem item) {
        return null;
    }

    @Override
    public Optional<PublicationDto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(PublicationDto publicationDto) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
