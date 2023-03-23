package pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPageObject {

    protected WebDriver driver;

    public AbstractPageObject(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Кликнуть по элементу
     * @param element элемент
     */
    protected void clickElement(By element) {
        driver.findElement(element).click();
    }

    /**
     * Проверить, что элемент доступен
     * @param element проверяемый элемент
     */
    protected void checkThatElementIsEnabled(By element) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(element));
        Assert.assertTrue(driver.findElement(element).isEnabled());
    }

    /**
     * Получить текст элемента
     * @param element элемент
     * @return текст элемента
     */
    protected String  getTextOfElement(By element){
        return driver.findElement(element).getText();
    }
}
