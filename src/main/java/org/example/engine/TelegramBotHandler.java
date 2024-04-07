package org.example.engine;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegramBotHandler extends TelegramLongPollingBot {

    String botUserName = "PrompterBot_bot";
    String botTocen = "7006512662:AAEgxr7tWKLn8mVj3MZA4OxSS6FHiI4RLz0";


    @Override
    public void onUpdateReceived(Update update) {

    }

    @Override
    public String getBotUsername() {
        return botUserName;
    }

    public String getBotTocen() {
        return botTocen;
    }
}
