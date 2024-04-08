package org.example.engine;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBotHandler extends TelegramLongPollingBot {

    String botUserName = "PrompterBot_bot";
    String botTocen = "7006512662:AAEgxr7tWKLn8mVj3MZA4OxSS6FHiI4RLz0";


    @Override
    public void onUpdateReceived(Update update) {
        long chatId = 0;
        int messageId = 0;
        String textFromUser = "";

        try {
            if (update.hasMessage()) {
                chatId = update.getMessage().getChatId();
                messageId = update.getMessage().getMessageId();
                textFromUser = update.getMessage().getText();
            } else if (update.hasCallbackQuery()) {
                chatId = update.getCallbackQuery().getMessage().getChatId();
                messageId = update.getCallbackQuery().getMessage().getMessageId();
                textFromUser = update.getCallbackQuery().getData();
            }

            SendMessage messageToUser = сhatsRouter.route(chatId, textFromUser);

            execute(messageToUser);
        } catch (Exception e) {
            e.printStackTrace();

            DeleteMessage deleteMessageToUser = new DeleteMessage();
            deleteMessageToUser.setChatId(chatId);
            deleteMessageToUser.setMessageId(messageId);

            try {
                execute(deleteMessageToUser);
            } catch (TelegramApiException ee) {
                ee.printStackTrace();
            }
        }

    }

    @Override
    public String getBotUsername() {
        return botUserName;
    }

    public String getBotTocen() {
        return botTocen;
    }
}
