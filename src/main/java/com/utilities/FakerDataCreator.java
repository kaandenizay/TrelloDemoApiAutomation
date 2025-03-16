package com.utilities;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FakerDataCreator {

    Faker faker = new Faker();

    public String sentenceFromFaker() {
        return faker.lorem().sentence(5);
    }

    public String wordFromFaker() {
        return faker.lorem().word();
    }

}
