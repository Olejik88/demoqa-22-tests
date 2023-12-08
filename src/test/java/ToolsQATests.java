
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.files.DownloadActions.click;

public class ToolsQATests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1366x768";
    }

    @Test
    void formTest() {

        open("/automation-practice-form");

        $("#firstName").setValue("Oleg");
        $("#lastName").setValue("Belov");
        $("#userEmail").setValue("test@g.com");
        //$("#genterWrapper").$(byText("Female")).click();
        $(byText("Male")).click();
        $("#userNumber").setValue("+79998887766");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(byValue("1980")).click();
        $(".react-datepicker__month-select").click();
        $(byValue("7")).click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__day--019").click();
        $(".subjects-auto-complete__value-container").click();

    }


    @AfterAll
    static void endTest() {
        Configuration.holdBrowserOpen = true;
    }
}