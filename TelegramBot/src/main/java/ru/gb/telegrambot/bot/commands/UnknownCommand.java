package ru.gb.telegrambot.bot.commands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.gb.telegrambot.bot.service.SendBotMessageService;

public class UnknownCommand implements Commands
{
    public static final String UNKNOWN_MESSAGE = "Не понимаю тебя \uD83D\uDE1F, напиши /help чтобы узнать что я понимаю.";

    private final SendBotMessageService sendBotMessageService;

    public UnknownCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId(), UNKNOWN_MESSAGE);
    }
}
