package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;


public class RegFormTest {

    Faker faker = new Faker();

    @BeforeAll
    static void ChromeSetUp () {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @AfterAll
    static void closeChrome (){
        WebDriverRunner.closeWindow();
    }


    @Test
    void fillFormTest () {
        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                fullName = format("%s %s", firstName, lastName),
                email = faker.internet().emailAddress(),
                userNumber = tests.RegFormRandomUtils.getPhoneNumber(10),
                gender = tests.RegFormRandomUtils.getGender(),
                subject = "Hindi",
                hobby = tests.RegFormRandomUtils.getHobby(),
                year = tests.RegFormRandomUtils.getRandomYear(1900,2100),
                day = tests.RegFormRandomUtils.getRandomDay(1,28),
                month = tests.RegFormRandomUtils.getRandomMonth(),
                birthday = format(day, month, year),
                address = faker.address().streetAddress(),
                state = "Uttar Pradesh",
                city = "Agra",
                stateCity = format("%s %s", state, city);

        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("document.querySelector(\"footer\").hidden = 'true';document.querySelector(\"#fixedban\").hidden = 'true'");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#userNumber").setValue(userNumber);
        $(byText(gender)).click();
        $("#dateOfBirthInput").click();
        $(" .react-datepicker__year-select").selectOption(year);
        $(" .react-datepicker__month-select").selectOption(month);
        $(byText(day)).click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath("image.jpg");
        $("#currentAddress").setValue(address);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();

        $(" .table-responsive").$(byText("Student Name"))
                .parent().shouldHave(text(fullName));
        $(" .table-responsive").$(byText("Student Email"))
                .parent().shouldHave(text(email));
        $(" .table-responsive").$(byText("Gender"))
                .parent().shouldHave(text(gender));
        $(" .table-responsive").$(byText("Mobile"))
                .parent().shouldHave(text(userNumber));
        $(" .table-responsive").$(byText("Date of Birth"))
                .parent().shouldHave(text(birthday));
        $(" .table-responsive").$(byText("Subjects"))
                .parent().shouldHave(text(subject));
        $(" .table-responsive").$(byText("Hobbies"))
                .parent().shouldHave(text(hobby));
        $(" .table-responsive").$(byText("Picture"))
                .parent().shouldHave(text("image.jpg"));
        $(" .table-responsive").$(byText("Address"))
                .parent().shouldHave(text(address));
        $(" .table-responsive").$(byText("State and City"))
                .parent().shouldHave(text(stateCity));
    }
}

