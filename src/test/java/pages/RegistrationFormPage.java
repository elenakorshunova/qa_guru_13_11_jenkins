package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {

    public CalendarComponent calendarComponent = new CalendarComponent();
    public ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderRadioButton = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            birthDayInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbyCheckbox = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateSelect = $("#stateCity-wrapper"),
            citySelect = $("#stateCity-wrapper");


    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#RightSide_Advertisement').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationFormPage chooseGender(String value) {
        genderRadioButton.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setNumber(String value) {
        numberInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        birthDayInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage chooseSubject(String value) {
        subjectInput.sendKeys(value);
        subjectInput.pressEnter();
        return this;
    }

    public RegistrationFormPage chooseHobbies(String value) {
        hobbyCheckbox.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }


    public RegistrationFormPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationFormPage chooseState(String value) {
        $("#state").click();
        stateSelect.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage chooseCity(String value) {
        $("#city").click();
        citySelect.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage pressSubmit() {
        $("#submit").click();
        return this;
    }

    public RegistrationFormPage checkOpenedResultForm() {
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultsTableComponent.checkResult(key, value);
        return this;
    }
}