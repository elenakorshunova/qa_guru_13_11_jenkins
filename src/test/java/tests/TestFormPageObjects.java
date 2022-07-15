package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TestFormPageObjects extends TestBase {

    @Test
    @DisplayName("Successful filling Student Registration Form")
    void successfulTest() {

        String firstName = "Elena";
        String lastName = "Korshunova";
        String email = "elena@gmail.com";
        String phoneNumber = "1234567890";
        String gender = "Female";
        String month = "October";
        String year = "1989";
        String day = "17";
        String fromSubject = "Computer Science";
        String hobby = "Music";
        String currentAddress = "My current address";
        String state = "Rajasthan";
        String city = "Jaipur";
        String url = "picture.png";

        step("Open registration form", () -> {
            open("/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
            executeJavaScript("$('footer').remove()");
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('#RightSide_Advertisement').remove()");
        });

        step("Fill form", () -> {
            registrationFormPage.openPage()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .chooseGender(gender)
                    .setNumber(phoneNumber)
                    .setBirthDate(day, month, year)
                    .chooseSubject(fromSubject)
                    .chooseHobbies(hobby)
                    .uploadPicture(url)
                    .setAddress(currentAddress)
                    .chooseState(state)
                    .chooseCity(city)
                    .pressSubmit();
        });

        step("Check form results", () -> {
            registrationFormPage.checkOpenedResultForm()
                    .checkResult("Student Name", firstName + " " + lastName)
                    .checkResult("Student Email", email)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", phoneNumber)
                    .checkResult("Date of Birth", day + " " + month + "," + year)
                    .checkResult("Subjects", fromSubject)
                    .checkResult("Hobbies", hobby)
                    .checkResult("Picture", "picture.png")
                    .checkResult("Address", currentAddress)
                    .checkResult("State and City", state + " " + city);
        });
    }
}