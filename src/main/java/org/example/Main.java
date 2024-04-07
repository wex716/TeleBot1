package org.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            TelegramBotHandler botHandler = new TelegramBotHandler();
            botsApi.registerBot(botHandler);
            System.out.println("Bro is running...");
        } catch (TelegramApiException e) {
            System.out.println("Ошибка. " + e);
        }
    }
}