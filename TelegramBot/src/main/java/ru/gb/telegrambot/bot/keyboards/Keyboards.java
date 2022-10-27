package ru.gb.telegrambot.bot.keyboards;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface Keyboards {

    void init(Message message);


}
