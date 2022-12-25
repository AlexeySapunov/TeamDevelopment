package ru.gb.bot.commands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.gb.bot.sections.DesignSection;
import ru.gb.bot.sections.SectionHub;
import ru.gb.bot.service.SendBotMessageService;

public class ArticleListCallBackCommand implements Commands{

    private final SendBotMessageService sendBotMessageService;

    public static final String MESSAGE = "Выберите интересующую вас статью";

    public ArticleListCallBackCommand (SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
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
            return new DesignSection();
        }
        return sectionHub;
    }
}
