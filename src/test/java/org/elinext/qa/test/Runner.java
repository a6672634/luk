package org.elinext.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Set;

public class Runner {
    WebDriver driver;

    @BeforeClass

    public void initWebdriver() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver12214.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    @BeforeClass
    public void startUp() {
        driver.get("https://www.tut.by/");

    }

    @AfterClass
    public void closeBrowser() {
        driver.manage().deleteAllCookies();
       // driver.quit();
    }

    @Test
// Ввести в строку поиска "Лукашенко"
    public void Chek1() {

        WebElement field =
                driver.findElement(By.xpath("//*[@id=\"search_from_str\"]"));
        field.sendKeys("Лукашенко");
        Assert.assertTrue(field.isDisplayed(), "Нет поля ввода");

        WebElement field2 =
                driver.findElement(By.name("search"));
        Assert.assertTrue(field2.isDisplayed(), "Нет кнопки поиск");
        field2.click();

    }
}


