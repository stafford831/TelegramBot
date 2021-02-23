package Telegram.Entities;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component ("thirdQuestion")
public class ThirdQuestion {
    public SendMessage sendInlineKeyBoardMessage(long chatId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow3 = new ArrayList<>();
        keyboardButtonsRow1.add(new InlineKeyboardButton().setText("1 раз в 3 года").setCallbackData("Ответ неверный"));
        keyboardButtonsRow2.add(new InlineKeyboardButton().setText("Не реже 1 раза в 7 лет").setCallbackData("Ответ неверный"));
        keyboardButtonsRow3.add(new InlineKeyboardButton().setText("Не реже 1 раза в 5 лет").setCallbackData("Ответ верный"));
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        rowList.add(keyboardButtonsRow3);
        inlineKeyboardMarkup.setKeyboard(rowList);
        return new SendMessage().setChatId(chatId).setText("Как часто следует перезаряжать углекислотные огнетушители?").setReplyMarkup(inlineKeyboardMarkup);
    }
}
