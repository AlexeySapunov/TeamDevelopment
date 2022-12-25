package ru.gb.bot.commands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.gb.bot.service.SendBotMessageService;

public class StartCommand implements Commands{

    private final SendBotMessageService sendBotMessageService;
    private String name;

    private final String startMessageText = "С помощью бота TeleHabr ты можешь ," + "просматривать статьи пользователей " +
            " по таким разделам как \n-Веб программирование\n-Мобильная разработка\n-Дизайн\n-Маркетинг\n\n" +
            "Также можешь опубликовать собственную статью. \n \nЧтобы просмотреть статью - выберите раздел и" +
            " откройте список статей \nЧтобы опубликовать статью - нажмите кнопку Опубликовать статью\n\nПриятного пользлования!";

    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        name = update.getMessage().getChat().getUserName();
        String text = "Привет, " + name + "!\n\n" + startMessageText;
        sendBotMessageService.sendMessage(update.getMessage().getChatId(), text);
    }
}

