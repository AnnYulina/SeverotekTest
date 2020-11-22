package igorakintev.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EntryPage {
    public WebDriver driver;

    public EntryPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    @FindBy(xpath = "//a[@class='deletelink']")
    private WebElement deleteBtn;

    public void clickDeleteBtn() {
        deleteBtn.click();
    }
}
