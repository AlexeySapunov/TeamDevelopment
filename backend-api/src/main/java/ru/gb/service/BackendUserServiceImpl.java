package ru.gb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.dto.BackendPublicationDto;
import ru.gb.dto.UserBotDto;
import ru.gb.model.UserBot;
import ru.gb.repo.UserBotRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BackendUserServiceImpl implements BackendUserService {

    private final UserBotRepository userBotRepository;

    @Autowired
    public BackendUserServiceImpl(UserBotRepository userBotRepository) {
        this.userBotRepository = userBotRepository;
    }

    @Override
    public Optional<UserBotDto> findById(Long id) {
        return userBotRepository.findById(id)
                .map(userBot -> new UserBotDto(
                        userBot.getChatId(),
                        userBot.getFirstName(),
                        userBot.getLastName(),
                        userBot.getUserName(),
                        userBot.getRegisteredAt(),
                        mapPublicationDto(userBot)
                ));
    }

    private static List<BackendPublicationDto> mapPublicationDto(UserBot userBot) {
        return userBot.getPublications()
                .stream()
                .map(publication -> new BackendPublicationDto(publication.getId(), publication.getTitle()))
                .collect(Collectors.toList());
    }
}
