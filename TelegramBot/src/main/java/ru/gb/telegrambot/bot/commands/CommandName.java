package ru.gb.telegrambot.bot.commands;

public enum CommandName {

    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    ADMIN_HELP("/ahelp"),
    ARTICLE_LIST_CALLBACK_MOBILE("/articleListMobile"),
    ARTICLE_LIST_CALLBACK_DESIGN("/articleListDesign"),
    ARTICLE_LIST_CALLBACK_MARKET("/articleListMarket"),
    ARTICLE_LIST_CALLBACK_WEB("/articleListWeb"),

    POST_ON_ARTICLE_CALLBACK("/postOnArticle"),
    BACK_TO_SECTION_CALLBACK("/backToSection"),
    BACK_IN_MAIN_CALLBACK("/backInMain");


    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}