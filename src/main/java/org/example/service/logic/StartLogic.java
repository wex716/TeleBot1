package org.example.service.logic;

import org.example.statemachine.State;
import org.example.statemachine.TransmittedData;
import org.example.util.buttons.InlineButtonsStorage;
import org.example.util.buttons.InlineKeyboardsStorage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class StartLogic {

    public SendMessage processWaitingCommandStart(String textFromUser, TransmittedData transmittedData) throws Exception {
        SendMessage messageToUser = new SendMessage();
        messageToUser.setChatId(transmittedData.getChatId());

        if (textFromUser.equals("/start") == false) {
            messageToUser.setText("Ошибка запуска бота. Для старта пожалуйста введите /start");
            return messageToUser;
        }
       messageToUser.setText("Выберите действие");
       messageToUser.setReplyMarkup(InlineKeyboardsStorage.getShowAddAnswerKeyboard());

       transmittedData.setState(State.WaitingToAddAnswer);
        return messageToUser;
    }

    public SendMessage processWaitingToAddAnswer(String textFromUser, TransmittedData transmittedData) throws Exception {

        SendMessage messageToUser = new SendMessage();
        messageToUser.setChatId(transmittedData.getChatId());

        if (textFromUser.equals(InlineButtonsStorage.ShowAllRequest.getCallBackData()) == false && textFromUser.equals(InlineButtonsStorage.ApproveAddAnswer.getCallBackData()) == false) {
            messageToUser.setText("Ошибка. Нажмите на кнопку.");
            return messageToUser;
        }

    }
}