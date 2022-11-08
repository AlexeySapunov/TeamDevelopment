package ru.gb.telegrambot.bot.commands;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.gb.telegrambot.bot.sections.*;
import ru.gb.telegrambot.bot.service.SendBotMessageService;

import static ru.gb.telegrambot.bot.keyboards.Button.*;

public class SelectSectionCommand implements Commands {

    private final SendBotMessageService sendBotMessageService;

    public static final String MESSAGE = "Выберите интересующую вас статью";

    public SelectSectionCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        SectionHub sectionHub = selectSection(update);
        InlineKeyboardMarkup inlineKeyboardMarkup = sectionHub.init(update.getMessage().getChatId());
        String message = sectionHub.getNameSection();
        sendBotMessageService.sendMessage(update.getMessage().getChatId(), message, inlineKeyboardMarkup);
    }

    private SectionHub selectSection(Update update) {
        SectionHub sectionHub = null;
        if (update.getMessage().getText().equals(K_MOBILE_DEV_SECTION.getCommandButtonName())) {
            return new MobileDevelopmentSection();
        } else if (update.getMessage().getText().equals(K_DESIGN_SECTION.getCommandButtonName())) {
            return new DesignSection();
        } else if (update.getMessage().getText().equals(K_MARKETING_SECTION.getCommandButtonName())) {
            return new MarketingSection();
        } else  if (update.getMessage().getText().equals(K_WEB_DEV_SECTION.getCommandButtonName())){
            return new WebDevelopmentSection();
        }
        return sectionHub;
    }
}
