package Lesson_11;
import Lesson_10.OnlinePaymentPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

    @Epic("MTS Online Payment Tests")
    @Feature("Блок 'Онлайн пополнение без комиссии'")
    public class MtsOnlinePaymentTest extends BaseTest {

        private OnlinePaymentPage paymentPage;

        @BeforeMethod
        @Step("Инициализация Page Object")
        public void setUpPage() {
            paymentPage = new OnlinePaymentPage(driver);
        }

        @Test(priority = 1)
        @Story("Проверка основных элементов блока")
        @Description("Тест проверяет наличие и корректность основных элементов блока онлайн пополнения")
        @Severity(SeverityLevel.BLOCKER)
        public void testOnlinePaymentBlockElements() {
            Allure.step("Проверка заголовка блока");
            Assert.assertTrue(paymentPage.isBlockTitleDisplayed(),
                    "Заголовок блока не отображается");
            Assert.assertEquals(paymentPage.getBlockTitleText(),
                    "Онлайн пополнение без комиссии",
                    "Некорректный текст заголовка");

            Allure.step("Проверка логотипов платежных систем");
            Assert.assertTrue(paymentPage.getPaymentSystemLogosCount() > 0,
                    "Логотипы платежных систем не найдены");
            Assert.assertTrue(paymentPage.areAllPaymentLogosDisplayed(),
                    "Не все логотипы платежных систем отображаются");

            Allure.step("Проверка ссылки 'Подробнее о сервисе'");
            Assert.assertTrue(paymentPage.getDetailsLinkHref().contains("mts.by"),
                    "Ссылка ведет не на домен mts.by");

            takeScreenshot("block_elements");
        }

        @Test(priority = 2)
        @Story("Проверка плейсхолдеров полей ввода")
        @Description("Тест проверяет надписи в полях для всех вариантов оплаты")
        @Severity(SeverityLevel.CRITICAL)
        public void testPaymentTabsPlaceholders() {
            String[] paymentTabs = {"Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность"};

            for (String tabName : paymentTabs) {
                Allure.step("Проверка вкладки: " + tabName);
                paymentPage.selectPaymentTab(tabName);

                List<String> placeholders = (List<String>) paymentPage.getAllPlaceholders();
                Assert.assertFalse(placeholders.isEmpty(),
                        "Не найдены поля для ввода в табе: " + tabName);

                Allure.step("Найдены плейсхолдеры: " + placeholders);

                for (String placeholder : placeholders) {
                    Assert.assertNotNull(placeholder, "Пустой плейсхолдер в табе: " + tabName);
                    Assert.assertFalse(placeholder.trim().isEmpty(),
                            "Пустой плейсхолдер в табе: " + tabName);
                }
            }

            takeScreenshot("payment_tabs");
        }

        @Test(priority = 3)
        @Story("Проверка процесса оплаты услуг связи")
        @Description("Тест проверяет полный цикл оплаты услуг связи с номером 297777777")
        @Severity(SeverityLevel.CRITICAL)
        public void testMobilePaymentFlow() {
            Allure.step("Заполнение формы оплаты услуг связи");
            paymentPage.selectPaymentTab("Услуги связи");
            paymentPage.fillMobilePaymentForm("297777777", "10", "test@example.com");

            Allure.step("Открытие модального окна оплаты");
            paymentPage.clickContinue();

            Allure.step("Проверка данных в модальном окне");
            String paymentAmount = paymentPage.getPaymentAmount();
            String paymentPhone = paymentPage.getPaymentPhone();
            String payButtonText = paymentPage.getPayButtonText();

            Assert.assertTrue(paymentAmount.contains("10"),
                    "Сумма оплаты отображается некорректно: " + paymentAmount);
            Assert.assertTrue(paymentPhone.contains("297777777"),
                    "Номер телефона отображается некорректно: " + paymentPhone);
            Assert.assertTrue(payButtonText.contains("10"),
                    "Сумма на кнопке оплаты отображается некорректно: " + payButtonText);

            takeScreenshot("payment_modal");
        }

        @Test(priority = 4)
        @Story("Проверка деталей модального окна")
        @Description("Тест проверяет поля для карты и иконки платежных систем в модальном окне")
        @Severity(SeverityLevel.NORMAL)
        public void testPaymentModalDetails() {
            Allure.step("Подготовка данных и открытие модального окна");
            paymentPage.selectPaymentTab("Услуги связи");
            paymentPage.fillMobilePaymentForm("297777777", "10", "test@example.com");
            paymentPage.clickContinue();

            Allure.step("Проверка плейсхолдеров полей карты");
            List<String> cardPlaceholders = paymentPage.getCardInputPlaceholders();
            List<String> expectedPlaceholders = List.of("Номер карты", "Срок действия", "CVV");

            for (int i = 0; i < expectedPlaceholders.size(); i++) {
                Assert.assertEquals(cardPlaceholders.get(i), expectedPlaceholders.get(i),
                        "Некорректный плейсхолдер для поля карты");
            }

            Allure.step("Проверка иконок платежных систем");
            Assert.assertTrue(paymentPage.getCardPaymentIconsCount() > 0,
                    "Иконки платежных систем не найдены");
            Assert.assertTrue(paymentPage.areCardPaymentIconsDisplayed(),
                    "Не все иконки платежных систем отображаются");

            takeScreenshot("card_details");
        }
    }

