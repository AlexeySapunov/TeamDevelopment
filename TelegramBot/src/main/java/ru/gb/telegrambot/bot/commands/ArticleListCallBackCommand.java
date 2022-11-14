package ru.gb.telegrambot.bot.commands;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.gb.telegrambot.bot.sections.*;
import ru.gb.telegrambot.bot.service.SendBotMessageService;

import static ru.gb.telegrambot.bot.commands.CommandName.*;
import static ru.gb.telegrambot.bot.keyboards.Button.*;
import static ru.gb.telegrambot.bot.keyboards.Button.K_WEB_DEV_SECTION;

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
        if (update.getCallbackQuery().getMessage().getText().equals(ARTICLE_LIST_CALLBACK_DESIGN.getCommandName())) {
            return new DesignSection();
        }
        return sectionHub;
    }
}
