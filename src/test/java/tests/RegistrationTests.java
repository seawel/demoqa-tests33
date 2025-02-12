package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class RegistrationTests {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
       // Configuration. holdBrowserOpen = true;
    }

    @Test

    void fullRegistrationFormTest() {

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Joe");
        $("#lastName").setValue("Jonson");
        $("#userEmail").setValue("jonson@test.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("2221777567");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1999");
        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)").findBy(Condition.text("8")).click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("cat.jpeg");
        $("#currentAddress").setValue("Russia,630777,Moscow,ul.Pobedy,d.19,kv.6");
        $("#state").click();
        $("#state").$(byText("Haryana")).click();
        $("#city").click();
        $("#city").$(byText("Karnal")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(Condition.text("Joe Jonson"));

        $(".table-responsive").shouldHave(Condition.text("jonson@test.ru"));
        $(".table-responsive").shouldHave(Condition.text("Male"));
        $(".table-responsive").shouldHave(Condition.text("8 September,1999"));
        $(".table-responsive").shouldHave(Condition.text("2221777567"));
        $(".table-responsive").shouldHave(Condition.text("Math"));
        $(".table-responsive").shouldHave(Condition.text("Reading"));
        $(".table-responsive").shouldHave(Condition.text("cat.jpeg"));
        $(".table-responsive").shouldHave(Condition.text("Russia,630777,Moscow,ul.Pobedy,d.19,kv.6"));
        $(".table-responsive").shouldHave(Condition.text("Haryana Karnal"));



              // (Condition.text("jonson@test.ru")),
               // (Condition.text("jonson@test.ru")),
              //  (Condition.text("Male")),
              //  (Condition.text("8 September,1999")),
              //  (Condition.text("2221777567")),
             //   (Condition.text("Math")),
               // (Condition.text("Reading")),
            //    (Condition.text("cat.jpeg")),
               // (Condition.text("Russia,630777,Moscow,ul.Pobedy,d.19,kv.6")),
               // (Condition.text("Haryana Karnal");
        $(".modal-footer").$(byText("Close")).click();

    }
}

