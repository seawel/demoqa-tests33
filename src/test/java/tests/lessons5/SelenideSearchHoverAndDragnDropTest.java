package tests.lessons5;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.commands.ShouldHave;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class SelenideSearchHoverAndDragnDropTest {


        @BeforeAll
        static void setUp() {
            Configuration.browserSize = "1920x1080";
            Configuration.pageLoadStrategy = "eager";
            //Configuration.holdBrowserOpen = true;
        }

        @Test
        void enableAIPagesTest() {
            open ("https://github.com");

            $("nav.HeaderMenu-nav").$(withText("Solutions")).hover();
            $("[aria-labelledby=solutions-by-company-size-heading]").$(withText("Enterprises")).click();
        }

        @Test
    void dragNDropTest () {
            open("https://the-internet.herokuapp.com/drag_and_drop");
            $("#column-a").shouldHave(text("A"));
            $("#column-a").hover();
            $("#column-a").dragAndDrop(DragAndDropOptions.to($("#column-b")));
            $("#column-a").shouldHave(text("B"));
            $("#column-b").shouldHave(text("A"));

        }
}







