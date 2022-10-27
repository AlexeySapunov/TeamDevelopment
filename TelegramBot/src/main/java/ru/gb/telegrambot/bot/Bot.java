package ru.gb.telegrambot.bot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.gb.telegrambot.bot.commands.CommandContainer;
import ru.gb.telegrambot.bot.service.SendBotMessageServiceImpl;
import ru.gb.telegrambot.config.BotConfig;


@Component
@Slf4j
public class Bot extends TelegramLongPollingBot {

    final BotConfig config;
    public static String COMMAND_PREFIX = "/";


    @Value("${bot.name}")
    private String botUsername;


    @Value("${bot.token}")
    private String botToken;

    private final CommandContainer commandContainer;


    @Autowired
    public Bot(BotConfig config) {
        this.config = config;
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this));

    }


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            String username = update.getMessage().getFrom().getUserName();
            if (message.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();
                commandContainer.findCommand(commandIdentifier, username).execute(update);
            } else {
                SendMessage sendMessage = new SendMessage(); //Создаем объект класса SendMessage - наш будущий ответ пользователю
                sendMessage.setChatId(update.getMessage().getChatId());
                sendMessage.setText("Вы ввели неизвестную команду");

                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }


    }



    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    private void executeMessage(SendMessage message) {
        try {
            execute(message);

        } catch (TelegramApiException e) {
            log.error("Текст ошибки:" + e.getMessage());
        }
    }

}

