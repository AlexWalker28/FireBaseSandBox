package com.example.alexwalker.firebasesandbox;

public class AMessage extends  Object{

    private String textMessage;
    private String userName;
    private String userId;

    public AMessage(String textMessage, String userName, String userId ){
         this.textMessage = textMessage;
         this.userName = userName;
         this.userId = userId;
    }

    public AMessage() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

