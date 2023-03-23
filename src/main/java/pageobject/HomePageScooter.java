package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HomePageScooter extends AbstractPageObject {

    //  Первый вопрос
    public static final By FIRST_QUESTION = By.id("accordion__heading-0");
    // Ответ на первый вопрос
    public static final By FIRST_ANSWER = By.xpath(".//div[@id='accordion__panel-0']/p");
    // Второй вопрос
    public static final By SECOND_QUESTION = By.id("accordion__heading-1");
    //  Ответ на второй вопрос
    public static final By SECOND_ANSWER = By.xpath(".//div[@id='accordion__panel-1']/p");
    //  Третий вопрос
    public static final By THIRD_QUESTION = By.id("accordion__heading-2");
    //  Ответ на третий вопрос
    public static final By THIRD_ANSWER = By.xpath(".//div[@id='accordion__panel-2']/p");
    //  Четвертый вопрос
    public static final By FOURTH_QUESTION = By.id("accordion__heading-3");
    //  Ответ на четвертый вопрос
    public static final By FOURTH_ANSWER = By.xpath(".//div[@id='accordion__panel-3']/p");
    //  Пятый вопрос
    public static final By FIFTH_QUESTION = By.id("accordion__heading-4");
    //  Ответ на пятый вопрос
    public static final By FIFTH_ANSWER = By.xpath(".//div[@id='accordion__panel-4']/p");
    //  Шестой вопрос
    public static final By SIXTH_QUESTION = By.id("accordion__heading-5");
    //  Ответ на шестой вопрос
    public static final By SIXTH_ANSWER = By.xpath(".//div[@id='accordion__panel-5']/p");
    //  Седьмой вопрос
    public static final By SEVENTH_QUESTION = By.id("accordion__heading-6");
    //  Ответ на седьмой вопрос
    public static final By SEVENTH_ANSWER = By.xpath(".//div[@id='accordion__panel-6']/p");
    //  Восьмой вопрос
    public static final By EIGHTH_QUESTION = By.id("accordion__heading-7");
    //  Ответ на восьмой вопрос
    public static final By EIGHTH_ANSWER = By.xpath(".//div[@id='accordion__panel-7']/p");
    // Кнопка "Заказать" вверху страницы
    public static final By ORDER_BUTTON_AT_TOP_OF_PAGE = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    // Кнопка "Заказать" внизу страницы
    public static final By ORDER_BUTTON_AT_BOTTOM_OF_PAGE = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public static final By COOKIE_BUTTON = By.id("rcc-confirm-button");

    public HomePageScooter(WebDriver driver) {
        super(driver);
    }

    public void scrollPage() {
        WebElement element = driver.findElement(EIGHTH_QUESTION);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickOrderButtonAtTopOfPage() {
        driver.findElement(ORDER_BUTTON_AT_TOP_OF_PAGE).click();
    }

    public void clickOrderButtonAtBottomOfPage() {
        driver.findElement(ORDER_BUTTON_AT_BOTTOM_OF_PAGE).click();
    }

    public void clickCookieButton() {
        driver.findElement(COOKIE_BUTTON).click();
    }
}
