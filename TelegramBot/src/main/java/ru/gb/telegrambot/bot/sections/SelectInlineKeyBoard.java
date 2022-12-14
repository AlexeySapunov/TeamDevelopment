package ru.gb.telegrambot.bot.sections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

import static ru.gb.telegrambot.bot.keyboards.Button.*;
import static ru.gb.telegrambot.bot.commands.CommandName.*;

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

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(button1);

        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        keyboardButtonsRow2.add(button2);

        List<InlineKeyboardButton> keyboardButtonsRow3 = new ArrayList<>();
        keyboardButtonsRow3.add(button3);


        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        rowList.add(keyboardButtonsRow3);

        inlineKeyboardMarkup.setKeyboard(rowList);

        return inlineKeyboardMarkup;
    }
}
