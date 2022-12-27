package ru.gb.bot.sections;

import org.springframework.data.domain.Page;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.gb.bot.commands.CommandName;
import ru.gb.bot.keyboards.Button;
import ru.gb.dto.BackendPublicationDto;
import ru.gb.dto.UserBotDto;
import ru.gb.model.Publication;
import ru.gb.service.BackendPublicationService;
import ru.gb.service.BackendUserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ru.gb.bot.keyboards.Button.K_MOBILE_DEV_SECTION;

public class MobileDevelopmentSection implements SectionHub {


    private final BackendPublicationService publicationService;
    private final BackendUserService userService;

    public MobileDevelopmentSection(BackendPublicationService publicationService, BackendUserService userService) {
        this.publicationService = publicationService;
        this.userService = userService;
    }

    public InlineKeyboardMarkup init(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(Button.K_ARTICLE_LIST.getCommandButtonName());
        button1.setCallbackData(CommandName.ARTICLE_LIST_CALLBACK_WEB.getCommandName());

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText(Button.K_POST_ON_ARTICLE.getCommandButtonName());
        button2.setCallbackData(CommandName.POST_ON_ARTICLE_CALLBACK.getCommandName());

        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText(Button.K_BACK.getCommandButtonName());
        button3.setCallbackData(CommandName.BACK_IN_MAIN_CALLBACK.getCommandName());

        addButton(inlineKeyboardMarkup, button1, button2, button3);
        sendMessage.setChatId(chatId);
        sendMessage.setText("Тест");
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        return inlineKeyboardMarkup;
    }

    static void addButton(InlineKeyboardMarkup inlineKeyboardMarkup, InlineKeyboardButton button1,
                          InlineKeyboardButton button2, InlineKeyboardButton button3) {
        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(button1);

        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        keyboardButtonsRow2.add(button2);

        List<InlineKeyboardButton> keyboardButtonsRow3 = new ArrayList<>();
        keyboardButtonsRow3.add(button3);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        rowList.add(keyboardButtonsRow3);

        inlineKeyboardMarkup.setKeyboard(rowList);
    }

    @Override
    public Page<BackendPublicationDto> getListOfArticle(Optional<String> authorName,
                                                        Optional<String> titleFilter,
                                                        Optional<Integer> page,
                                                        Optional<Integer> size,
                                                        Optional<String> sort) {
        Optional<String> menuItem = Optional.ofNullable(K_MOBILE_DEV_SECTION.getCommandButtonName());

        return publicationService.findAll(authorName, menuItem, titleFilter,
                page.orElse(1) - 1,
                size.orElse(5),
                sort.filter(fld -> !fld.isBlank()).orElse("id"));
    }

    @Override
    public Optional<BackendPublicationDto> getArticle(Long id) {
        return publicationService.findById(id);
    }

    @Override
    public void addArticle(BackendPublicationDto publication) {
        Publication.MenuItem item = Publication.MenuItem.MobileDevelopment;
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
    public String getNameSection (){
        return Button.K_MOBILE_DEV_SECTION.getCommandButtonName();
    }

    @Override
    public String getNameListArticleCallBack() {
        return CommandName.ARTICLE_LIST_CALLBACK_MOBILE.getCommandName();
    }
}
