package de.rieckpil.blog.exercise12;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.screenshot;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BasicSelenideTest {

  @BeforeAll
  static void configureChromeDriver(@Autowired Environment environment) {

    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments(
      "--no-sandbox",
      "--disable-dev-shm-usage",
      "--headless",
      "--disable-gpu",
      "--disable-extensions");

    Configuration.browserCapabilities = chromeOptions;
    Configuration.reportsFolder = "target/selenide-screenshots";

    Integer port = environment.getProperty("local.server.port", Integer.class);
    Configuration.baseUrl = "http://localhost:" + port;
  }

  @AfterAll
  static void cleanUp() {
    WebDriverRunner.closeWebDriver();
  }

  @Test
  void shouldAccessDashboardAndSubmitForm() {
    Selenide.open("/dashboard");

    assertEquals("Dashboard", Selenide.title());

    $(By.id("lname")).val("Mike");
    $(By.id("fname")).val("Duke");

    $(By.id("submit")).click();

    screenshot("basic-selenide-test-post-submit");
  }
}
