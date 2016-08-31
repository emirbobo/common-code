package com.dci.intellij.dbn.common.message;

import java.util.ArrayList;
import java.util.List;

public class MessageBundle {
    private List<Message> infoMessages;
    private List<Message> warningMessages;
    private List<Message> errorMessages;

    public void addMessage(Message message) {
        switch (message.getType()) {
            case INFO: infoMessages = addMessage(message, infoMessages); break;
            case WARNING: warningMessages = addMessage(message, warningMessages); break;
            case ERROR: errorMessages = addMessage(message, errorMessages); break;
        }
    }

    public void addInfoMessage(String message) {
        addMessage(new Message(MessageType.INFO, message));
    }

    public void addWarningMessage(String message) {
        addMessage(new Message(MessageType.WARNING, message));
    }

    public void addErrorMessage(String message) {
        addMessage(new Message(MessageType.ERROR, message));
    }

    private static List<Message> addMessage(Message message, List<Message> list) {
        if (list == null) list = new ArrayList<Message>();
        if (!list.contains(message)) list.add(message);
        return list;
    }

    public List<Message> getInfoMessages() {
        return infoMessages;
    }

    public List<Message> getWarningMessages() {
        return warningMessages;
    }

    public List<Message> getErrorMessages() {
        return errorMessages;
    }

    public boolean hasErrors() {
        return errorMessages != null && errorMessages.size() > 0;
    }

    public boolean hasWarnings() {
        return warningMessages != null && warningMessages.size() > 0;
    }

}
