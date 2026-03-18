package com.harshit.creational.builder;

public class Main {

    public static void main(String[] args) {
        User user = new User.UserBuilder()
                .age(25)
                .firstName("Harshit")
                .lastName("Anand")
                .email("harshit.anand@delta.com")
                .build();

        System.out.println(user);
    }
}
