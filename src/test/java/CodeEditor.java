import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class CodeEditor {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://earthengine.google.com/");
        Thread.sleep(3000);

    }

    @Test(priority = 1)
    void GoogleSignIn() throws InterruptedException {

        // Going to Google Sign In Page:
        driver.get("https://accounts.google.com/");

        // Making sure page is loaded  before proceeding
        // Wait for an element on the new page to ensure it has loaded
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));

        // username and password variables
        String username="talisman.goshop@gmail.com";
        String password = "nuevacontrasena";

        System.out.println("Current URL: " + driver.getCurrentUrl());


        // Enter the username and proceed to next step
        driver.findElement(By.id("identifierId")).sendKeys(username);
        driver.findElement(By.id("identifierNext")).click();
        Thread.sleep(5000); // Wait for the password input to load

        // Enter the password and submit
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("passwordNext")).click();
        Thread.sleep(4000); // Wait for the inbox page to load


    }

    @Test(priority = 2)
    void accessingCodeEditor() throws InterruptedException {
        // Testing Platform Menu
        WebElement platform = driver.findElement(By.linkText("Platform"));

        // Create an instance of Actions class
        Actions action = new Actions(driver);

        // Perform the mouse hover action on the "Platform" link
        action.moveToElement(platform).perform();

        Thread.sleep(3000);


        // Going to Code Editor page - choosing from drop down
        WebElement codeEditorLink = driver.findElement(
                By.cssSelector("ul.dropdown a[href*='code.earthengine.google.com']"));

        action.moveToElement(codeEditorLink).perform();
        Thread.sleep(2000);
        codeEditorLink.click();

        Thread.sleep(3000);

    }

    @AfterClass
    void tearDown() {
        try {
            if (driver != null) {
                driver.quit(); // Attempt to close the browser and end the session
            }
        } catch (Exception e) {
            // Log the exception or print its stack trace. It's often enough just to print the stack trace during development.
            e.printStackTrace();
        }
    }

}
// Scratch Pad
/*
// Wait for the dropdown to become visible
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("ul.dropdown a[href*='code.earthengine.google.com']")));

 */

/*
        // Make sure to wait until dropdown menu is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.dropdown a[href*='code.earthengine.google.com']")));



        // Going to Code Editor page - choosing from drop down
        WebElement codeEditorLink = driver.findElement(
                By.cssSelector("ul.dropdown a[href*='code.earthengine.google.com']"));
        codeEditorLink.click();

*/