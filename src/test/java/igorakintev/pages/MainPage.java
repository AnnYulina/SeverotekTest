package igorakintev.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    @FindBy(xpath = "//input[contains(@id,'id_username')]")
    private WebElement loginField;

    @FindBy(xpath = "//input[contains(@id,'id_password')]")
    private WebElement passwdField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginBtn;

    //after autorization
   @FindBy(xpath = "//a[contains(@href,'entry/add')]")
    private WebElement addEntry;

       public void inputLogin(String login) {
        loginField.sendKeys(login); }

    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd); }

    public void clickLoginBtn() {
        loginBtn.click(); }

    public void clickAddEntry() {
        addEntry.click(); }
}
