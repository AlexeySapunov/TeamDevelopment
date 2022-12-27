package ru.gb.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import ru.gb.model.Publication;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class BackendPublicationDto implements Serializable {

    private Long id;

    private String title;

    private String textMessage;

    private MultipartFile[] newPicture;

    private List<Long> pictures;

    private Publication.MenuItem item;

    public BackendPublicationDto(Long id, String title, String textMessage, List<Long> pictures, Publication.MenuItem item) {
        this.id = id;
        this.title = title;
        this.textMessage = textMessage;
        this.pictures = pictures;
        this.item = item;
    }

    public BackendPublicationDto(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
