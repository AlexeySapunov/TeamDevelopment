package ru.gb.bot.commands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.gb.bot.sections.MainSection;
import ru.gb.bot.service.SendBotMessageService;

public class MainCommand implements Commands {
    private final SendBotMessageService sendBotMessageService;
    private final MainSection mainSection;


    public MainCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
        this.mainSection = new MainSection();
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId(), mainSection.getText(update));
    }
}
