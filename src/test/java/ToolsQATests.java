
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.time.Duration;
import java.time.LocalTime;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class ToolsQATests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1366x768";
        Configuration.pageLoadTimeout = 50000;

    }

    @Test
    void formTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#close-fixedban').remove()");


        $("#firstName").setValue("Oleg");
        $("#lastName").setValue("Belov");
        $("#userEmail").setValue("test@g.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("8999888776");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1980");
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__day--019").click();
        $("#subjectsInput").setValue("Commerce").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/test.jpg");
        $("#currentAddress").setValue("Test");
        $("#submit").scrollTo();
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#react-select-4-input").setValue("pa").pressEnter();
        $("#submit").click();

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Oleg Belov"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("test@g.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8999888776"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("19 July,1980"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Commerce"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports, Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("test.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Test"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Haryana Panipat"));
        $("#closeLargeModal").click();

    }


    @AfterAll
    static void endTest() {
        Configuration.holdBrowserOpen = true;
    }
}