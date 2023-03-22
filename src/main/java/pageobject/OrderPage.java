package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class OrderPage extends AbstractPageObject {

    private static final By NAME_FIELD = By.xpath(".//div[@class='Input_InputContainer__3NykH'][1]/input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    private static final By SURNAME_FIELD = By.xpath(".//div[@class='Input_InputContainer__3NykH'][2]/input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    private static final By ADDRESS_FIELD = By.xpath(".//div[@class='Input_InputContainer__3NykH'][3]/input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    private static final By METRO_STATION_FIELD = By.xpath(".//div[@class='select-search__value']/input[@class='select-search__input']");
    private By metroStationListCherkizovskaya = By.xpath(".//div[@class='select-search__select']/ul[@class='select-search__options']/li[@class='select-search__row'][2]/button[@class='Order_SelectOption__82bhS select-search__option']/div[@class='Order_Text__2broi']");
    private static final By TELEPHONE_FIELD = By.xpath(".//div[@class='Input_InputContainer__3NykH'][4]/input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    private static final By FURTHER_BUTTON = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

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
        driver.findElement(metroStationListCherkizovskaya).click();
    }

    public void inputTelephoneField(String  telephone) {
        driver.findElement(TELEPHONE_FIELD).click();
        driver.findElement(TELEPHONE_FIELD).sendKeys(telephone);
    }

    public void clickFurtherButton() {
        driver.findElement(FURTHER_BUTTON).click();
    }
}
