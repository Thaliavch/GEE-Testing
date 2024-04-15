import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class TimeLapsePage {
    private WebDriver driver;

    @BeforeClass
    void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.navigate().to("https://earthengine.google.com/timelapse/");
        Thread.sleep(3000);

    }
    @Test(priority = 6)
    void pauseBtn() throws InterruptedException {
        // Initialize the WebDriverWait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Wait for the pause button to be visible
        WebElement pauseButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[title='Pause']")));

        // Perform actions on the pause button
        Actions action = new Actions(driver);
        action.moveToElement(pauseButton).perform();
        Thread.sleep(1500);
        pauseButton.click();
        Thread.sleep(1500);

        // If you also need to interact with the playback button
        // WebElement playbackButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.playbackButton")));
        // actions for playbackButton...
    }


    @Test(priority = 5)
    void zoomIn() throws InterruptedException {
       WebElement zoomInButton = driver.findElement(By.cssSelector("button.zoomin.ui-button"));

        Actions action = new Actions(driver);
        action.moveToElement(zoomInButton).perform();
        Thread.sleep(1500);

        zoomInButton.click();
        Thread.sleep(1000);
        zoomInButton.click();
        Thread.sleep(1000);


    }
    @Test(priority = 2)
    void zoomOut() throws InterruptedException {
        WebElement zoomOutButton = driver.findElement(By.cssSelector("button.zoomout.ui-button"));

        Actions action = new Actions(driver);
        action.moveToElement(zoomOutButton).perform();
        Thread.sleep(1500);

        zoomOutButton.click();
        Thread.sleep(1000);
        zoomOutButton.click();
        Thread.sleep(1000);

    }
    @Test(priority = 3)
    void searchBtn(){

    }
    @Test(priority = 4)
    void shareBtn(){

    }
    @Test(priority = 1)
    void toggleLearnMore() throws InterruptedException {
        WebElement button = driver.findElement(By.cssSelector("div.waypointDrawerContainerToggle[title='Toggle learn more']"));
        button.click();
        Thread.sleep(3000);


    }

    @Test(priority = 7)
    void aroundTheWorld(){

    }

    @AfterClass
    void teardown() {
        driver.quit();
    }

}
