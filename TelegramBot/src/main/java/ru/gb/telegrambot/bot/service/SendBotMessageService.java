package ru.gb.telegrambot.bot.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.gb.telegrambot.bot.sections.SectionHub;

public interface SendBotMessageService {
    void sendMessage(Long chatId, String message);
    void sendMessage(Long chatId, String message, InlineKeyboardMarkup inlineKeyboardMarkup);
    void sendMessageCallBack(EditMessageText sendMessage);

}
