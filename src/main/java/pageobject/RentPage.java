package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RentPage extends AbstractPageObject {

    private static final By DATE_FIELD = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    private static final By DATE_IN_CALENDAR = By.xpath(".//div[@class='react-datepicker__month-container']/div[@class='react-datepicker__month']/div[@class='react-datepicker__week'][4]/div[@class='react-datepicker__day react-datepicker__day--025 react-datepicker__day--weekend']");
    private static final By RENTAL_PERIOD_FIELD = By.xpath(".//div[@class='Dropdown-control']/div[@class='Dropdown-placeholder']");
    private static final By RENTAL_PERIOD_THREE_DAYS = By.xpath(".//div[@class='Dropdown-root is-open']/div[@class='Dropdown-menu']/div[@class='Dropdown-option'][3]");
    private static final By ORDER_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public RentPage(WebDriver driver) {
        super(driver);
    }

    public void inputDateField() {
        checkThatElementIsEnabled(DATE_FIELD);
        driver.findElement(DATE_FIELD).click();
        checkThatElementIsEnabled(DATE_IN_CALENDAR);
        driver.findElement(DATE_IN_CALENDAR).click();
    }

    public void inputRentalPeriodField() {
        driver.findElement(RENTAL_PERIOD_FIELD).click();
        checkThatElementIsEnabled(RENTAL_PERIOD_THREE_DAYS);
        driver.findElement(RENTAL_PERIOD_THREE_DAYS).click();
    }

    public void clickOrderButton() {
        driver.findElement(ORDER_BUTTON).click();
    }
}
