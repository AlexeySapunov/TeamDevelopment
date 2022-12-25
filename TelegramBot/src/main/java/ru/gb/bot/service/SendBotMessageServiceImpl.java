package ru.gb.bot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.gb.bot.Bot;
import ru.gb.bot.keyboards.KeyboardsMain;

@Service
public class SendBotMessageServiceImpl implements SendBotMessageService {

    private final Bot bot;
    private final KeyboardsMain keyboards;

    @Autowired
    public SendBotMessageServiceImpl(Bot bot, KeyboardsMain keyboards) {
        this.bot = bot;
        this.keyboards = keyboards;
    }


    @Override
    public void sendMessage(Long chatId, String message) {
        SendMessage sendMessage = new SendMessage(); //Создаем объект класса SendMessage - наш будущий ответ пользователю
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        keyboards.init(sendMessage);

        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void sendMessage(Long chatId, String message, InlineKeyboardMarkup inlineKeyboardMarkup) {
        SendMessage sendMessage = new SendMessage(); //Создаем объект класса SendMessage - наш будущий ответ пользователю
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendMessageCallBack(EditMessageText sendMessage) {
        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


}
