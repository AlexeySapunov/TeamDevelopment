package ru.gb.service;

import ru.gb.controller.MediaDto;

import java.util.Optional;

public interface MediaService {

    Optional<MediaDto> getMediaDataById(long id);

    String createMedia(byte[] mediaData);

    void deleteById(Long id);
}
