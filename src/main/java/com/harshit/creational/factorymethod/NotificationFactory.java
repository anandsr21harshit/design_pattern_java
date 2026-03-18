package com.harshit.creational.factorymethod;

public abstract class NotificationFactory {

    // factory method
    public abstract Notification createNotification();

    public void sendNotification(String message){
        Notification notification = createNotification();
        notification.send(message);
    }
}
