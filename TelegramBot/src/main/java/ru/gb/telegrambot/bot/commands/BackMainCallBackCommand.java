package ru.gb.telegrambot.bot.commands;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.gb.telegrambot.bot.sections.MainSection;
import ru.gb.telegrambot.bot.service.SendBotMessageService;

public class BackMainCallBackCommand implements Commands {

    private final SendBotMessageService sendBotMessageService;
    private final MainSection mainSection;

    public BackMainCallBackCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
        mainSection = new MainSection();
    }

    @Override
    public void execute(Update update) {
        long chatId = update.getCallbackQuery().getMessage().getChatId();
        long messageId = update.getCallbackQuery().getMessage().getMessageId();

        EditMessageText message = new EditMessageText();
        message.setChatId(String.valueOf(chatId));
        message.setText(mainSection.getText(update));
        message.setMessageId((int) messageId);
        sendBotMessageService.sendMessageCallBack(message);

    }
}
