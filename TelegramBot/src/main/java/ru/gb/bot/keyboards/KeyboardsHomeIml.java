package ru.gb.bot.keyboards;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Service
public class KeyboardsHomeIml implements KeyboardsMain {

    public KeyboardsHomeIml() {
    }

    @Override
    public void init(SendMessage sendMessage) {
        // Создаем клавиатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardFirstRow.add(Button.K_MAIN.getCommandButtonName());

        // Вторая строчка клавиатуры
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboardSecondRow.add(Button.K_MOBILE_DEV_SECTION.getCommandButtonName());
        keyboardSecondRow.add(Button.K_WEB_DEV_SECTION.getCommandButtonName());

        KeyboardRow keyboardThirdRow = new KeyboardRow();
        // Добавляем кнопки в третью строчку клавиатуры
        keyboardThirdRow.add(Button.K_DESIGN_SECTION.getCommandButtonName());
        keyboardThirdRow.add(Button.K_MARKETING_SECTION.getCommandButtonName());


        KeyboardRow keyboardFourthRow = new KeyboardRow();
        // Добавляем кнопки в третью строчку клавиатуры
        keyboardFourthRow.add(Button.K_HELP.getCommandButtonName());


        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        keyboard.add(keyboardThirdRow);
        keyboard.add(keyboardFourthRow);
        // и устанавливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);

    }


}
