package ru.gb.telegrambot.bot.service;

public interface SendBotMessageService {
    void sendMessage(Long chatId, String message);

}
