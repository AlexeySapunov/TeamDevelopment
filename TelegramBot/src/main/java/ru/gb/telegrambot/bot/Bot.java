package ru.gb.telegrambot.bot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.gb.telegrambot.bot.keyboards.Keyboards;
import ru.gb.telegrambot.bot.keyboards.KeyboardsHome;
import ru.gb.telegrambot.config.BotConfig;

import java.util.ArrayList;
import java.util.List;


@Component
@Slf4j
public class Bot extends TelegramLongPollingBot {

    final BotConfig config;

    private Keyboards keyboards;


    @Value("${bot.name}")
    private String botUsername;


    @Value("${bot.token}")
    private String botToken;

    public Bot(BotConfig config) {
        this.config = config;
    }


    @Override
    public void onUpdateReceived(Update update) {
            if (update.hasMessage() && update.getMessage().hasText()) {
                Message message = update.getMessage();//Извлекаем из объекта сообщение пользователя
                String chatId = message.getChatId().toString(); //Достаем из inMess id чата пользователя
                String response = message.getText();//Получаем текст сообщения пользователя
                SendMessage outMess = new SendMessage(); //Создаем объект класса SendMessage - наш будущий ответ пользователю

                //Добавляем в наше сообщение id чата а также наш ответ
                outMess.setChatId(chatId);
                outMess.setText(response);

                //включаем клавиатуру главного меню
                keyboards = new KeyboardsHome(this);
                keyboards.init(message);
                //Отправка в чат
//                executeMessage(outMess);
                log.info("пользователь "+ update.getMessage().getChat().getFirstName() + " написал " + outMess );
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

