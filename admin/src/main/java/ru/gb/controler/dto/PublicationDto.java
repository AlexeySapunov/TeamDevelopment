package ru.gb.controler.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import ru.gb.database.model.Media;
import ru.gb.database.model.Publication;
import ru.gb.database.model.User;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicationDto {

    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String textMessage;

    private MultipartFile[] newMedia;

    private List<Long> media;

    @NotBlank
    private User author;

    @NotBlank
    private Publication.MenuItem item;

    public PublicationDto(Long id, String title, String textMessage, List<Long> media, Publication.MenuItem item) {
        this.id = id;
        this.title = title;
        this.textMessage = textMessage;
        this.media = media;
        this.item = item;
    }
}
