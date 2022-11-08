package ru.gb.telegrambot.bot.commands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.gb.telegrambot.bot.sections.MainSection;
import ru.gb.telegrambot.bot.service.SendBotMessageService;

import static ru.gb.telegrambot.bot.commands.HelpCommand.HELP_MESSAGE;

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
