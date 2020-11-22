package igorakintev.test;

import igorakintev.constants.Const;
import igorakintev.core.InitWebDriver;
import igorakintev.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;


public class TestSait {
    public static MainPage mainPage;
    public static AddEntry addEntry;
    public static AdminBlog adminBlog;
    public static EntryPage entryPage;
    public static DeleteEntryPage deleteEntryPage;
    protected static WebDriver driver;

    @BeforeClass
    public static void init() {
        driver = (new InitWebDriver()).driver;

        mainPage = new MainPage(driver);
        addEntry = new AddEntry(driver);
        adminBlog = new AdminBlog(driver);
        entryPage = new EntryPage(driver);
        deleteEntryPage = new DeleteEntryPage(driver);

    }

    @Test
    public void severotekTest() {
        mainPage.inputLogin("selenium");
        mainPage.inputPasswd("super_password");
        mainPage.clickLoginBtn();
        int numCP = driver.findElements(By.xpath("//h1" +
                "" +
                "[text()='Панель управления']")).size();
        Assert.assertTrue(numCP > 0);
        mainPage.clickAddEntry();
        int numAE = driver.findElements(By.xpath("//h1" +
                "" +
                "[text()='Добавить entry']")).size();
        Assert.assertTrue(numAE > 0);
        String titleEntry = "title" + randomIntString(8);
        addEntry.inputTitle(titleEntry);
        addEntry.inputSlug("slug" + randomIntString(8));
        addEntry.inputTextMarkDown("slug" + randomIntString(8));
        addEntry.inputText("slug" + randomIntString(8));
        addEntry.clickSave();

        driver.get(Const.BLOG_PAGE);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='entries']//a[@class='entry_title']")).getText(), titleEntry);

        driver.get(Const.ADMIN_PAGE);
        if (adminBlog.lastEntry.getText().contains(titleEntry)) {
            adminBlog.lastEntry.click();
            entryPage.clickDeleteBtn();
            deleteEntryPage.clickDeleteBtn();
        }
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    private String randomIntString(int num) {
        String rez;
        Random rand = new Random();
        rez = "";
        for (int i = 1; i <= num; i++) {
            rez = rez + rand.nextInt(10);
        }
        return rez;
    }
}
