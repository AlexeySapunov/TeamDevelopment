package ru.gb.telegrambot.bot.commands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.gb.telegrambot.bot.keyboards.Keyboards;
import ru.gb.telegrambot.bot.keyboards.KeyboardsHome;
import ru.gb.telegrambot.bot.service.SendBotMessageService;

public class HelpCommand implements Commands{

    private final SendBotMessageService sendBotMessageService;

    public static final String HELP_MESSAGE = "С помощью данного бота вы можете найти статью по интересам," +
            " а также стать автором и опубликовать свою статью";

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId(), HELP_MESSAGE);
    }
}

