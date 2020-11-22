package igorakintev.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEntry {
    public WebDriver driver;

    public AddEntry(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    @FindBy(xpath = "//input[contains(@id,'id_title')]")
    private WebElement titleField;

    @FindBy(xpath = "//input[contains(@id,'id_slug')]")
    private WebElement slugField;

    @FindBy(xpath = "//textarea[contains(@id,'id_text_markdown')]")
    private WebElement textMarkdownField;

    @FindBy(xpath = "//textarea[contains(@id,'id_text')]")
    private WebElement textField;

    @FindBy(xpath = "//input[@name='_save']")
    private WebElement saveEntryBtn;

    public void inputTitle(String title) {
        titleField.clear();
        titleField.sendKeys(title);
    }
    public void inputSlug(String slug) {
        slugField.clear();
        slugField.sendKeys(slug);
    }
    public void inputTextMarkDown(String textMarkdown) {
        textMarkdownField.clear();
        textMarkdownField.sendKeys(textMarkdown);
    }
    public void inputText(String text) {
        textField.clear();
        textField.sendKeys(text);
    }

    public void clickSave() {
        saveEntryBtn.click();
    }
}
