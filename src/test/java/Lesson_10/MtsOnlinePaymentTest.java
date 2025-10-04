package Lesson_10;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
    public class MtsOnlinePaymentTest extends BaseTest {

        private OnlinePaymentPage paymentPage;

        @BeforeMethod
        public void setUpPage() {
            paymentPage = new OnlinePaymentPage(driver);
        }

        @Test(priority = 1)
        public void testOnlinePaymentBlockElements() {
            System.out.println("Тест 1: Проверка основных элементов блока");

            Assert.assertTrue(paymentPage.isBlockTitleDisplayed(),
                    "Заголовок блока не отображается");
            Assert.assertEquals(paymentPage.getBlockTitleText(),
                    "Онлайн пополнение без комиссии",
                    "Некорректный текст заголовка");

            Assert.assertTrue(paymentPage.getPaymentSystemLogosCount() > 0,
                    "Логотипы платежных систем не найдены");
            Assert.assertTrue(paymentPage.areAllPaymentLogosDisplayed(),
                    "Не все логотипы платежных систем отображаются");

            Assert.assertTrue(paymentPage.isDetailsLinkDisplayed(),
                    "Ссылка 'Подробнее о сервисе' не отображается");
            Assert.assertTrue(paymentPage.getDetailsLinkHref().contains("mts.by"),
                    "Ссылка ведет не на домен mts.by");

            System.out.println("✓ Основные элементы блока корректны");
        }

        @Test(priority = 2)
        public void testPaymentTabsPlaceholders() {
            System.out.println("Тест 2: Проверка надписей в полях для всех вариантов оплаты");

            String[] paymentTabs = {"Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность"};

            for (String tabName : paymentTabs) {
                paymentPage.selectPaymentTab(tabName);

                List<String> placeholders = (List<String>) paymentPage.getAllPlaceholders();
                Assert.assertFalse(placeholders.isEmpty(),
                        "Не найдены поля для ввода в табе: " + tabName);

                System.out.println("Таб '" + tabName + "' - плейсхолдеры: " + placeholders);

                // Проверяем, что плейсхолдеры не пустые
                for (String placeholder : placeholders) {
                    Assert.assertNotNull(placeholder, "Пустой плейсхолдер в табе: " + tabName);
                    Assert.assertFalse(placeholder.trim().isEmpty(),
                            "Пустой плейсхолдер в табе: " + tabName);
                }
            }

            System.out.println("✓ Надписи в полях для всех вариантов оплаты корректны");
        }

        @Test(priority = 3)
        public void testMobilePaymentFlow() {
            System.out.println("Тест 3: Проверка полного цикла оплаты услуг связи");

            // Выбираем таб "Услуги связи"
            paymentPage.selectPaymentTab("Услуги связи");

            // Заполняем форму
            paymentPage.fillMobilePaymentForm("297777777", "10", "test@example.com");

            // Нажимаем "Продолжить"
            paymentPage.clickContinue();

            // Проверяем модальное окно
            Assert.assertTrue(paymentPage.isPaymentModalDisplayed(),
                    "Модальное окно оплаты не отображается");

            // Проверяем корректность отображения данных
            String paymentAmount = paymentPage.getPaymentAmount();
            String paymentPhone = paymentPage.getPaymentPhone();
            String payButtonText = paymentPage.getPayButtonText();

            Assert.assertTrue(paymentAmount.contains("10"),
                    "Сумма оплаты отображается некорректно: " + paymentAmount);
            Assert.assertTrue(paymentPhone.contains("297777777"),
                    "Номер телефона отображается некорректно: " + paymentPhone);
            Assert.assertTrue(payButtonText.contains("10"),
                    "Сумма на кнопке оплаты отображается некорректно: " + payButtonText);

            System.out.println("✓ Данные в модальном окне отображаются корректно");
        }

        @Test(priority = 4)
        public void testPaymentModalDetails() {
            System.out.println("Тест 4: Проверка деталей модального окна оплаты");

            // Подготавливаем данные и открываем модальное окно
            paymentPage.selectPaymentTab("Услуги связи");
            paymentPage.fillMobilePaymentForm("297777777", "10", "test@example.com");
            paymentPage.clickContinue();

            // Проверяем надписи в полях для карты
            List<String> cardPlaceholders = paymentPage.getCardInputPlaceholders();
            List<String> expectedPlaceholders = List.of("Номер карты", "Срок действия", "CVV");

            for (int i = 0; i < expectedPlaceholders.size(); i++) {
                Assert.assertEquals(cardPlaceholders.get(i), expectedPlaceholders.get(i),
                        "Некорректный плейсхолдер для поля карты");
            }

            // Проверяем иконки платежных систем
            Assert.assertTrue(paymentPage.getCardPaymentIconsCount() > 0,
                    "Иконки платежных систем не найдены");
            Assert.assertTrue(paymentPage.areCardPaymentIconsDisplayed(),
                    "Не все иконки платежных систем отображаются");

            System.out.println("✓ Надписи в полях карты: " + cardPlaceholders);
            System.out.println("✓ Количество иконок платежных систем: " + paymentPage.getCardPaymentIconsCount());
        }

        @Test(priority = 5)
        public void testCompletePaymentScenario() {
            System.out.println("Тест 5: Комплексная проверка сценария оплаты");

            // Проверяем основные элементы
            testOnlinePaymentBlockElements();

            // Проверяем все варианты оплаты
            testPaymentTabsPlaceholders();

            // Проверяем основной сценарий
            testMobilePaymentFlow();

            // Проверяем детали модального окна
            testPaymentModalDetails();

            System.out.println("✓ Весь сценарий онлайн пополнения работает корректно");
        }
    }
