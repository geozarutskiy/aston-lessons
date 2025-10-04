package Lesson_11;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
    public class OnlinePaymentPage extends BasePage {

        // Элементы остаются теми же...
        @FindBy(xpath = "//h2[contains(text(), 'Онлайн пополнение без комиссии')]")
        private WebElement blockTitle;

        @FindBy(xpath = "//div[contains(@class, 'pay-systems')]//img")
        private List<WebElement> paymentSystemLogos;

        @FindBy(xpath = "//a[contains(text(), 'Подробнее о сервисе')]")
        private WebElement detailsLink;

        @FindBy(xpath = "//div[contains(@class, 'payment-tabs')]//button")
        private List<WebElement> paymentTabs;

        @FindBy(xpath = "//input[@placeholder='Номер телефона']")
        private WebElement phoneInput;

        @FindBy(xpath = "//input[@placeholder='Сумма']")
        private WebElement amountInput;

        @FindBy(xpath = "//input[@placeholder='Е-mail']")
        private WebElement emailInput;

        @FindBy(xpath = "//button[contains(text(), 'Продолжить')]")
        private WebElement continueButton;

        @FindBy(xpath = "//input[@placeholder]")
        private List<WebElement> allPlaceholderInputs;

        @FindBy(xpath = "//div[contains(@class, 'payment-modal')]")
        private WebElement paymentModal;

        @FindBy(xpath = "//div[contains(@class, 'payment-summary')]//span[contains(text(), 'Сумма')]/following-sibling::span")
        private WebElement paymentAmount;

        @FindBy(xpath = "//div[contains(@class, 'payment-summary')]//span[contains(text(), 'Номер')]/following-sibling::span")
        private WebElement paymentPhone;

        @FindBy(xpath = "//input[@placeholder='Номер карты']")
        private WebElement cardNumberInput;

        @FindBy(xpath = "//input[@placeholder='Срок действия']")
        private WebElement cardExpiryInput;

        @FindBy(xpath = "//input[@placeholder='CVV']")
        private WebElement cardCvvInput;

        @FindBy(xpath = "//div[contains(@class, 'card-icons')]//img")
        private List<WebElement> cardPaymentIcons;

        @FindBy(xpath = "//button[contains(@class, 'pay-button')]")
        private WebElement payButton;

        public OnlinePaymentPage(WebDriver driver) {
            super(driver);
        }

        @Step("Проверить отображение заголовка блока")
        public boolean isBlockTitleDisplayed() {
            return blockTitle.isDisplayed();
        }

        @Step("Получить текст заголовка блока")
        public String getBlockTitleText() {
            return blockTitle.getText();
        }

        @Step("Получить количество логотипов платежных систем")
        public int getPaymentSystemLogosCount() {
            return paymentSystemLogos.size();
        }

        @Step("Проверить отображение всех логотипов платежных систем")
        public boolean areAllPaymentLogosDisplayed() {
            return paymentSystemLogos.stream().allMatch(WebElement::isDisplayed);
        }

        @Step("Нажать на ссылку 'Подробнее о сервисе'")
        public void clickDetailsLink() {
            detailsLink.click();
        }

        @Step("Выбрать вкладку оплаты: {tabName}")
        public void selectPaymentTab(String tabName) {
            Allure.step("Выбор вкладки: " + tabName);
            paymentTabs.stream()
                    .filter(tab -> tab.getText().contains(tabName))
                    .findFirst()
                    .ifPresent(WebElement::click);
        }

        @Step("Ввести номер телефона: {phone}")
        public void enterPhoneNumber(String phone) {
            wait.until(ExpectedConditions.elementToBeClickable(phoneInput));
            phoneInput.clear();
            phoneInput.sendKeys(phone);
            Allure.step("Введен номер телефона: " + phone);
        }

        @Step("Ввести сумму: {amount}")
        public void enterAmount(String amount) {
            amountInput.clear();
            amountInput.sendKeys(amount);
            Allure.step("Введена сумма: " + amount);
        }

        @Step("Ввести email: {email}")
        public void enterEmail(String email) {
            emailInput.clear();
            emailInput.sendKeys(email);
            Allure.step("Введен email: " + email);
        }

        @Step("Нажать кнопку 'Продолжить'")
        public void clickContinue() {
            continueButton.click();
            wait.until(ExpectedConditions.visibilityOf(paymentModal));
            Allure.step("Модальное окно оплаты открыто");
        }

        @Step("Получить сумму платежа из модального окна")
        public String getPaymentAmount() {
            return paymentAmount.getText();
        }

        @Step("Получить номер телефона из модального окна")
        public String getPaymentPhone() {
            return paymentPhone.getText();
        }

        @Step("Получить текст кнопки оплаты")
        public String getPayButtonText() {
            return payButton.getText();
        }

        @Step("Получить плейсхолдеры полей карты")
        public List<String> getCardInputPlaceholders() {
            return List.of(
                    cardNumberInput.getAttribute("placeholder"),
                    cardExpiryInput.getAttribute("placeholder"),
                    cardCvvInput.getAttribute("placeholder")
            );
        }

        @Step("Получить количество иконок платежных систем в модальном окне")
        public int getCardPaymentIconsCount() {
            return cardPaymentIcons.size();
        }

        @Step("Заполнить форму оплаты услуг связи")
        public void fillMobilePaymentForm(String phone, String amount, String email) {
            Allure.step("Заполнение формы оплаты: телефон=" + phone + ", сумма=" + amount + ", email=" + email);
            selectPaymentTab("Услуги связи");
            enterPhoneNumber(phone);
            enterAmount(amount);
            enterEmail(email);
        }
    }

