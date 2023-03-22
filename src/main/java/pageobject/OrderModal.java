package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class OrderModal extends AbstractPageObject {

    private static final By YES_BUTTON = By.xpath(".//div[@class='Order_Content__bmtHS']/div[@class='Order_Modal__YZ-d3']/div[@class='Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public OrderModal(WebDriver driver) {
        super(driver);
    }

    public void clickYesButton() {
        checkThatElementIsEnabled(YES_BUTTON);
        driver.findElement(YES_BUTTON).click();
    }
}
