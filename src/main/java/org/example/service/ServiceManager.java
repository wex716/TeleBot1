
package org.example.service;

import org.example.service.logic.StartLogic;
import org.example.statemachine.State;
import org.example.statemachine.TransmittedData;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.HashMap;
import java.util.Map;

public class ServiceManager {

    private Map<String, Service> methods;
    private StartLogic startLogic;

    public ServiceManager() {

        methods = new HashMap<>();

        startLogic = new StartLogic();

        methods.put(State.WaitingStart, startLogic::processWaitingCommandStart);
//        methods.put(State.WaitingInstructionOfKnowledge, startLogic::processWaitingInstructionOfKnowledge);
    }








    public SendMessage callLogicMethod(String textFromUser, TransmittedData transmittedData) throws Exception {
        String state = transmittedData.getState();
        return methods.get(state).process(textFromUser, transmittedData);
    }

}



