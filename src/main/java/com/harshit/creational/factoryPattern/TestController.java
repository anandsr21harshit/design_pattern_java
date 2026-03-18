package com.harshit.creational.factoryPattern;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final NotificationFactory notificationFactory;
    public TestController(NotificationFactory notificationFactory) {
        this.notificationFactory = notificationFactory;
    }

    @GetMapping("/send/{type}")
    public ResponseEntity<String> sendNotification(@PathVariable String type){
        try {
            Notification notif = notificationFactory.createNotification(type);
            notif.sendNotification();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Notification Sent", HttpStatus.OK);
    }
}
