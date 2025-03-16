package com.utilities;

import com.github.javafaker.Faker;

public class FakerDataCreator {

    Faker faker = new Faker();

    public String sentenceFromFaker() {
        return faker.lorem().sentence(5);
    }

    public String wordFromFaker() {
        return faker.lorem().word();
    }

}
