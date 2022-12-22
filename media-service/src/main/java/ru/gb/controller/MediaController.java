package ru.gb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.service.MediaService;

@RestController
@RequestMapping("/media")
public class MediaController {

    private static final Logger logger = LoggerFactory.getLogger(MediaController.class);

    private final MediaService mediaService;

    @Autowired
    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @GetMapping("/{mediaId}")
    public ResponseEntity<byte[]> downloadMedia(@PathVariable("mediaId") long mediaId) {
        return mediaService.getMediaDataById(mediaId)
                .map(media -> ResponseEntity
                        .ok()
                        .header(HttpHeaders.CONTENT_TYPE, media.getContentType())
                        .body(media.getData()))
                .orElse(ResponseEntity
                        .notFound()
                        .build());


    }

    @DeleteMapping("/{mediaId}")
    public void deleteMedia(@PathVariable("mediaId") Long mediaId) {
        logger.info("Deleting media with id {}", mediaId);

        mediaService.deleteById(mediaId);
    }
}
