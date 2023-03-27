package de.rieckpil.blog.exercise12;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.testcontainers.Testcontainers;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.containers.wait.strategy.LogMessageWaitStrategy;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.screenshot;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class AdvancedSelenideTest {

  private static final Logger LOG = LoggerFactory.getLogger(AdvancedSelenideTest.class);

  static BrowserWebDriverContainer<?> webDriverContainer =
    new BrowserWebDriverContainer<>()
      .withLogConsumer(new Slf4jLogConsumer(LOG))
      .withCapabilities(new ChromeOptions());

  @BeforeAll
  static void beforeAll(@Autowired Environment environment) {
    Integer port = environment.getProperty("local.server.port", Integer.class);
    Testcontainers.exposeHostPorts(port);

    webDriverContainer.setWaitStrategy(new LogMessageWaitStrategy().withRegEx(".*(from DOWN to UP).*"));
    webDriverContainer.start();

    Configuration.baseUrl = String.format("http://host.testcontainers.internal:%d", port);
    Configuration.reportsFolder = "target/selenide-screenshots";
  }

  @AfterAll
  static void cleanUp() {
    WebDriverRunner.closeWebDriver();
  }

  @Test
  void shouldDisplayBook() {
    RemoteWebDriver remoteWebDriver = new RemoteWebDriver(webDriverContainer.getSeleniumAddress(), new ChromeOptions()
      .addArguments("--no-sandbox")
      .addArguments("--disable-dev-shm-usage"), false);

    remoteWebDriver
      .manage()
      .timeouts()
      .implicitlyWait(Duration.ofSeconds(60));

    WebDriverRunner.setWebDriver(remoteWebDriver);

    Selenide.open("/dashboard");

    assertEquals("Dashboard", Selenide.title());

    $(By.id("lname")).val("Mike");
    $(By.id("fname")).val("Duke");

    $(By.id("submit")).click();

    screenshot("advanced-selenide-test-post-submit");
  }
}
