package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class RegistrationTests {

    @BeforeAll
    static void beforAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration. holdBrowserOpen = true;


    }

    @Test
    void successfullRegistrtionTest() {
        String userName = "Alex";

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").setValue("userName");
        $("#lastName").setValue("Egorov");
        $("#userEmail").setValue("alex@egorov.com");
//        $("#gender-radio-1").click();                   // wrong
//        $("#gender-radio-1").parent().click(); // good  чтобы кликнуть поднялись к родителю
//        $(byText ("Other")).click(); // not very good  чтобы кликнуть по эелменту, но если на разных языках - придется править
        $( "#genterWrapper").$(byText("Other")).click(); //  best  (читаемый локатор)
//        $("label[#gender-radio-1"]).click(); // good  чтобы кликнуть поднялись к родителю


       $("#userNumber").setValue("1234567890");

        $(".react-datepicker__month").$(byText("15")).click();

        $("#.react-datepicker__month-select").selectOption("July");
//        $("#.react-datepicker__month-select").selectOption("July");
//        $(".react-datepicker__month-select").selectOption("July")// менее читаемо
        $("#.react-datepicker__year-select").selectOption("2008");

        $("#currentAddress").setValue("Some address 1");


        $("#submit").click();







        $("#output #name").shouldHave(text("Alex"));

        $("#output #currentAddress").shouldHave(text("some street 1"));
        $("#output #permanentAddress").shouldHave(text("Another street "));
    }
}

