import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class MosaicEditorAppPage {
    WebDriver driver = null;

    @BeforeClass
    void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.navigate().to("https://google.earthengine.app/view/mosaic-editor");
        Thread.sleep(3000);

    }

    @Test(priority = 1)
    void chooseDate() throws InterruptedException {
        WebElement dropDown = driver.findElement(By.id(":q"));
        dropDown.click();
        Thread.sleep(3000);


    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
