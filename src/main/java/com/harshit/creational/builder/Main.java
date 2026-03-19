package com.harshit.creational.builder;

public class Main {

    public static void main(String[] args) {
        User user = new User.UserBuilder("Harshit","Anand")
                .age(5)
                .isNewsletter(false)
                .build();

        System.out.println(user);

    }
}
