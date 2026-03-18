package com.harshit.creational.factoryPattern;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class NotificationFactory {

    public Notification createNotification(String channel){
        if(channel == null || channel.isEmpty()){
            return null;
        }

        return switch (channel.toUpperCase()){
            case "SMS" -> new SMSNotification();
            case "EMAIL" -> new EmailNotification();
            default -> throw new IllegalArgumentException("Unknown channel " + channel);
        };
    }
}
