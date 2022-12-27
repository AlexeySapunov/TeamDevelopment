package ru.gb.bot.keyboards;

public enum Button {

    K_ARTICLE_LIST("Список статей"),
    K_POST_ON_ARTICLE("Опубликовать статью"),
    K_HELP("Помощь"),

    K_MAIN("Главная"),

    K_SELECT_SECTION("Выберать секцию"),

    K_MOBILE_DEV_SECTION("Мобильная разработка"),
    K_WEB_DEV_SECTION("Веб разработка"),
    K_MARKETING_SECTION("Маркетинг"),
    K_DESIGN_SECTION("Дизайн"),

    K_DRIVER_CABINET("Кабинет автора"),
    K_WRITE_AUTHOR("Написать автору"),
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