package ru.gb.bot.commands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.gb.bot.sections.DesignSection;
import ru.gb.bot.sections.SectionHub;
import ru.gb.bot.service.SendBotMessageService;
import ru.gb.service.BackendPublicationService;
import ru.gb.service.BackendUserService;

public class ArticleListCallBackCommand implements Commands{

    private final SendBotMessageService sendBotMessageService;

    public static final String MESSAGE = "Выберите интересующую вас статью";
    private final BackendPublicationService publicationService;
    private final BackendUserService userService;

    public ArticleListCallBackCommand(SendBotMessageService sendBotMessageService,
                                      BackendPublicationService publicationService, BackendUserService userService) {
        this.sendBotMessageService = sendBotMessageService;
        this.publicationService = publicationService;
        this.userService = userService;
    }

    @Override
    public void execute(Update update) {
//        SectionHub sectionHub = selectSection(update);
//        String message = sectionHub.getNameSection();
//        InlineKeyboardMarkup inlineKeyboardMarkup;
//        sendBotMessageService.sendMessage(update.getMessage().getChatId(), message,
//                inlineKeyboardMarkup);
    }

    private SectionHub selectSection(Update update) {
        SectionHub sectionHub = null;
        if (update.getCallbackQuery().getMessage().getText().equals(CommandName.ARTICLE_LIST_CALLBACK_DESIGN.getCommandName())) {
            return new DesignSection(publicationService, userService);
        }
        return sectionHub;
    }
}
