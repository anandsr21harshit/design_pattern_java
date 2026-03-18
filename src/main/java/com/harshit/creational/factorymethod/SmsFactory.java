package com.harshit.creational.factorymethod;

public class SmsFactory extends NotificationFactory{
    @Override
    public Notification createNotification() {
        return new SmsNotification();
    }
}
