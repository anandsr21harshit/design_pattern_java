package com.harshit.creational.builder;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


public class User {

    // All fields are final for Immutability
    private final String firstName;        // required
    private final String lastName;         // required
    private final int age;                 // optional
    private final String email;            // optional
    private final String phone;            // optional
    private final String address;          // optional
    private final boolean isNewsletter;    // optional
    private final String preferredLanguage;// optional

    // Private constructor: Maps the Builder values to the User object
    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.email = builder.email;
        this.phone = builder.phone;
        this.address = builder.address;
        this.isNewsletter = builder.isNewsletter;
        this.preferredLanguage = builder.preferredLanguage;
    }

    // Static Inner Class: The Builder
    public static class UserBuilder {
        // Same fields as the parent class

        // required fields are defined as final in static builder class as well
        private final String firstName;
        private final String lastName;
        private int age;
        private String email;
        private String phone;
        private String address;
        private boolean isNewsletter;
        private String preferredLanguage;

        public UserBuilder(String firstName,String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }

        // 2. Fluent methods for OPTIONAL fields
        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public UserBuilder isNewsletter(boolean isNewsletter) {
            this.isNewsletter = isNewsletter;
            return this;
        }

        public UserBuilder preferredLanguage(String preferredLanguage) {
            this.preferredLanguage = preferredLanguage;
            return this;
        }

        // 3. The build() method
        public User build() {
            return new User(this);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public boolean isNewsletter() {
        return isNewsletter;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    @Override
    public String toString() {
        // Using StringBuilder for performance (avoids creating multiple String objects in memory)
        StringBuilder sb = new StringBuilder("User{");

        // Mandatory fields - always appended
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');

        // Optional fields - only appended if they contain data
        if (age > 0) {
            sb.append(", age=").append(age);
        }

        if (email != null && !email.isEmpty()) {
            sb.append(", email='").append(email).append('\'');
        }

        if (phone != null && !phone.isEmpty()) {
            sb.append(", phone='").append(phone).append('\'');
        }

        if (address != null && !address.isEmpty()) {
            sb.append(", address='").append(address).append('\'');
        }

        // For booleans, we might only want to show it if it's true (e.g., opted into newsletter)
        if (isNewsletter) {
            sb.append(", isNewsletter=").append(isNewsletter);
        }

        if (preferredLanguage != null && !preferredLanguage.isEmpty()) {
            sb.append(", preferredLanguage='").append(preferredLanguage).append('\'');
        }

        sb.append('}');
        return sb.toString();
    }
}
