package ru.gb.telegrambot.bot.keyboards;

public enum Button {

    K_ARTICLE_LIST("Перейти к списку статей"),
    K_POST_ON_ARTICLE("Опубликовать статью"),
    K_HELP("Помощь"),
    K_CLIENT_CABINET("Кабинет клиента"),
    K_DRIVER_CABINET("Кабинет автора"),
    K_SUPPORT("Оставить обращение"),
    K_ABOUT_AS("О нас"),
    K_NEXT("➡ Далее"),
    K_BACK ("⬅ Назад");


    private final String commandButtonName;

    Button(String commandButtonName) {
        this.commandButtonName = commandButtonName;
    }

    public String getCommandButtonName() {
        return commandButtonName;
    }
}