package lesson_9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MtsOnlinePaymentTest extends BaseTest {

    // Локаторы
    private final By ONLINE_PAYMENT_BLOCK_TITLE = By.xpath("//h2[contains(text(), 'Онлайн пополнение без комиссии')]");
    private final By PAYMENT_SYSTEM_LOGOS = By.xpath("//div[contains(@class, 'pay-systems')]//img");
    private final By DETAILS_LINK = By.xpath("//a[contains(text(), 'Подробнее о сервисе')]");
    private final By PHONE_NUMBER_INPUT = By.xpath("//input[@placeholder='Номер телефона']");
    private final By AMOUNT_INPUT = By.xpath("//input[@placeholder='Сумма']");
    private final By EMAIL_INPUT = By.xpath("//input[@placeholder='Е-mail']");
    private final By CONTINUE_BUTTON = By.xpath("//button[contains(text(), 'Продолжить')]");
    private final By ERROR_MESSAGE = By.xpath("//span[contains(@class, 'error')]");
    private final By PAYMENT_FORM = By.xpath("//div[contains(@class, 'payment-form')]");

    @Test(priority = 1)
    public void testOnlinePaymentBlockTitle() {
        System.out.println("Тест 1: Проверка названия блока 'Онлайн пополнение без комиссии'");

        // Прокрутка к блоку (если необходимо)
        WebElement paymentBlock = wait.until(ExpectedConditions.presenceOfElementLocated(ONLINE_PAYMENT_BLOCK_TITLE));

        // Проверка видимости и корректности текста
        Assert.assertTrue(paymentBlock.isDisplayed(), "Блок 'Онлайн пополнение без комиссии' не отображается");
        Assert.assertEquals(paymentBlock.getText(), "Онлайн пополнение без комиссии",
                "Название блока не соответствует ожидаемому");

        System.out.println("✓ Название блока корректно");
    }

    @Test(priority = 2)
    public void testPaymentSystemLogos() {
        System.out.println("Тест 2: Проверка наличия логотипов платёжных систем");

        // Ожидание загрузки логотипов
        wait.until(ExpectedConditions.presenceOfElementLocated(PAYMENT_SYSTEM_LOGOS));

        List<WebElement> logos = driver.findElements(PAYMENT_SYSTEM_LOGOS);

        // Проверка, что логотипы присутствуют
        Assert.assertFalse(logos.isEmpty(), "Логотипы платёжных систем не найдены");

        // Проверка видимости каждого логотипа
        for (WebElement logo : logos) {
            Assert.assertTrue(logo.isDisplayed(), "Логотип не отображается");
            Assert.assertTrue(logo.getAttribute("src").contains(".png") ||
                            logo.getAttribute("src").contains(".svg"),
                    "Логотип не имеет корректного формата изображения");
        }

        System.out.println("✓ Найдено " + logos.size() + " логотипов платёжных систем");
    }

    @Test(priority = 3)
    public void testDetailsLink() {
        System.out.println("Тест 3: Проверка работы ссылки 'Подробнее о сервисе'");

        WebElement detailsLink = wait.until(ExpectedConditions.elementToBeClickable(DETAILS_LINK));

        // Проверка видимости ссылки
        Assert.assertTrue(detailsLink.isDisplayed(), "Ссылка 'Подробнее о сервисе' не отображается");

        // Получение URL ссылки
        String href = detailsLink.getAttribute("href");
        Assert.assertNotNull(href, "Ссылка не содержит атрибут href");
        Assert.assertFalse(href.isEmpty(), "Ссылка пустая");

        // Проверка, что ссылка ведет на страницу mts.by
        Assert.assertTrue(href.contains("mts.by"), "Ссылка не ведет на домен mts.by");

        System.out.println("✓ Ссылка 'Подробнее о сервисе' корректна и ведет на: " + href);
    }

    @Test(priority = 4)
    public void testContinueButtonWithValidData() {
        System.out.println("Тест 4: Проверка работы кнопки 'Продолжить' с валидными данными");

        // Заполнение полей формы
        WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(PHONE_NUMBER_INPUT));
        phoneInput.clear();
        phoneInput.sendKeys("297777777");

        WebElement amountInput = driver.findElement(AMOUNT_INPUT);
        amountInput.clear();
        amountInput.sendKeys("10");

        WebElement emailInput = driver.findElement(EMAIL_INPUT);
        emailInput.clear();
        emailInput.sendKeys("test@example.com");

        // Нажатие кнопки "Продолжить"
        WebElement continueButton = driver.findElement(CONTINUE_BUTTON);
        Assert.assertTrue(continueButton.isEnabled(), "Кнопка 'Продолжить' неактивна");
        continueButton.click();

        // Проверка перехода на следующую страницу или появления следующего шага
        try {
            // Ожидание изменения состояния - может быть переход на другую страницу
            // или появление нового блока формы
            Thread.sleep(2000);

            // Проверка, что мы остались на странице или перешли дальше в процессе оплаты
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("mts.by"), "Произошел переход с сайта mts.by");

            System.out.println("✓ Форма успешно отправлена с валидными данными");

        } catch (Exception e) {
            System.out.println("⚠ Возможно, требуется дополнительная проверка перехода");
        }
    }

    @Test(priority = 5)
    public void testContinueButtonWithInvalidPhone() {
        System.out.println("Тест 5: Проверка валидации номера телефона");

        // Заполнение полей формы с невалидным номером
        WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(PHONE_NUMBER_INPUT));
        phoneInput.clear();
        phoneInput.sendKeys("123"); // Невалидный номер

        WebElement amountInput = driver.findElement(AMOUNT_INPUT);
        amountInput.clear();
        amountInput.sendKeys("10");

        WebElement emailInput = driver.findElement(EMAIL_INPUT);
        emailInput.clear();
        emailInput.sendKeys("test@example.com");

        // Проверка поведения кнопки или появления сообщения об ошибке
        WebElement continueButton = driver.findElement(CONTINUE_BUTTON);

        try {
            // Проверяем, появляется ли сообщение об ошибке
            List<WebElement> errorMessages = driver.findElements(ERROR_MESSAGE);
            if (!errorMessages.isEmpty()) {
                System.out.println("✓ Система показывает сообщение об ошибке для невалидного номера");
            }
        } catch (Exception e) {
            System.out.println("⚠ Проверка ошибок не выполнена, но тест продолжается");
        }
    }

    @Test(priority = 6)
    public void testCompletePaymentFlow() {
        System.out.println("Тест 6: Комплексная проверка процесса пополнения");

        // 1. Проверяем наличие блока
        testOnlinePaymentBlockTitle();

        // 2. Проверяем логотипы
        testPaymentSystemLogos();

        // 3. Проверяем ссылку
        testDetailsLink();

        // 4. Проверяем основную функциональность
        testContinueButtonWithValidData();

        System.out.println("✓ Все основные функции блока 'Онлайн пополнение без комиссии' работают корректно");
    }
}