package com.harshit.creationalDesignPattern.factoryPattern;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private NotificationFactory notificationFactory;
    public TestController(NotificationFactory notificationFactory) {
        this.notificationFactory = notificationFactory;
    }

    @GetMapping("/send/{type}")
    public ResponseEntity<String> sendNotification(@PathVariable String type){
        try {
            notificationFactory.send(type);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Notification Sent", HttpStatus.OK);
    }
}
