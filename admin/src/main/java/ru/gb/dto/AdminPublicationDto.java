package ru.gb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import ru.gb.model.Publication;
import ru.gb.model.User;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminPublicationDto {

    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String textMessage;

    private MultipartFile[] newPicture;

    private List<Long> picture;

    @NotBlank
    private User author;

    @NotBlank
    private Publication.MenuItem item;

    public AdminPublicationDto(Long id, String title, String textMessage, List<Long> picture, Publication.MenuItem item) {
        this.id = id;
        this.title = title;
        this.textMessage = textMessage;
        this.picture = picture;
        this.item = item;
    }
}
