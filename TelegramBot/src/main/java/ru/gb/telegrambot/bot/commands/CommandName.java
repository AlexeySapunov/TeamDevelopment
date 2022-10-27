package ru.gb.telegrambot.bot.commands;

public enum CommandName {

    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    ADMIN_HELP("/ahelp");


    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}