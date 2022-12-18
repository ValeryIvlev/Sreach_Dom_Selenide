package org.zayac;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    @Test
    void selenideTest() {
        open("https://github.com/selenide/selenide");
        $("[data-tab-item=i5wiki-tab]").click();
        $("[data-filterable-type=substring] .js-wiki-more-pages-link").click();
        $("[data-filterable-type=substring]").shouldHave(text("SoftAssertions"));
        $(linkText("SoftAssertions")).click();
        $(".markdown-body").find(byText("3. Using JUnit5 extend test class:"))
                .sibling(0).shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                        "class Tests {\n" +
                        "  @Test\n" +
                        "  void test() {\n" +
                        "    Configuration.assertionMode = SOFT;\n" +
                        "    open(\"page.html\");\n" +
                        "\n" +
                        "    $(\"#first\").should(visible).click();\n" +
                        "    $(\"#second\").should(visible).click();\n" +
                        "  }\n" +
                        "}"));
        sleep(5000);
    }
}
