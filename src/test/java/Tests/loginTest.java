package Tests;

import BrowserInfo.baseClass;
import PageObjects.AccountPage;
import PageObjects.LandingPage;
import PageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class loginTest extends baseClass {
    WebDriver driver;
    @Test(dataProvider = "loginDetails")
    public void login(String email,String password,String expectedResult) throws IOException, InterruptedException {
        driver = initializeBrowser();
        driver.get(prop.getProperty("url"));

        LandingPage landingPage = new LandingPage(driver);
        landingPage.myAccountDropdown().click();
        landingPage.loginOption().click();
        Thread.sleep(2000);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginCredentials().sendKeys(email);
        loginPage.loginPassword().sendKeys(password);
        Thread.sleep(2000);
        loginPage.loginButton().click();

        AccountPage accountPage = new AccountPage(driver);
        String  actualResult;
        try {
           if (accountPage.accountPageVerification().isDisplayed());
            {
                actualResult = "Success";
            }
        }
        catch (Exception e)
        {
            actualResult = "Fail";
        }
        Assert.assertEquals(actualResult,expectedResult);

    }
        @AfterMethod
                public void close()
        {
            driver.close();
        }

        @DataProvider
    public Object[][] loginDetails()
        {
            Object[][] data = {{"pmanikumar.at@gmail.com","12345","Success"},{"manikumar.poluboina@gmail.com","23456","Fail"}};
            return data ;
        }



}
