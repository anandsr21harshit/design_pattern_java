package com.harshit.creational.builderPattern;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class User {

    private  String firstName;        // required
    private  String lastName;         // required
    private  int age;                 // optional
    private  String email;            // optional
    private  String phone;            // optional
    private  String address;          // optional
    private  boolean isNewsletter;    // optional
    private  String preferredLanguage;// optional

}
