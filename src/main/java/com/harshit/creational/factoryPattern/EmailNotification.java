package com.harshit.creationalDesignPattern.factoryPattern;

import org.springframework.stereotype.Component;

@Component("email")
public class EmailNotification implements Notification{
    @Override
    public void sendNotification() {
        System.out.println("Notification sent via Email");
    }
}
