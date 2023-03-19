package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;

public class LoginTestDocker extends BaseWebTestDocker{
    LoginPage loginPage = new LoginPage(driver,explicitWait);

    @Test
    public void validLogin(){

//        loginPage.goTo();
        loginPage.inputEmail("anshika@gmail.com");
        loginPage.inputPassword("Iamking@000");
        loginPage.clickLogin();
    }

    @Test
    public void invalidEmail(){
//        loginPage.goTo();
        loginPage.inputEmail("anshika1@gmail.com");
        loginPage.inputPassword("Iamking@000");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.errorMessageDisplayed());
    }

    @Test
    public void invalidPassword(){
//        loginPage.goTo();
        loginPage.inputEmail("anshika@gmail.com");
        loginPage.inputPassword("Iamking1@000");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.errorMessageDisplayed());
    }
}
