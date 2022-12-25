package ru.gb.bot.commands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.gb.bot.service.SendBotMessageService;

public class HelpCommand implements Commands{

    private final SendBotMessageService sendBotMessageService;

    public static final String HELP_MESSAGE = "С помощью данного бота вы можете найти статью по интересам," +
            " а также стать автором и опубликовать свою статью. \n \nЧтобы просмотреть статью - выберите раздел и" +
            " откройте список статей \nЧтобы опубликовать статью - нажмите кнопку Опубликовать статью";

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId(), HELP_MESSAGE);
    }
}

