package ru.gb.bot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.gb.bot.commands.CommandContainer;

import ru.gb.bot.keyboards.KeyboardsMain;
import ru.gb.bot.service.SendBotMessageServiceImpl;
import ru.gb.config.BotConfig;


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
    public Bot(BotConfig config, KeyboardsMain keyboards) {
        this.config = config;
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this, keyboards));


    }


    @Override
    public void onUpdateReceived(Update update) {
        int a = 0;
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            String username = update.getMessage().getFrom().getUserName();
            String commandIdentifier;

            if (message.startsWith(COMMAND_PREFIX)) {
                commandIdentifier = message.split(" ")[0].toLowerCase();
                commandContainer.findCommand(commandIdentifier, username).execute(update);
            } else {
                commandIdentifier = message;
                commandContainer.findCommand(commandIdentifier, username).execute(update);
            }
        } else if (update.hasCallbackQuery()) {
            String commandIdentifier;
            commandIdentifier = update.getCallbackQuery().getData();
            commandContainer.findCommand(commandIdentifier).execute(update);
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

