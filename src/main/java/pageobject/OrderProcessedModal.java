package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderProcessedModal extends AbstractPageObject {

    private static final By ORDER_PROCESSED_FORM = By.xpath("/html/body/div[1]/div/div[2]/div[5]");
    public OrderProcessedModal(WebDriver driver) {
        super(driver);
    }

    public boolean isOrderProcessedFormDisplayed() {
        checkThatElementIsEnabled(ORDER_PROCESSED_FORM);
        return driver.findElement(ORDER_PROCESSED_FORM).isDisplayed();
    }
}
