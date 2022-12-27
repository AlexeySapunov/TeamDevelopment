package ru.gb.bot.sections;

import org.springframework.data.domain.Page;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.gb.dto.BackendPublicationDto;
import ru.gb.dto.UserBotDto;
import ru.gb.model.Publication;
import ru.gb.service.BackendPublicationService;
import ru.gb.service.BackendUserService;

import java.util.Optional;

import static ru.gb.bot.commands.CommandName.ARTICLE_LIST_CALLBACK_DESIGN;
import static ru.gb.bot.keyboards.Button.K_DESIGN_SECTION;

public class DesignSection implements SectionHub{

    private final BackendPublicationService publicationService;

    private final BackendUserService userService;

    public DesignSection(BackendPublicationService publicationService, BackendUserService userService) {
        this.publicationService = publicationService;
        this.userService = userService;
    }

    @Override
    public Page<BackendPublicationDto> getListOfArticle(Optional<String> authorName,
                                                        Optional<String> titleFilter,
                                                        Optional<Integer> page,
                                                        Optional<Integer> size,
                                                        Optional<String> sort) {
        Optional<String> menuItem = Optional.ofNullable(K_DESIGN_SECTION.getCommandButtonName());

        return publicationService.findAll(authorName, menuItem, titleFilter,
                page.orElse(1) - 1,
                size.orElse(5),
                sort.filter(fld -> !fld.isBlank()).orElse("id"));
    }

    @Override
    public InlineKeyboardMarkup init(Long chatId) {
        SelectInlineKeyBoard selectInlineKeyBoard = new SelectInlineKeyBoard(this);
        return selectInlineKeyBoard.selectKeyboard();
    }

    @Override
    public Optional<BackendPublicationDto> getArticle(Long id) {
        return publicationService.findById(id);
    }

    @Override
    public void addArticle(BackendPublicationDto publication) {
        Publication.MenuItem item = Publication.MenuItem.Design;
        publication.setItem(item);

        publicationService.save(publication);
    }

    @Override
    public void backHome() {

    }

    @Override
    public void backSelectSection() {

    }

    @Override
    public Optional<UserBotDto> getAuthorInfo(Long id) {
        return userService.findById(id);
    }

    @Override
    public String getNameSection() {
        return K_DESIGN_SECTION.getCommandButtonName();
    }

    @Override
    public String getNameListArticleCallBack() {
        return ARTICLE_LIST_CALLBACK_DESIGN.getCommandName();
    }
}
