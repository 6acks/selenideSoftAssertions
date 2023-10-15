package gmail.backswork;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class githubSelenideWikiHasJUnit5Code {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void selenideWikiHasCodeForJUnit5(){
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $(".js-wiki-more-pages-link").click();
        $("[data-filterable-for=wiki-pages-filter]").shouldHave(text("SoftAssertions"));
        $("[data-filterable-for=wiki-pages-filter]").$(byText("SoftAssertions")).click();
        $("#wiki-wrapper").shouldHave(text("JUnit5 extend test class"));
        $("#wiki-wrapper").shouldHave(text(
                "@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "@Test\n" +
                "void test() {\n" +
                "Configuration.assertionMode = SOFT;\n" +
                "open(\"page.html\");\n" +
                "$(\"#first\").should(visible).click();\n" +
                "$(\"#second\").should(visible).click();\n" +
                "}\n" +
                "}"
        ));

    }


}
