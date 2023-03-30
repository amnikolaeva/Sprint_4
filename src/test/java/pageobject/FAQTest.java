package pageobject;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
@RunWith(Parameterized.class)
public class FAQTest {

    private static final String TEXT_OF_FIRST_ANSWER = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private static final String TEXT_OF_SECOND_ANSWER = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private static final String TEXT_OF_THIRD_ANSWER = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private static final String TEXT_OF_FOURTH_ANSWER = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private static final String TEXT_OF_FIFTH_ANSWER = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private static final String TEXT_OF_SIXTH_ANSWER = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private static final String TEXT_OF_SEVENTH_ANSWER = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private static final String TEXT_OF_EIGHTH_ANSWER = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    private WebDriver driver;

    /**
     * Блок данных для параметризации
     */
    private final By questionElement;
    private final By answerElement;
    private final String answerText;

    public FAQTest(By questionElement, By answerElement, String answerText) {
        this.questionElement = questionElement;
        this.answerElement = answerElement;
        this.answerText = answerText;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {HomePageScooter.FIRST_QUESTION, HomePageScooter.FIRST_ANSWER, TEXT_OF_FIRST_ANSWER},
                {HomePageScooter.SECOND_QUESTION, HomePageScooter.SECOND_ANSWER, TEXT_OF_SECOND_ANSWER},
                {HomePageScooter.THIRD_QUESTION, HomePageScooter.THIRD_ANSWER, TEXT_OF_THIRD_ANSWER},
                {HomePageScooter.FOURTH_QUESTION, HomePageScooter.FOURTH_ANSWER, TEXT_OF_FOURTH_ANSWER},
                {HomePageScooter.FIFTH_QUESTION, HomePageScooter.FIFTH_ANSWER, TEXT_OF_FIFTH_ANSWER},
                {HomePageScooter.SIXTH_QUESTION, HomePageScooter.SIXTH_ANSWER, TEXT_OF_SIXTH_ANSWER},
                {HomePageScooter.SEVENTH_QUESTION, HomePageScooter.SEVENTH_ANSWER, TEXT_OF_SEVENTH_ANSWER},
                {HomePageScooter.EIGHTH_QUESTION, HomePageScooter.EIGHTH_ANSWER, TEXT_OF_EIGHTH_ANSWER}
        };
    }

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
        objHomePage.clickCookieButton();
        objHomePage.scrollPage();
        objHomePage.clickElement(questionElement);
        objHomePage.checkThatElementIsEnabled(answerElement);
        String resultOfAnswer = objHomePage.getTextOfElement(answerElement);
        MatcherAssert.assertThat(answerText, is(resultOfAnswer));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}