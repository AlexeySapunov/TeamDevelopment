package ru.gb.telegrambot.bot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.gb.telegrambot.bot.Bot;

@Service
public class SendBotMessageServiceImpl implements SendBotMessageService {

    private final Bot bot;

    @Autowired
    public SendBotMessageServiceImpl(Bot bot) {
        this.bot = bot;
    }


    @Override
    public void sendMessage(Long chatId, String message) {
        SendMessage sendMessage = new SendMessage(); //Создаем объект класса SendMessage - наш будущий ответ пользователю
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);

        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
