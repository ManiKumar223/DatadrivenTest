package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "email")
    WebElement loginCredentials;

    @FindBy(name = "password")
    WebElement loginPassword;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    public WebElement loginCredentials()
    {

        return loginCredentials;
    }

    public WebElement loginPassword()
    {

        return loginPassword;
    }
    public WebElement loginButton()
    {

        return loginButton;
    }
}
