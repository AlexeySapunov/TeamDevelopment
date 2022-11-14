package ru.gb.telegrambot.bot.commands;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface Commands {

    void execute(Update update);
}
