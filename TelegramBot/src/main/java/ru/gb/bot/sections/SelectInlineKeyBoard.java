package ru.gb.bot.sections;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

import static ru.gb.bot.keyboards.Button.*;
import static ru.gb.bot.commands.CommandName.*;

public class SelectInlineKeyBoard {

    private final SectionHub sectionHub;

    public SelectInlineKeyBoard(SectionHub sectionHub) {
        this.sectionHub = sectionHub;
    }

    public InlineKeyboardMarkup selectKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(K_ARTICLE_LIST.getCommandButtonName());
        button1.setCallbackData(sectionHub.getNameListArticleCallBack());

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText(K_POST_ON_ARTICLE.getCommandButtonName());
        button2.setCallbackData(POST_ON_ARTICLE_CALLBACK.getCommandName());

        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText(K_BACK.getCommandButtonName());
        button3.setCallbackData(BACK_IN_MAIN_CALLBACK.getCommandName());

        MobileDevelopmentSection.addButton(inlineKeyboardMarkup, button1, button2, button3);

        return inlineKeyboardMarkup;
    }
}
