package ru.gb.bot.commands;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface Commands {

    void execute(Update update);
}
