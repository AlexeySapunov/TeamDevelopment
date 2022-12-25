package ru.gb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.service.PictureService;

@RestController
@RequestMapping("/picture")
public class PictureController {

    private static final Logger logger = LoggerFactory.getLogger(PictureController.class);

    private final PictureService pictureService;

    @Autowired
    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @GetMapping("/{pictureId}")
    public ResponseEntity<byte[]> downloadPicture(@PathVariable("pictureId") long pictureId) {
        return pictureService.getPictureDataById(pictureId)
                .map(pic -> ResponseEntity
                        .ok()
                        .header(HttpHeaders.CONTENT_TYPE, pic.getContentType())
                        .body(pic.getData()))
                .orElse(ResponseEntity
                        .notFound()
                        .build());


    }

    @DeleteMapping("/{pictureId}")
    public void deletePicture(@PathVariable("pictureId") Long pictureId) {
        logger.info("Deleting picture with id {}", pictureId);

        pictureService.deleteById(pictureId);
    }
}
