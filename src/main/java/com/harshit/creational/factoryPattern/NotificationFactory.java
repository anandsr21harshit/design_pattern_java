package com.harshit.creationalDesignPattern.factoryPattern;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class NotificationFactory {

    private final Map<String,Notification> notificationMap;
    public NotificationFactory(Map<String, Notification> notificationMap) {
        this.notificationMap = notificationMap;
    }

    public void send(String notifType){
        Notification notification = notificationMap.get(notifType.toLowerCase());

        if(notification == null) throw new IllegalArgumentException(notifType + " does not exist");
        notification.sendNotification();
    }
}
