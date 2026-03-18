package com.harshit.creational.factorypattern;

import org.springframework.stereotype.Component;

@Component("sms")
public class SMSNotification implements Notification{
    @Override
    public void sendNotification() {
        System.out.println("Notification sent via SMS");
    }
}
