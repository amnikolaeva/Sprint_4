package pageobject;
;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;

@RunWith(Parameterized.class)
public class ScooterTest {

    private static final String TEXT_OF_FIRST_ANSWER = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String TEXT_OF_SECOND_ANSWER = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String TEXT_OF_THIRD_ANSWER = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String TEXT_OF_FOURTH_ANSWER = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String TEXT_OF_FIFTH_ANSWER = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String TEXT_OF_SIXTH_ANSWER = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String TEXT_OF_SEVENTH_ANSWER = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String TEXT_OF_EIGHTH_ANSWER = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    /**
     * Блок данных для параметризации
     */
    private final String name;
    private final String surname;
    private final String address;
    private final String telephone;

    public ScooterTest(String name, String surname, String address, String telephone) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telephone = telephone;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {"Анна", "Николаева", "Москва Большая Черкизовская 6", "79267890987"},
                {"Руслан", "Шведов", "Москва Шаболовка 12", "12345678901"}
        };
    }

    private WebDriver driver;

    static {
        System.setProperty("webdriver.chrome.driver", "/Users/annanikolaeva/Apps/WebDriver/bin/chromedriver");
        System.setProperty("webdriver.gecko.driver", "/Users/annanikolaeva/Apps/WebDriver/bin/geckodriver");
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }
    @Test
    public void clickQuestionsAboutImportantSection() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickCookieButtonIfEnabled();
        objHomePage.scrollPage();

        objHomePage.clickFirstQuestion();
        objHomePage.firstAnswerIsEnabled();
        String resultOfFirstAnswer = objHomePage.getTextOfFirstAnswer();
        MatcherAssert.assertThat(TEXT_OF_FIRST_ANSWER, is(resultOfFirstAnswer));

        objHomePage.clickSecondQuestion();
        objHomePage.secondAnswerIsEnabled();
        String resultOfSecondAnswer = objHomePage.getTextOfSecondAnswer();
        MatcherAssert.assertThat(TEXT_OF_SECOND_ANSWER, is(resultOfSecondAnswer));

        objHomePage.clickThirdQuestion();
        objHomePage.thirdAnswerIsEnabled();
        String resultOfThirdAnswer = objHomePage.getTextOfThirdAnswer();
        MatcherAssert.assertThat(TEXT_OF_THIRD_ANSWER, is(resultOfThirdAnswer));

        objHomePage.clickFourthQuestion();
        objHomePage.fourthAnswerIsEnabled();
        String resultOfFourthAnswer = objHomePage.getTextOfFourthAnswer();
        MatcherAssert.assertThat(TEXT_OF_FOURTH_ANSWER, is(resultOfFourthAnswer));

        objHomePage.clickFifthQuestion();
        objHomePage.fifthAnswerIsEnabled();
        String resultOfFifthAnswer = objHomePage.getTextOfFifthAnswer();
        MatcherAssert.assertThat(TEXT_OF_FIFTH_ANSWER, is(resultOfFifthAnswer));

        objHomePage.clickSixthQuestion();
        objHomePage.sixthAnswerIsEnabled();
        String resultOfSixthAnswer = objHomePage.getTextOfSixthAnswer();
        MatcherAssert.assertThat(TEXT_OF_SIXTH_ANSWER, is(resultOfSixthAnswer));

        objHomePage.clickSeventhQuestion();
        objHomePage.seventhAnswerIsEnabled();
        String resultOfSeventhAnswer = objHomePage.getTextOfSeventhAnswer();
        MatcherAssert.assertThat(TEXT_OF_SEVENTH_ANSWER, is(resultOfSeventhAnswer));

        objHomePage.clickEighthQuestion();
        objHomePage.eighthAnswerIsEnabled();
        String resultOfEighthAnswer = objHomePage.getTextOfEighthAnswer();
        MatcherAssert.assertThat(TEXT_OF_EIGHTH_ANSWER, is(resultOfEighthAnswer));
    }

    @Test
    public void checkOrderAtButtonAtTopOfPage() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickOrderButtonAtTopOfPage();
        OrderPage objOrderForm = new OrderPage(driver);
        objOrderForm.inputNameField(name);
        objOrderForm.inputSurnameField(surname);
        objOrderForm.inputAddressField(address);
        objOrderForm.inputMetroStationField();
        objOrderForm.inputTelephoneField(telephone);
        objOrderForm.clickFurtherButton();
        RentPage objRentPage = new RentPage(driver);
        objRentPage.inputDateField();
        objRentPage.inputRentalPeriodField();
        objRentPage.clickOrderButton();
        OrderModal objOrderModal = new OrderModal(driver);
        objOrderModal.clickYesButton();
        OrderProcessedModal objOrderProcessedModal = new OrderProcessedModal(driver);
        Assert.assertTrue(objOrderProcessedModal.isOrderProcessedFormDisplayed());
    }

    @Test
    public void checkOrderAtButtonAtBottomOfPage() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.scrollPage();
        objHomePage.clickOrderButtonAtBottomOfPage();
        OrderPage objOrderForm = new OrderPage(driver);
        objOrderForm.inputNameField(name);
        objOrderForm.inputSurnameField(surname);
        objOrderForm.inputAddressField(address);
        objOrderForm.inputMetroStationField();
        objOrderForm.inputTelephoneField(telephone);
        objOrderForm.clickFurtherButton();
        RentPage objRentPage = new RentPage(driver);
        objRentPage.inputDateField();
        objRentPage.inputRentalPeriodField();
        objRentPage.clickOrderButton();
        OrderModal objOrderModal = new OrderModal(driver);
        objOrderModal.clickYesButton();
        OrderProcessedModal objOrderProcessedModal = new OrderProcessedModal(driver);
        Assert.assertTrue(objOrderProcessedModal.isOrderProcessedFormDisplayed());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}