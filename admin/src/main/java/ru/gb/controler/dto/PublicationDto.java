package ru.gb.controler.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gb.database.model.Media;
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

    private List<Media> media;

    @NotBlank
    private User author;

    @NotBlank
    private MenuItem item;
}
