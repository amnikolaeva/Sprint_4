package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HomePageScooter extends AbstractPageObject {

    //  Первый вопрос
    private static final By FIRST_QUESTION = By.id("accordion__heading-0");
    // Ответ на первый вопрос
    private static final By FIRST_ANSWER = By.xpath(".//div[@id='accordion__panel-0']/p");
    // Второй вопрос
    private static final By SECOND_QUESTION = By.id("accordion__heading-1");
    //  Ответ на второй вопрос
    private static final By SECOND_ANSWER = By.xpath(".//div[@id='accordion__panel-1']/p");
    //  Третий вопрос
    private static final By THIRD_QUESTION = By.id("accordion__heading-2");
    //  Ответ на третий вопрос
    private static final By THIRD_ANSWER = By.xpath(".//div[@id='accordion__panel-2']/p");
    //  Четвертый вопрос
    private static final By FOURTH_QUESTION = By.id("accordion__heading-3");
    //  Ответ на четвертый вопрос
    private static final By FOURTH_ANSWER = By.xpath(".//div[@id='accordion__panel-3']/p");
    //  Пятый вопрос
    private static final By FIFTH_QUESTION = By.id("accordion__heading-4");
    //  Ответ на пятый вопрос
    private static final By FIFTH_ANSWER = By.xpath(".//div[@id='accordion__panel-4']/p");
    //  Шестой вопрос
    private static final By SIXTH_QUESTION = By.id("accordion__heading-5");
    //  Ответ на шестой вопрос
    private static final By SIXTH_ANSWER = By.xpath(".//div[@id='accordion__panel-5']/p");
    //  Седьмой вопрос
    private static final By SEVENTH_QUESTION = By.id("accordion__heading-6");
    //  Ответ на седьмой вопрос
    private static final By SEVENTH_ANSWER = By.xpath(".//div[@id='accordion__panel-6']/p");
    //  Восьмой вопрос
    private static final By EIGHTH_QUESTION = By.id("accordion__heading-7");
    //  Ответ на восьмой вопрос
    private static final By EIGHTH_ANSWER = By.xpath(".//div[@id='accordion__panel-7']/p");
    // Кнопка "Заказать" вверху страницы
    private static final By ORDER_BUTTON_AT_TOP_OF_PAGE = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    // Кнопка "Заказать" внизу страницы
    private static final By ORDER_BUTTON_AT_BOTTOM_OF_PAGE = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    private static final By COOKIE_BUTTON = By.id("rcc-confirm-button");

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

    public void clickFirstQuestion() {
        driver.findElement(FIRST_QUESTION).click();
    }

    public void clickSecondQuestion() {
        driver.findElement(SECOND_QUESTION).click();
    }

    public void clickThirdQuestion() {
        driver.findElement(THIRD_QUESTION).click();
    }

    public void clickFourthQuestion() {
        driver.findElement(FOURTH_QUESTION).click();
    }

    public void clickFifthQuestion() {
        driver.findElement(FIFTH_QUESTION).click();
    }

    public void clickSixthQuestion() {
        driver.findElement(SIXTH_QUESTION).click();
    }

    public void clickSeventhQuestion() {
        driver.findElement(SEVENTH_QUESTION).click();
    }

    public void clickEighthQuestion() {
        driver.findElement(EIGHTH_QUESTION).click();
    }

    public void clickCookieButtonIfEnabled() {
        if (driver.findElement(COOKIE_BUTTON).isEnabled()) {
            driver.findElement(COOKIE_BUTTON).click();
        }
    }
    public void firstAnswerIsEnabled() {
        checkThatElementIsEnabled(FIRST_ANSWER);
    }

    public void secondAnswerIsEnabled() {
        checkThatElementIsEnabled(SECOND_ANSWER);
    }

    public void thirdAnswerIsEnabled() {
        checkThatElementIsEnabled(THIRD_ANSWER);
    }

    public void fourthAnswerIsEnabled() {
        checkThatElementIsEnabled(FOURTH_ANSWER);
    }

    public void fifthAnswerIsEnabled() {
        checkThatElementIsEnabled(FIFTH_ANSWER);
    }

    public void sixthAnswerIsEnabled() {
        checkThatElementIsEnabled(SIXTH_ANSWER);
    }

    public void seventhAnswerIsEnabled() {
        checkThatElementIsEnabled(SEVENTH_ANSWER);
    }

    public void eighthAnswerIsEnabled() {
        checkThatElementIsEnabled(EIGHTH_ANSWER);
    }

    public String getTextOfFirstAnswer() {
        return driver.findElement(FIRST_ANSWER).getText();
    }

    public String getTextOfSecondAnswer() {
        return driver.findElement(SECOND_ANSWER).getText();
    }

    public String getTextOfThirdAnswer() {
        return driver.findElement(THIRD_ANSWER).getText();
    }

    public String getTextOfFourthAnswer() {
        return driver.findElement(FOURTH_ANSWER).getText();
    }

    public String getTextOfFifthAnswer() {
        return driver.findElement(FIFTH_ANSWER).getText();
    }

    public String getTextOfSixthAnswer() {
        return driver.findElement(SIXTH_ANSWER).getText();
    }

    public String getTextOfSeventhAnswer() {
        return driver.findElement(SEVENTH_ANSWER).getText();
    }

    public String getTextOfEighthAnswer() {
        return driver.findElement(EIGHTH_ANSWER).getText();
    }
}
