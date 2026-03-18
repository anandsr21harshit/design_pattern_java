package com.harshit.creational.factorymethod;

public class FactoryMethodDemo {
    public static void main(String[] args) {
        NotificationFactory emailFactory = new EmailFactory();
        emailFactory.sendNotification("Hello via Factory method");
    }
}
