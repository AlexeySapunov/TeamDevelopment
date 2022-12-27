package ru.gb.bot.sections;

import org.springframework.data.domain.Page;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.gb.dto.BackendPublicationDto;
import ru.gb.dto.UserBotDto;
import ru.gb.model.UserBot;

import java.util.Optional;

public interface SectionHub {
    Page<BackendPublicationDto> getListOfArticle(Optional<String> authorName,
                                                 Optional<String> titleFilter,
                                                 Optional<Integer> page, Optional<Integer> size, Optional<String> sort);
    InlineKeyboardMarkup init(Long chatId);
    Optional<BackendPublicationDto> getArticle(Long id);
    void addArticle(BackendPublicationDto publication);
    void backHome();
    void backSelectSection();
    Optional<UserBotDto> getAuthorInfo(Long id);
    String getNameSection();
    String getNameListArticleCallBack();



}
