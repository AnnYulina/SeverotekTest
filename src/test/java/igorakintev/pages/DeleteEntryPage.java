package igorakintev.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteEntryPage { public WebDriver driver;

    public DeleteEntryPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    @FindBy(xpath = "//input[@value='Да, я уверен']")
    private WebElement deleteBtn;

    public void clickDeleteBtn() {
        deleteBtn.click();
    }
}
