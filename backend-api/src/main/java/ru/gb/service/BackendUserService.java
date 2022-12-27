package ru.gb.service;

import ru.gb.dto.UserBotDto;

import java.util.Optional;

public interface BackendUserService {

    Optional<UserBotDto> findById(Long id);
}
