package igorakintev.core;

import igorakintev.constants.Const;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;

public class InitWebDriver {
    public WebDriver driver;
    public InitWebDriver() {
        if (System.getProperty("browser").equals("firefox")) {
            setProperty("webdriver.gecko.driver", Const.FIREFOX_DRIVER);
            driver = new FirefoxDriver();
        } else {
            setProperty("webdriver.chrome.driver", Const.CHROME_DRIVER);
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Const.MAIN_PAGE);
    }
}
