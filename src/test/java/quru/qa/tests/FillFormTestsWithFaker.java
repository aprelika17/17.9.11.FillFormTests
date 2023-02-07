package quru.qa.tests;

import org.junit.jupiter.api.Test;

public class FillFormTestsWithFaker extends TestBase {

    @Test
    void fillFormSuccess() {
        TestData testData = new TestData();

        //Старт теста
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setUserGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setUserBirthDate(testData.day, testData.month, testData.year)
                .setSubject(testData.subject)
                .setUserHobby(testData.hobby)
                .uploadFile()
                .setAddress(testData.currentAddress)
                .setStateAndCity(testData.state, testData.city)
                .pressSubmit();

        //Проверки
        registrationPage.verifyResultsModalAppears(testData.happyText)
                .verifyResult("Student Name", (testData.firstName + " " + testData.lastName))
                .verifyResult("Student Email", testData.userEmail)
                .verifyResult("Gender", testData.gender)
                .verifyResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                .verifyResult("Subjects", testData.subject)
                .verifyResult("Hobbies", testData.hobby)
                .verifyResult("Picture", "File.jpg")
                .verifyResult("Address", testData.currentAddress)
                .verifyResult("State and City", (testData.state + " " + testData.city));

        //Закрыть модалку
        registrationPage.pressCloseModal();
    }
}
