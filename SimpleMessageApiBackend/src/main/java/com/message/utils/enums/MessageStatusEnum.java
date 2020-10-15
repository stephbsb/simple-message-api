package com.message.utils.enums;

public enum MessageStatusEnum {

    NEW("new"),
    READ("read"),
    RESPONDEND("responded");

    private final String messageStatus;

    MessageStatusEnum(String messageStatus) {
        this.messageStatus = messageStatus;
    }

    public String getMessageStatus() {
        return messageStatus;
    }


}
