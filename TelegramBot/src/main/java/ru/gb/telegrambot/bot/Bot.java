package ru.gb.telegrambot.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.gb.telegrambot.config.BotConfig;


@Component
public class Bot extends TelegramLongPollingBot {

    final BotConfig config;

    @Value("${bot.name}")
    private String botUsername;


    @Value("${bot.token}")
    private String botToken;

    public Bot(BotConfig config) {
        this.config = config;

    }


    @Override
    public void onUpdateReceived(Update update) {
        try{
            if(update.hasMessage() && update.getMessage().hasText())
            {
                Message inMess = update.getMessage();//Извлекаем из объекта сообщение пользователя
                String chatId = inMess.getChatId().toString(); //Достаем из inMess id чата пользователя
                String response = inMess.getText();//Получаем текст сообщения пользователя, отправляем в написанный нами обработчик
                SendMessage outMess = new SendMessage(); //Создаем объект класса SendMessage - наш будущий ответ пользователю

                //Добавляем в наше сообщение id чата а также наш ответ
                outMess.setChatId(chatId);
                outMess.setText(response);

                //Отправка в чат
                execute(outMess);
            }

        } catch (TelegramApiException e) {
            e.printStackTrace();
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

}

