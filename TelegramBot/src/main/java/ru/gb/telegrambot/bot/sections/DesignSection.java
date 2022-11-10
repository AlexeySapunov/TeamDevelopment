package ru.gb.telegrambot.bot.sections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.util.ArrayList;
import java.util.List;

import static ru.gb.telegrambot.bot.commands.CommandName.*;
import static ru.gb.telegrambot.bot.keyboards.Button.*;

public class DesignSection implements SectionHub{



    @Override
    public void getListOfArticle() {

    }

    @Override
    public InlineKeyboardMarkup init(Long chatId) {
        SelectInlineKeyBoard selectInlineKeyBoard = new SelectInlineKeyBoard(this);
        return selectInlineKeyBoard.selectKeyboard();
    }

    @Override
    public void getArticle() {

    }

    @Override
    public void addArticle() {

    }

    @Override
    public void backHome() {

    }

    @Override
    public void backSelectSection() {

    }

    @Override
    public void getAuthorInfo() {

    }

    @Override
    public String getNameSection() {
        return K_DESIGN_SECTION.getCommandButtonName();
    }

    @Override
    public String getNameListArticleCallBack() {
        return ARTICLE_LIST_CALLBACK_DESIGN.getCommandName();
    }


}
