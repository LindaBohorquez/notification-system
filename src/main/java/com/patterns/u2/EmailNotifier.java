package com.patterns.u2;

public class EmailNotifier implements Notifier{
    public String channel() { return "SMS"; }
    public void send(String recipient, String message) {
        NotificationLogger.INSTANCE.log(channel(), recipient, message);
    }
}

