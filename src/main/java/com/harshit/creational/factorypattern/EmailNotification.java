package com.harshit.creational.factorypattern;

import org.springframework.stereotype.Component;

@Component("email")
public class EmailNotification implements Notification{
    @Override
    public void sendNotification() {
        System.out.println("Notification sent via Email");
    }
}
