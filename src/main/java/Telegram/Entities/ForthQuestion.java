package Telegram.Entities;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component("forthQuestion")
public class ForthQuestion {
    public SendMessage sendInlineKeyBoardMessage(long chatId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow3 = new ArrayList<>();
        keyboardButtonsRow1.add(new InlineKeyboardButton().setText("Красный").setCallbackData("Ответ верный"));
        keyboardButtonsRow2.add(new InlineKeyboardButton().setText("Желтый").setCallbackData("Ответ неверный"));
        keyboardButtonsRow3.add(new InlineKeyboardButton().setText("Черный").setCallbackData("Ответ неверный"));
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        rowList.add(keyboardButtonsRow3);
        inlineKeyboardMarkup.setKeyboard(rowList);
        return new SendMessage().setChatId(chatId).setText("В какой цвет окрашивают пожарные шкафы?").setReplyMarkup(inlineKeyboardMarkup);
    }
}
