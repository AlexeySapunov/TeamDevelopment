package ru.gb.bot.service;

import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public interface SendBotMessageService {
    void sendMessage(Long chatId, String message);
    void sendMessage(Long chatId, String message, InlineKeyboardMarkup inlineKeyboardMarkup);
    void sendMessageCallBack(EditMessageText sendMessage);

}
