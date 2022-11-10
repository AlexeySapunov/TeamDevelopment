package ru.gb.telegrambot.bot.commands;

import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import ru.gb.telegrambot.bot.sections.MobileDevelopmentSection;
import ru.gb.telegrambot.bot.sections.SectionHub;
import ru.gb.telegrambot.bot.service.SendBotMessageService;
import java.util.Map;

import static ru.gb.telegrambot.bot.commands.CommandName.*;
import static ru.gb.telegrambot.bot.keyboards.Button.*;
@Slf4j
public class CommandContainer {

    private final Map<String, Commands> commandsMap;
    private final Commands unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService) {
        commandsMap = ImmutableMap.<String, Commands>builder()
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(K_HELP.getCommandButtonName(), new HelpCommand(sendBotMessageService))
                .put(K_MOBILE_DEV_SECTION.getCommandButtonName(), new SelectSectionCommand(sendBotMessageService))
                .put(K_WEB_DEV_SECTION.getCommandButtonName(), new SelectSectionCommand(sendBotMessageService))
                .put(K_DESIGN_SECTION.getCommandButtonName(), new SelectSectionCommand(sendBotMessageService))
                .put(K_MARKETING_SECTION.getCommandButtonName(), new SelectSectionCommand(sendBotMessageService))
                .put(START.getCommandName(), new StartCommand(sendBotMessageService))
                .put(BACK_IN_MAIN_CALLBACK.getCommandName(), new BackMainCallBackCommand(sendBotMessageService))
                .put(K_MAIN.getCommandButtonName(), new MainCommand(sendBotMessageService))
                .build();


        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Commands findCommand(String commandIdentifier, String username) {
        Commands orDefault = commandsMap.getOrDefault(commandIdentifier, unknownCommand);

        return orDefault;
    }

    public Commands findCommand(String commandIdentifier) {
        Commands orDefault = commandsMap.getOrDefault(commandIdentifier, unknownCommand);

        return orDefault;
    }







}
