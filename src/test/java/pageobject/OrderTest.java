package pageobject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class OrderTest {

    /**
     * Блок данных для параметризации
     */
    private final String name;
    private final String surname;
    private final String address;
    private final String telephone;

    public OrderTest(String name, String surname, String address, String telephone) {
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
