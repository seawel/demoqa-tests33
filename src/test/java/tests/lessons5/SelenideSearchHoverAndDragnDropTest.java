package tests.lessons5;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.commands.ShouldHave;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class SelenideSearchHoverAndDragnDropTest {


        @BeforeAll
        static void setUp() {
            Configuration.baseUrl = "https://github.com";
            Configuration.browserSize = "1920x1080";
            Configuration.pageLoadStrategy = "eager";
        }

        @Test
        void enableAIPagesTest() {
            open("");

            $("nav.HeaderMenu-nav").$(withText("Solutions")).hover();
            $("[aria-labelledby=solutions-by-company-size-heading]").$(withText("Enterprises")).click();

        }
}


