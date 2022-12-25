package ru.gb.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gb.model.Publication;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class BackendPublicationDto implements Serializable {

    private Long id;

    private String title;

    private String textMessage;

    private List<Long> pictures;

    private Publication.MenuItem item;
}
