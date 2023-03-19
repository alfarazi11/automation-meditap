package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends BasePage{

    By email = By.id("userEmail");
    By password = By.id("userPassword");
    By loginButton = By.id("login");
    By errorMessageLogin = By.xpath("//div[@aria-label='Incorrect email or password.']");



    public LoginPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
        super(driver,explicitWait);
        PageFactory.initElements(driver.get(), this);
    }


    public void inputEmail(String Email){
        setText(email,Email);
    }

    public void inputPassword(String Password){
        setText(password,Password);
    }

    public void clickLogin(){
        click(loginButton);
    }

    public void goTo(){
        driver.get().get("https://rahulshettyacademy.com/client");
    }

    public void login(){
        inputEmail("anshika@gmail.com");
        inputPassword("Iamking@000");
        click(loginButton);
    }

    public boolean errorMessageDisplayed(){
        isDisplayed(errorMessageLogin);
        return true;
    }
}
