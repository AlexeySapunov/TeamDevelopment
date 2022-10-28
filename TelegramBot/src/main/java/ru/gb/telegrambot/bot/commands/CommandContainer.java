package ru.gb.telegrambot.bot.commands;

import com.google.common.collect.ImmutableMap;
import ru.gb.telegrambot.bot.keyboards.Keyboards;
import ru.gb.telegrambot.bot.service.SendBotMessageService;
import java.util.Map;

import static ru.gb.telegrambot.bot.commands.CommandName.*;
import static ru.gb.telegrambot.bot.keyboards.Button.*;

public class CommandContainer {

    private final Map<String, Commands> commandsMap;
    private final Map<String, Commands> commandsButtonMap;
    private final Commands unknownCommand;


    public CommandContainer(SendBotMessageService sendBotMessageService) {
        commandsMap = ImmutableMap.<String, Commands>builder()
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .build();

        commandsButtonMap = ImmutableMap.<String, Commands>builder()
                .put(K_HELP.getCommandButtonName(), new HelpCommand(sendBotMessageService))
                .build();

        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Commands findCommand(String commandIdentifier, String username) {
        Commands orDefault = commandsMap.getOrDefault(commandIdentifier, unknownCommand);

        return orDefault;
    }


    public Commands findCommandButton(String commandIdentifier, String username){
        Commands orDefault = commandsButtonMap.getOrDefault(commandIdentifier, unknownCommand);

        return orDefault;
    }



}
