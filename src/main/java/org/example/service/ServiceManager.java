package org.example.service;

import org.example.service.logic.StartLogic;
import org.example.statemachine.State;

import java.util.HashMap;
import java.util.Map;

public class ServiceManager {

    private Map<String, Service> methods;
    private StartLogic startLogic;

    public ServiceManager() {

        methods = new HashMap<>();

        startLogic = new StartLogic();

        methods.put(State.WaitingStart, startLogic::processWaitingCommandStart);

        methods.put(State.WaitingStart, startLogic::processWaitingCommandStart);
    }
}

