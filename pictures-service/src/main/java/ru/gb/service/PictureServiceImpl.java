package ru.gb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.gb.dto.PictureDto;
import ru.gb.repo.PictureRepository;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Service
public class PictureServiceImpl implements PictureService {

    private static final Logger logger = LoggerFactory.getLogger(PictureServiceImpl.class);

    private final PictureRepository pictureRepository;

    @Value("${picture.storage.path}")
    private String storagePath;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public Optional<PictureDto> getPictureDataById(long id) {
        return pictureRepository.findById(id)
                .map(pic -> new PictureDto(pic.getContentType(), Paths.get(storagePath, pic.getStorageFileName())))
                .filter(pic -> Files.exists(pic.getPath()))
                .map(pic -> {
                    try {
                        pic.setData(Files.readAllBytes(pic.getPath()));
                        return pic;
                    } catch (IOException ex) {
                        logger.error("Can't read file", ex);
                        throw new RuntimeException(ex);
                    }
                });
    }

    @Override
    public String createPicture(byte[] pictureData) {
        String fileName = UUID.randomUUID().toString();

        try (OutputStream outputStream = Files.newOutputStream(Paths.get(storagePath, fileName))) {
            outputStream.write(pictureData);
        } catch (IOException e) {
            logger.error("Can't write to file", e);
            throw new RuntimeException(e);
        }

        return fileName;
    }

    @Override
    public void deleteById(Long id) {
        pictureRepository.deleteById(id);
    }
}
