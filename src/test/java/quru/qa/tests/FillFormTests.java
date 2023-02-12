package quru.qa.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Tag("remote")
public class FillFormTests extends TestBase {

    @Test
    void fillFormSuccess() {
        TestData testData = new TestData();

        step("Открываем форму для тестирования", () -> {
            registrationPage.openPage();
        });

        step("Заполняем данными форму для тестирования", () -> {
            registrationPage.setFirstName(testData.firstName)
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
        });

        step("Проверка результата", () -> {
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
        });

        step("Закрыть модальное окно с проверкой", () -> {
            registrationPage.pressCloseModal();
        });
    }
}