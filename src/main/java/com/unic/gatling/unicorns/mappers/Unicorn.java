package com.unic.gatling.unicorns.mappers;

public class Unicorn {

    public long id;
    public String firstName;
    public String lastName;
    public int age;
    public Gender gender;

    public long getId() {
        return id;
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

    public Gender getGender() {
        return gender;
    }
}
