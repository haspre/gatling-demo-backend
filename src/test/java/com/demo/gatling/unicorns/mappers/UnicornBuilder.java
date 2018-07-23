package com.demo.gatling.unicorns.mappers;

import static com.demo.gatling.unicorns.mappers.Gender.female;

public class UnicornBuilder {

    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;

    public static UnicornBuilder newUnicornBuilder() {
        return new UnicornBuilder();
    }

    public static UnicornBuilder anyFemaleUnicornBuilder() {
        return newUnicornBuilder()
                .withFirstName("rainbow")
                .withLastName("dash")
                .withAge(133)
                .withGender(female);
    }

    public static Unicorn anyFemaleUnicorn() {
        return anyFemaleUnicornBuilder()
                .build();
    }

    public UnicornBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UnicornBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UnicornBuilder withAge(int age) {
        this.age = age;
        return this;
    }

    public UnicornBuilder withGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Unicorn build() {
        Unicorn unicorn = new Unicorn();
        unicorn.setFirstName(firstName);
        unicorn.setLastName(lastName);
        unicorn.setAge(age);
        unicorn.setGender(gender);
        return unicorn;
    }
}
