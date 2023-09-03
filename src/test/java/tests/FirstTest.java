package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    // 1. Wprowadzic wartosc w pole Text input
    @Test
    public void textInputTest() {
        WebElement textBox = driver.findElement(By.name("my-text"));
        String expectedTextBoxValue = "MyFirstTest";
        textBox.sendKeys(expectedTextBoxValue);
        String actualTextBoxValue = textBox.getAttribute("value");
        Assert.assertEquals(actualTextBoxValue, expectedTextBoxValue);
    }

    // 2. Wprowadzic wartosc w pole Password
    @Test
    public void passwordInputTest() {
        WebElement passwordInput = driver.findElement(By.name("my-password"));
        String expectedPasswordInputValue = "12345";
        passwordInput.sendKeys(expectedPasswordInputValue);
        String actualPasswordInputValue = passwordInput.getAttribute("value");
        Assert.assertEquals(actualPasswordInputValue, expectedPasswordInputValue);
    }


    // 3. Wprowadzic wartosc w pole Textarea
    @Test
    public void textareaInputTest() {
        WebElement textareaInput = driver.findElement(By.name("my-textarea"));
        String expectedTextareaInputValue = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        textareaInput.sendKeys(expectedTextareaInputValue);
        String actualTextareaInputValue = textareaInput.getAttribute("value");
        Assert.assertEquals(actualTextareaInputValue, expectedTextareaInputValue);
    }

    // 4. Sprawdzic stan Disabled input czy jest disabled czy nie (metoda isEnabled())
    @Test
    public void disabledInputTest() {
        WebElement disabledInput = driver.findElement(By.name("my-disabled"));
        Assert.assertFalse(disabledInput.isEnabled());
    }

    // 5. Wybrac opcje z Dropdown (select) (można zainspirować się metodą getSelectedValueFromDropdown() z projektu TAF)
    @Test
    public void selectFromDropdownTest() {
        WebElement dropdown = driver.findElement(By.name("my-select"));
        String expectedValue = "One";
        Select select = new Select(dropdown);
        select.selectByVisibleText(expectedValue);
        String actualValue = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualValue, expectedValue);
    }

    // 6. Zaznaczyć checkbox Default checkbox i odznaczyć checkbox Checked checkbox (metoda click())
    @Test
    public void defaultCheckboxTest() {
        WebElement defaultCheckbox = driver.findElement(By.id("my-check-2"));
        defaultCheckbox.click();
        Assert.assertTrue(defaultCheckbox.isSelected());
        defaultCheckbox.click();
        Assert.assertFalse(defaultCheckbox.isSelected());
    }
}
