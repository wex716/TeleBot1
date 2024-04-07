package org.example.service.logic;

import org.example.statemachine.TransmittedData;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class StartLogic {

    public SendMessage processWaitingCommandStart(String textFromUser, TransmittedData transmittedData) throws Exception {
        SendMessage messageToUser = new SendMessage();
        messageToUser.setChatId(transmittedData.getChatId());

        if (textFromUser.equals("/start") == false) {
            messageToUser.setText("Ошибка запуска бота. Для старта пожалуйста введите /start");
            return messageToUser;
        }


        return messageToUser;
    }
}