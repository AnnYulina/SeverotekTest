package igorakintev.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminBlog {
    public WebDriver driver;
    public AdminBlog(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(xpath = "//li[@class = 'odd'][1]/a[@class =' addlink']")
    public WebElement lastEntry;
}
