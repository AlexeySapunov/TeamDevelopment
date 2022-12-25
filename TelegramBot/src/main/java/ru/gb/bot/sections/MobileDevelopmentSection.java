package ru.gb.bot.sections;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.gb.bot.commands.CommandName;
import ru.gb.bot.keyboards.Button;

import java.util.ArrayList;
import java.util.List;

public class MobileDevelopmentSection implements SectionHub {





    public MobileDevelopmentSection() {
    }

    public InlineKeyboardMarkup init(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(Button.K_ARTICLE_LIST.getCommandButtonName());
        button1.setCallbackData(CommandName.ARTICLE_LIST_CALLBACK_WEB.getCommandName());

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText(Button.K_POST_ON_ARTICLE.getCommandButtonName());
        button2.setCallbackData(CommandName.POST_ON_ARTICLE_CALLBACK.getCommandName());

        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText(Button.K_BACK.getCommandButtonName());
        button3.setCallbackData(CommandName.BACK_IN_MAIN_CALLBACK.getCommandName());

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
        sendMessage.setChatId(chatId);
        sendMessage.setText("Тест");
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        return inlineKeyboardMarkup;

    }

    @Override
    public void getListOfArticle() {

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
    public String getNameSection (){
        return Button.K_MOBILE_DEV_SECTION.getCommandButtonName();
    }

    @Override
    public String getNameListArticleCallBack() {
        return CommandName.ARTICLE_LIST_CALLBACK_MOBILE.getCommandName();
    }
}
