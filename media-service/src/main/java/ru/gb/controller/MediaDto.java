package ru.gb.controller;

import lombok.Getter;
import lombok.Setter;

import java.nio.file.Path;

@Setter
@Getter
public class MediaDto {

    private String contentType;

    private Path path;

    private byte[] data;

    public MediaDto(String contentType, Path path) {
        this.contentType = contentType;
        this.path = path;
    }
}
