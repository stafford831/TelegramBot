package Telegram.Bot;

import Telegram.Entities.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.security.auth.callback.Callback;


@Component
public class Bot extends TelegramLongPollingBot {
    public static int rightAnswers;
    ApplicationContext context =
            new AnnotationConfigApplicationContext("Telegram.Entities");
    FirstQuestion firstQuestion = context.getBean("firstQuestion", FirstQuestion.class);
    SecondQuestion secondQuestion = context.getBean("secondQuestion", SecondQuestion.class);
    ThirdQuestion thirdQuestion = context.getBean("thirdQuestion", ThirdQuestion.class);
    ForthQuestion forthQuestion = context.getBean("forthQuestion", ForthQuestion.class);
    FifthQuestion fifthQuestion = context.getBean("fifthQuestion", FifthQuestion.class);

    private final String BOTNAME = "mblinovbot";
    private final String BOTTOKEN = "1676436779:AAGtk2Yrc9twvO6yv30BNAz0z8ibyMEb6XI";

    @Override
    public String getBotToken() {
        return BOTTOKEN;
    }

    @Override
    public String getBotUsername() {
        return BOTNAME;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            if (update.getMessage().hasText()) {
                if (update.getMessage().getText().equalsIgnoreCase("begin")) {
                    try {
                        execute(firstQuestion.sendInlineKeyBoardMessage(update.getMessage().getChatId()));
                        if (update.hasCallbackQuery()) {
                            CallbackQuery callbackQuery = update.getCallbackQuery();
                            if (callbackQuery.getData().equals("Ответ верный")) {
                                execute(secondQuestion.sendInlineKeyBoardMessage(update.getMessage().getChatId()));
                            }
                        }
                        execute(secondQuestion.sendInlineKeyBoardMessage(update.getMessage().getChatId()));
                        execute(secondQuestion.sendInlineKeyBoardMessage(update.getMessage().getChatId()));
                        execute(thirdQuestion.sendInlineKeyBoardMessage(update.getMessage().getChatId()));
                        execute(forthQuestion.sendInlineKeyBoardMessage(update.getMessage().getChatId()));
                        execute(fifthQuestion.sendInlineKeyBoardMessage(update.getMessage().getChatId()));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if (update.hasCallbackQuery()) {
            try {
                execute(new SendMessage().setText(
                        update.getCallbackQuery().getData())
                        .setChatId(update.getCallbackQuery().getMessage().getChatId()));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }


   /* public void callBack (CallbackQuery buttonQuery) {
        if (buttonQuery.getData().equals("Ответ верный"))
             rightAnswers++;
    }

    public void analyzeAnswers (Update update) {
        if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            callBack(callbackQuery);
        }
    }

    public String resultOfTest () {
        if (rightAnswers>=4) {
            return "Тест пройден успешно";
        } else return "Тест не пройден";
    }*/

}
