package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();

    public BasePage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        this.driver = driver;
        this.explicitWait = explicitWait;
    }

    protected final void click(By locator) {
        explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
        driver.get().findElement(locator).click();
    }

    protected final void setText(By locator, String text) {
        explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.get().findElement(locator).sendKeys(text);
    }

    protected final String getText(By locator) {
        explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(locator));
        String actualText = driver.get().findElement(locator).getText();
        return actualText;
    }

    public void SelectOption(By combobox, String option) {
        WebElement element = explicitWait.get().until(ExpectedConditions.elementToBeClickable(combobox));
        Select select = new Select(element);
        select.selectByVisibleText(option);
    }

    public boolean isDisplayed(By locator){
        try {
            explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
