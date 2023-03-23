package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class OrderPage extends AbstractPageObject {

    private static final By NAME_FIELD = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    private static final By SURNAME_FIELD = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    private static final By ADDRESS_FIELD = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    private static final By METRO_STATION_FIELD = By.xpath(".//input[@class='select-search__input']");
    private static final By METRO_STATION_LIST_CHERKIZOVSKAYA = By.xpath(".//div[@class='Order_Text__2broi']");
    private static final By TELEPHONE_FIELD = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    private static final By FURTHER_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public void inputNameField(String name) {
        driver.findElement(NAME_FIELD).click();
        driver.findElement(NAME_FIELD).sendKeys(name);
    }

    public void inputSurnameField(String surname) {
        driver.findElement(SURNAME_FIELD).click();
        driver.findElement(SURNAME_FIELD).sendKeys(surname);
    }

    public void inputAddressField(String address) {
        driver.findElement(ADDRESS_FIELD).click();
        driver.findElement(ADDRESS_FIELD).sendKeys(address);

    }

    public void inputMetroStationField() {
        driver.findElement(METRO_STATION_FIELD).click();
        driver.findElement(METRO_STATION_LIST_CHERKIZOVSKAYA).click();
    }

    public void inputTelephoneField(String  telephone) {
        driver.findElement(TELEPHONE_FIELD).click();
        driver.findElement(TELEPHONE_FIELD).sendKeys(telephone);
    }

    public void clickFurtherButton() {
        driver.findElement(FURTHER_BUTTON).click();
    }
}
