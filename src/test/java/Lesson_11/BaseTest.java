package Lesson_11;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayInputStream;
import java.time.Duration;

    public class BaseTest {

        protected WebDriver driver;
        protected final String BASE_URL = "https://www.mts.by";

        @BeforeMethod
        public void setUp() {
            // Явно указываем версию драйвера
            WebDriverManager.chromedriver().driverVersion("119.0.6045.105").setup();
            Allure.step("Инициализация WebDriver и открытие сайта");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");

            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

            driver.get(BASE_URL);
            Allure.step("Сайт " + BASE_URL + " успешно открыт");
        }

        @AfterMethod
        public void tearDown(ITestResult result) {
            if (driver != null) {
                // Делаем скриншот при падении теста
                if (result.getStatus() == ITestResult.FAILURE) {
                    Allure.step("Тест упал, делаем скриншот");
                    takeScreenshot("FAILED_" + result.getName());
                }
                driver.quit();
            }
        }

        protected void takeScreenshot(String screenshotName) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment(screenshotName, new ByteArrayInputStream(screenshot));
            } catch (Exception e) {
                Allure.step("Не удалось сделать скриншот: " + e.getMessage());
            }
        }
    }
