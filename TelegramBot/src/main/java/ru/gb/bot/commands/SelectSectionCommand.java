package ru.gb.bot.commands;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.gb.bot.sections.*;
import ru.gb.bot.service.SendBotMessageService;
import ru.gb.service.BackendPublicationService;
import ru.gb.service.BackendUserService;

import static ru.gb.bot.keyboards.Button.*;

public class SelectSectionCommand implements Commands {

    private final SendBotMessageService sendBotMessageService;

    public static final String MESSAGE = "Выберите интересующую вас статью";
    private final BackendPublicationService publicationService;
    private final BackendUserService userService;

    public SelectSectionCommand(SendBotMessageService sendBotMessageService, BackendPublicationService publicationService, BackendUserService userService) {
        this.sendBotMessageService = sendBotMessageService;
        this.publicationService = publicationService;
        this.userService = userService;
    }

    @Override
    public void execute(Update update) {
        SectionHub sectionHub = selectSection(update);
        InlineKeyboardMarkup inlineKeyboardMarkup = sectionHub.init(update.getMessage().getChatId());
        String message = sectionHub.getNameSection();
        sendBotMessageService.sendMessage(update.getMessage().getChatId(), message, inlineKeyboardMarkup);
    }

    private SectionHub selectSection(Update update) {
        SectionHub sectionHub = null;
        if (update.getMessage().getText().equals(K_MOBILE_DEV_SECTION.getCommandButtonName())) {
            return new MobileDevelopmentSection(publicationService, userService);
        } else if (update.getMessage().getText().equals(K_DESIGN_SECTION.getCommandButtonName())) {
            return new DesignSection(publicationService, userService);
        } else if (update.getMessage().getText().equals(K_MARKETING_SECTION.getCommandButtonName())) {
            return new MarketingSection(publicationService, userService);
        } else  if (update.getMessage().getText().equals(K_WEB_DEV_SECTION.getCommandButtonName())){
            return new WebDevelopmentSection(publicationService, userService);
        }
        return sectionHub;
    }
}
