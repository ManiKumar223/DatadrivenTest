package BrowserInfo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class baseClass {


   public static WebDriver driver;
    public static Properties prop;

    public WebDriver initializeBrowser() throws IOException {
        prop = new Properties();
        String propertiesPath = System.getProperty("user.dir")+"\\src\\main\\java\\BrowserInfo\\data.properties";
        FileInputStream fis = new FileInputStream(propertiesPath);
        prop.load(fis);
        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome"))
        {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

            WebDriverManager.chromedriver().setup();

            //System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Documents\\Downloads\\chromedriver_win32\\chromedriver.exe");
             driver = new ChromeDriver(options);
        }

        else if (browserName.equalsIgnoreCase("firefox"))
        {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriverManager.firefoxdriver().setup();

            //System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Documents\\Downloads\\chromedriver_win32\\chromedriver.exe");
             driver = new FirefoxDriver(options);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        return driver;
    }
}
