package quru.qa.tests;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class TestData {

    static Faker faker = new Faker(new Locale("en"));

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String gender = faker.options().option("Male", "Female", "Other");
    String userNumber = faker.phoneNumber().subscriberNumber(10);
    String month = faker.options().option("January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November",  "December");
    String year = String.valueOf(faker.number().numberBetween(1930,2015));
    String day = String.valueOf(faker.number().numberBetween(1,29));
    String subject = faker.options().option("English", "Commerce", "Economics", "Math");
    String hobby = faker.options().option("Sports", "Reading", "Music");
    String currentAddress = faker.address().fullAddress();
    String state = faker.options().option("NCR", "Uttar Pradesh", "Haryanna", "Rajasthan");
    String city = setRandomCity(state);
    String happyText = "Thanks for submitting the form";

    public static String setRandomCity(String state) {
        if (state.equals("NCR")) return faker.options().option("Delhi", "Gurgaon", "Noida");
        else if (state.equals("Uttar Pradesh")) return faker.options().option("Agra", "Lucknow", "Merrut");
        else if (state.equals("Haryana")) return faker.options().option("Karnal", "Panipat");
        else if (state.equals("Rajasthan")) return faker.options().option("Jaipur", "Jaiselmer");
        return "";
    }


}
