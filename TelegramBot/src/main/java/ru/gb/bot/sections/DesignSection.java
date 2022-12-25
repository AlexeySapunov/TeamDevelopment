package ru.gb.bot.sections;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import static ru.gb.bot.commands.CommandName.*;
import static ru.gb.bot.keyboards.Button.*;

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
