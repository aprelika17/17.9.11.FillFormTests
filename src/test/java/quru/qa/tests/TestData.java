package quru.qa.tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    static Faker faker = new Faker(new Locale("en"));

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            month = faker.options().option("January", "February", "March", "April", "May", "June", "July",
                    "August", "September", "October", "November", "December"),
            year = String.valueOf(faker.number().numberBetween(1930, 2015)),
            day = String.valueOf(faker.number().numberBetween(1, 29)),
            subject = faker.options().option("English", "Commerce", "Economics", "Math"),
            hobby = faker.options().option("Sports", "Reading", "Music"),
            currentAddress = faker.address().fullAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryanna", "Rajasthan"),
            city = setRandomCity(state),
            happyText = "Thanks for submitting the form";

    public static String setRandomCity(String state) {
        if (state.equals("NCR")) return faker.options().option("Delhi", "Gurgaon", "Noida");
        else if (state.equals("Uttar Pradesh")) return faker.options().option("Agra", "Lucknow", "Merrut");
        else if (state.equals("Haryana")) return faker.options().option("Karnal", "Panipat");
        else if (state.equals("Rajasthan")) return faker.options().option("Jaipur", "Jaiselmer");
        return "";
    }


}
