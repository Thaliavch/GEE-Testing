import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.awt.SystemColor.window;

public class AppsPage {
    WebDriver driver = null;

    @BeforeClass
    void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.navigate().to("https://www.earthengine.app/");
        Thread.sleep(3000);

    }
    @Test(priority = 1)
    void getSartedLink() throws InterruptedException {
        WebElement link = driver.findElement(By.partialLinkText("Get started"));
        link.click();
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(1000);
    }

    @Test(priority = 2)
    void oceanTimeSeries() throws InterruptedException {
        scrollDown(2000);
        WebElement link = driver.findElement(By.partialLinkText("Ocean Timeseries"));
        hoverOver(link);
        Thread.sleep(2000);
        link.click();
        Thread.sleep(4000);
        driver.navigate().back();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    void linkedMaps() throws InterruptedException {
        scrollDown(2000);
        WebElement link = driver.findElement(By.partialLinkText("Linked Maps"));
        hoverOver(link);
        Thread.sleep(2000);
        link.click();
        Thread.sleep(4000);
        driver.navigate().back();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    void splitPanel() throws InterruptedException {
        scrollDown(3000);
        WebElement link = driver.findElement(By.partialLinkText("Split Panel"));
        hoverOver(link);
        Thread.sleep(2000);
        link.click();
        Thread.sleep(4000);
        driver.navigate().back();
        Thread.sleep(2000);
    }


    @Test(priority = 5)
    void mosaicEditor() throws InterruptedException {
        scrollDown(3000);
        WebElement link = driver.findElement(By.partialLinkText("Mosaic Editor"));
        hoverOver(link);
        Thread.sleep(2000);
        link.click();
        Thread.sleep(4000);
        driver.navigate().back();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    void globalPopulation() throws InterruptedException {
        scrollDown(3000);
        WebElement link = driver.findElement(By.partialLinkText("Global Population Explorer"));
        hoverOver(link);
        Thread.sleep(2000);
        link.click();
        Thread.sleep(4000);
        driver.navigate().back();
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    void forestChange() throws InterruptedException {
        scrollDown(3000);
        WebElement link = driver.findElement(By.partialLinkText("Global Forest Change"));
        hoverOver(link);
        Thread.sleep(2000);
        link.click();
        Thread.sleep(4000);
        driver.navigate().back();
        Thread.sleep(2000);
    }

    @Test(priority = 8)
    void viewTabs() throws InterruptedException {
       // try again with scrollDown function?
        scrollDown(2000);

        //exe.executeScript("window.scrollTo(0, 2000)"); // Correctly passing dist
        //Thread.sleep(2000); // It's better to use explicit waits rather than Thread.sleep

        JavascriptExecutor exe = (JavascriptExecutor) driver;
        WebElement listViewTab = driver.findElement(By.partialLinkText("list"));
        hoverOver(listViewTab);
        Thread.sleep(1500);
        listViewTab.click();
        Thread.sleep(2000);


        WebElement moduleView = driver.findElement(By.partialLinkText("view_module"));
        hoverOver(moduleView);
        Thread.sleep(1500);
        moduleView.click();
        Thread.sleep(2000);
    }

    @Test(priority = 9)
    void footerLinks() throws InterruptedException {
        String link1 = "About Earth Engine";
        String link2 = "Terms of Service";
        String link3 = "Privacy";
        String link4 = "Sign out";

        testingByPartialLinkText(link1);
        testingByPartialLinkText(link2);
        testingByPartialLinkText(link3);
        testingByPartialLinkText(link4);

    }


    @AfterClass
    void teardown() {
        driver.quit();
    }

    // Utility Methods
    void scrollDown(int dist) throws InterruptedException {
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        exe.executeScript("window.scroll(0, arguments[0]);", dist); //passing dist
        Thread.sleep(2000); // It's better to use explicit waits rather than Thread.sleep?
    }

    void hoverOver(WebElement elm) throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(elm).perform();
    }

    void testingByPartialLinkText(String text) throws InterruptedException {
        WebElement btn = driver.findElement(By.partialLinkText(text));

        Actions action = new Actions(driver);
        action.moveToElement(btn).perform();
        Thread.sleep(1500);

        btn.click();
        Thread.sleep(3000);

        driver.navigate().back();
    }
}
