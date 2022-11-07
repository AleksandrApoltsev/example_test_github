package ru.apoltsev;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ExampleGitHubTest {
    @Test
    public void exampleTest() {
        open("https://github.com/");
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        $$(".repo-list li").first().$("a").click();
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("[data-filterable-for=wiki-pages-filter]").shouldHave(text("SoftAssertions"));
        $$(".wiki-more-pages").findBy(visible).shouldBe(text("SoftAssertions")).click();
        $("#wiki-body").$(byText("3. Using JUnit5 extend test class:"))
                .shouldHave(text("3. Using JUnit5 extend test class:"));
    }
}
