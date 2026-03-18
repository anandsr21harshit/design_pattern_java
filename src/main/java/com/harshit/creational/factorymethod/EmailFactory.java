package com.harshit.creational.factorymethod;

public class EmailFactory extends NotificationFactory{
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
