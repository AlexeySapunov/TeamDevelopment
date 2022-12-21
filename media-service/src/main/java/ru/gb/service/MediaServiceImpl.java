package ru.gb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.gb.controller.MediaDto;
import ru.gb.database.repo.MediaRepository;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Service
public class MediaServiceImpl implements MediaService {

    private static final Logger logger = LoggerFactory.getLogger(MediaServiceImpl.class);

    private final MediaRepository mediaRepository;

    @Value("${picture.storage.path}")
    private String storagePath;

    @Autowired
    public MediaServiceImpl(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    @Override
    public Optional<MediaDto> getMediaDataById(long id) {
        return mediaRepository.findById(id)
                .map(pic -> new MediaDto(pic.getContentType(), Paths.get(storagePath, pic.getStorageFileName())))
                .filter(media -> Files.exists(media.getPath()))
                .map(media -> {
                    try {
                        media.setData(Files.readAllBytes(media.getPath()));
                        return media;
                    } catch (IOException ex) {
                        logger.error("Can't read file", ex);
                        throw new RuntimeException(ex);
                    }
                });
    }

    @Override
    public String createMedia(byte[] mediaData) {
        String fileName = UUID.randomUUID().toString();

        try (OutputStream outputStream = Files.newOutputStream(Paths.get(storagePath, fileName))) {
            outputStream.write(mediaData);
        } catch (IOException e) {
            logger.error("Can't write to file", e);
            throw new RuntimeException(e);
        }

        return fileName;
    }

    @Override
    public void deleteById(Long id) {
        mediaRepository.deleteById(id);
    }
}
