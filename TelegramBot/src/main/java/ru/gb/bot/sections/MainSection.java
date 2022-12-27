package ru.gb.bot.sections;

import org.telegram.telegrambots.meta.api.objects.Update;

public class MainSection {
    public MainSection() {
    }

    private String text;

    public String getText(Update update) {
        text =
                "\nСтатистика бота:\n" +
                "Размещено статей в боте: " +
                "\nВсего читателей в боте: ";
        return text;
    }
}
