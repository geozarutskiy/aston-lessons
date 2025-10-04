package Lesson_10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Stream;

public class OnlinePaymentPage extends BasePage {

        // Основные элементы блока
        @FindBy(xpath = "//h2[contains(text(), 'Онлайн пополнение без комиссии')]")
        private WebElement blockTitle;

        @FindBy(xpath = "//div[contains(@class, 'pay-systems')]//img")
        private List<WebElement> paymentSystemLogos;

        @FindBy(xpath = "//a[contains(text(), 'Подробнее о сервисе')]")
        private WebElement detailsLink;

        // Табы вариантов оплаты
        @FindBy(xpath = "//div[contains(@class, 'payment-tabs')]//button")
        private List<WebElement> paymentTabs;

        // Поля для услуги связи
        @FindBy(xpath = "//input[@placeholder='Номер телефона']")
        private WebElement phoneInput;

        @FindBy(xpath = "//input[@placeholder='Сумма']")
        private WebElement amountInput;

        @FindBy(xpath = "//input[@placeholder='Е-mail']")
        private WebElement emailInput;

        @FindBy(xpath = "//button[contains(text(), 'Продолжить')]")
        private WebElement continueButton;

        // Плейсхолдеры для разных вариантов оплаты
        @FindBy(xpath = "//input[@placeholder]")
        private List<WebElement> allPlaceholderInputs;

        // Модальное окно оплаты
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

        // Методы для проверки основного блока
        public boolean isBlockTitleDisplayed() {
            return blockTitle.isDisplayed();
        }

        public String getBlockTitleText() {
            return blockTitle.getText();
        }

        public int getPaymentSystemLogosCount() {
            return paymentSystemLogos.size();
        }

        public boolean areAllPaymentLogosDisplayed() {
            return paymentSystemLogos.stream().allMatch(WebElement::isDisplayed);
        }

        public void clickDetailsLink() {
            detailsLink.click();
        }

        public boolean isDetailsLinkDisplayed() {
            return detailsLink.isDisplayed();
        }

        public String getDetailsLinkHref() {
            return detailsLink.getAttribute("href");
        }

        // Методы для работы с вариантами оплаты
        public void selectPaymentTab(String tabName) {
            paymentTabs.stream()
                    .filter(tab -> tab.getText().contains(tabName))
                    .findFirst()
                    .ifPresent(WebElement::click);
        }

        public Stream<String> getAllPlaceholders() {
            return allPlaceholderInputs.stream()
                    .map(input -> input.getAttribute("placeholder"));
        }

        // Методы для услуги связи
        public void enterPhoneNumber(String phone) {
            wait.until(ExpectedConditions.elementToBeClickable(phoneInput));
            phoneInput.clear();
            phoneInput.sendKeys(phone);
        }

        public void enterAmount(String amount) {
            amountInput.clear();
            amountInput.sendKeys(amount);
        }

        public void enterEmail(String email) {
            emailInput.clear();
            emailInput.sendKeys(email);
        }

        public void clickContinue() {
            continueButton.click();
            wait.until(ExpectedConditions.visibilityOf(paymentModal));
        }

        // Методы для проверки модального окна
        public boolean isPaymentModalDisplayed() {
            return paymentModal.isDisplayed();
        }

        public String getPaymentAmount() {
            return paymentAmount.getText();
        }

        public String getPaymentPhone() {
            return paymentPhone.getText();
        }

        public String getPayButtonText() {
            return payButton.getText();
        }

        public List<String> getCardInputPlaceholders() {
            return List.of(
                    cardNumberInput.getAttribute("placeholder"),
                    cardExpiryInput.getAttribute("placeholder"),
                    cardCvvInput.getAttribute("placeholder")
            );
        }

        public int getCardPaymentIconsCount() {
            return cardPaymentIcons.size();
        }

        public boolean areCardPaymentIconsDisplayed() {
            return cardPaymentIcons.stream().allMatch(WebElement::isDisplayed);
        }

        // Комплексный метод для заполнения формы услуги связи
        public void fillMobilePaymentForm(String phone, String amount, String email) {
            selectPaymentTab("Услуги связи");
            enterPhoneNumber(phone);
            enterAmount(amount);
            enterEmail(email);
        }
    }
