package ru.gb.telegrambot.bot.sections;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public interface SectionHub {
    void getListOfArticle();
    InlineKeyboardMarkup init(Long chatId);
    void getArticle();
    void addArticle();
    void backHome();
    void backSelectSection();
    void getAuthorInfo();
    String getNameSection();
    String getNameListArticleCallBack();



}
