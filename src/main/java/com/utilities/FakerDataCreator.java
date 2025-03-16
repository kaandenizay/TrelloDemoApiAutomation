package com.utilities;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FakerDataCreator {

    Faker faker = new Faker();

    public String niptNumberForCustomer() {
        return faker.bothify("?########?");
    }

    public String niptNumberForForeign() {
        return faker.bothify("?????####");
    }
    public String billingAccountNumber() {
        return "BEN" + faker.bothify("######");
    }

    public String firstNameFromFaker() {
        return faker.name().firstName().replaceAll("[',&_-]", "");
    }
    public String fullNameFromFaker() {
        return faker.name().fullName();
    }
    public String lastNameFromFaker() {
        return faker.name().lastName().replaceAll("[',&_-]", "").concat(" AUTOMATION");
    }

    public String organizationNameFromFaker() {
        String[] companyName = faker.company().name().replaceAll("[',&_-]", "").split(" ");
        return companyName[0] + faker.bothify("???").concat(" AUTOMATION");
    }

    public String emailFromFaker() {
        return faker.bothify("?????@GMAIL.COM");
    }

    public String phoneFromFaker() {
        return faker.bothify("#########");
    }

    public String sentenceFromFaker() {
        return faker.lorem().sentence(5);
    }

    public String wordFromFaker() {
        return faker.lorem().word();
    }


    public String addressFromFaker(){
        return faker.address().streetName();
    }



    public String customizedString(String pattern) {
        return faker.bothify(pattern);
    }
}
