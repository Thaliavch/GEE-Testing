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

public class SplitViewAppPage {
    WebDriver driver = null;

    @BeforeClass
    void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.navigate().to("https://google.earthengine.app/view/split-panel");
        Thread.sleep(3000);

    }


    @Test(priority = 1)
    void chooseLeftDate() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click the dropdown to open it
        WebElement dropDown = driver.findElement(By.id(":q"));
        dropDown.click();
        Thread.sleep(2000);

        /*

        // Wait for the first date to become visible and click it
        WebElement date1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\":m\"]/div")));
        date1.click();

        ////*[@id=":n"]
        //*[@id=":n"]/div
        // Wait for the second date to become visible and click it
        WebElement date2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\":n\"]/div")));
        date2.click();

        // And so on for the rest of the dates...
        WebElement date3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\":o\"]/div")));
        date3.click();

        WebElement date4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\":p\"]/div")));
        date4.click();

         */
    }

    @Test(priority = 2)
    void chooseRightDate() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click the dropdown to open it
        WebElement dropDown = driver.findElement(By.id(":y"));
        dropDown.click();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    void splitPanel() throws InterruptedException {
        //WebElement panel = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div/div[3]"));
        //panel.click();
        // Create an Actions object
        Thread.sleep(3000);
        Actions actions = new Actions(driver);

        // Find the panel element that you want to drag
        WebElement panel = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div/div/div/div[3]"));

        // Drag the panel to the left by a certain amount of pixels
        actions.clickAndHold(panel)
                .moveByOffset(-100, 0) // Adjust the offset value as needed
                .release()
                .perform();
        Thread.sleep(4000);

        // Add a wait if needed for any animations to complete
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(panel, "style", "left"));

        // Drag the panel back to the right
        actions.clickAndHold(panel)
                .moveByOffset(100, 0) // Adjust the offset value as needed
                .release()
                .perform();

        // Again, wait for any animations to complete
        wait.until(ExpectedConditions.attributeContains(panel, "style", "left"));
        Thread.sleep(4000);

        // Second Try testing Panel

        // Drag the panel to the left by a certain amount of pixels
        actions.clickAndHold(panel)
                .moveByOffset(-200, 0) // Adjust the offset value as needed
                .release()
                .perform();
        Thread.sleep(4000);

        wait.until(ExpectedConditions.attributeContains(panel, "style", "left"));

        // Drag the panel back to the right
        actions.clickAndHold(panel)
                .moveByOffset(200, 0) // Adjust the offset value as needed
                .release()
                .perform();

        // Again, wait for any animations to complete
        wait.until(ExpectedConditions.attributeContains(panel, "style", "left"));
        Thread.sleep(4000);

        // Third try
        // Second Try testing Panel

        // Drag the panel to the left by a certain amount of pixels
        actions.clickAndHold(panel)
                .moveByOffset(200, 0) // Adjust the offset value as needed
                .release()
                .perform();
        Thread.sleep(4000);

        wait.until(ExpectedConditions.attributeContains(panel, "style", "left"));

        // Drag the panel back to the right
        actions.clickAndHold(panel)
                .moveByOffset(-200, 0) // Adjust the offset value as needed
                .release()
                .perform();

        // Again, wait for any animations to complete
        wait.until(ExpectedConditions.attributeContains(panel, "style", "left"));
        Thread.sleep(4000);

        // Fourth Try
        // Second Try testing Panel

        // Drag the panel to the left by a certain amount of pixels
        actions.clickAndHold(panel)
                .moveByOffset(100, 0) // Adjust the offset value as needed
                .release()
                .perform();
        Thread.sleep(4000);

        wait.until(ExpectedConditions.attributeContains(panel, "style", "left"));

        // Drag the panel back to the right
        actions.clickAndHold(panel)
                .moveByOffset(-100, 0) // Adjust the offset value as needed
                .release()
                .perform();

        // Again, wait for any animations to complete
        wait.until(ExpectedConditions.attributeContains(panel, "style", "left"));
        Thread.sleep(4000);
    }

    @Test(priority = 4)
    void testingMenuBtn() throws InterruptedException {

        String link1 = "About Earth Engine";
        String link2 = "Terms of Service";
        String link3 = "Privacy";
        String link4 = "Sign out";
        String link5 = "View Source Code";
        String link6 = "Shortcuts";

        dropDownTest(link1);
        dropDownTest(link2);
        dropDownTest(link3);
        dropDownTest(link4);
        dropDownTest(link5);
        //dropDownTest(link6);

       // Shortcut
        WebElement headerMenu = driver.findElement(By.id("header-menu-button"));
        headerMenu.click();
        WebElement shtcut = driver.findElement(By.id("shortcuts-button"));
        hoverOver(shtcut);
        Thread.sleep(2000);
        shtcut.click();
        Thread.sleep(2000);
        driver.navigate().back();

    }


    @AfterClass
    void tearDown(){
        driver.quit();
    }

    // Utility functions
    private void hoverOver(WebElement elm) throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(elm).perform();
    }

    private void dropDownTest( String linkText) throws InterruptedException {
        Thread.sleep((2000));
        WebElement headerMenu = driver.findElement(By.id("header-menu-button"));
        headerMenu.click();
        Actions action = new Actions(driver);
        WebElement linkToClick = driver.findElement(By.partialLinkText(linkText));
        action.moveToElement(linkToClick).perform();
        Thread.sleep(2000);

        // Store the main window handle before clicking
        String mainWindowHandle = driver.getWindowHandle();

        linkToClick.click();
        Thread.sleep(1500); // Allow time for new tab to open

        // Check if a new tab is opened
        if (driver.getWindowHandles().size() > 1) {
            for (String windowHandle : driver.getWindowHandles()) {
                if (!windowHandle.equals(mainWindowHandle)) {
                    driver.switchTo().window(windowHandle);
                    // Handle actions in the new tab
                    Thread.sleep(1500);
                    // Close the new tab and switch back to the main window
                    driver.close();
                    driver.switchTo().window(mainWindowHandle);
                    break;
                }
            }
        }

        // Return Split Test App
        driver.navigate().to("https://google.earthengine.app/view/split-panel");
        Thread.sleep(3000);
    }
}

/*
 @Test(priority = 1)
    void chooseDate() throws InterruptedException {
        WebElement dropDown = driver.findElement(By.id(":q"));
        dropDown.click();
        Thread.sleep(3000);

        WebElement date1 = driver.findElement(By.xpath("//*[@id=\":m\"]/div"));
        WebElement date2 = driver.findElement(By.xpath("//*[@id=\":n\"]/div"));
        WebElement date3 = driver.findElement(By.xpath("//*[@id=\":o\"]/div"));
        WebElement date4 = driver.findElement(By.xpath("//*[@id=\":p\"]/div"));

        hoverOver(date1);
        Thread.sleep(2000);
        date1.click();
        Thread.sleep(5000);

        hoverOver(date2);
        Thread.sleep(2000);
        date2.click();
        Thread.sleep(5000);

        hoverOver(date3);
        Thread.sleep(2000);
        date3.click();
        Thread.sleep(5000);

        hoverOver(date4);
        Thread.sleep(2000);
        date4.click();
        Thread.sleep(5000);


    }
 */