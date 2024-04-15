import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import java.util.Set;

public class OceanTimeseriesPage {
    WebDriver driver = null;
    String originalHandle = null;// Main Page handler


    @BeforeClass
    void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.navigate().to("https://google.earthengine.app/view/ocean");
        originalHandle = driver.getWindowHandle();
        Thread.sleep(3000);

    }

    @Test(priority = 1)
    void popOutIcon() throws InterruptedException {
        WebElement divButton = driver.findElement(By.className("pop-out-icon"));
        divButton.click();
        Thread.sleep(2000);


        // Wait for the new tab to open -> Use this instead of Thread sleep for new tab?
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


// Switch to new tab
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

// Now we can perform actions in the new tab
        // Download Buttons
        WebElement downloadcsv = driver.findElement(By.xpath("//button[contains(text(), 'Download CSV')]"));
        WebElement downloadsvg = driver.findElement(By.xpath("//button[contains(text(), 'Download SVG')]"));
        WebElement downloadpng = driver.findElement(By.xpath("//button[contains(text(), 'Download PNG')]"));

        hoverOver(downloadcsv);
        Thread.sleep(2000);
        downloadcsv.click();
        Thread.sleep(2000);

        hoverOver(downloadsvg);
        Thread.sleep(2000);
        downloadsvg.click();
        Thread.sleep(2000);


        hoverOver(downloadpng);
        Thread.sleep(2000);
        downloadpng.click();
        Thread.sleep(2000);

        driver.close();
        driver.switchTo().window(originalHandle);
        driver.navigate().to("https://google.earthengine.app/view/ocean");

        Thread.sleep(4000);


    }
    @Test(priority = 2)
    void draggableSplitPannel() throws InterruptedException {

        WebElement draggable = driver.findElement(By.className("goog-splitpane-handle-horizontal"));


        Actions actions = new Actions(driver);
        Thread.sleep(2000);

// The moveByOffset(x-offset, y-offset) method will move the element by the specified offset.
        // Move to the right
        actions.clickAndHold(draggable)
                .moveByOffset(100, 0) // Moves 50 pixels to the right
                .release()
                .perform();

        Thread.sleep(2000);

        // Move to the left
        actions.clickAndHold(draggable)
                .moveByOffset(-100, 0) // Moves 50 pixels to the right
                .release()
                .perform();

        Thread.sleep(3000);

    }

    // Test more points in the map
    @Test(priority = 3)
    void map() throws InterruptedException {
        Thread.sleep(5000);

        WebElement mapContainer = driver.findElement(By.cssSelector("div[style*='position: absolute']"));

        Actions actions = new Actions(driver);

        // Calculate the offset to click a specific location.
        int xOffset = 100; // X coordinate relative to the map container's top-left corner.
        int yOffset = 150; // Y coordinate relative to the map container's top-left corner.

        Thread.sleep(2000);
// Perform the action: move to the container and offset the mouse to the click location.
        actions.moveToElement(mapContainer)
                .moveByOffset(xOffset, yOffset)
                .click()
                .perform();

        Thread.sleep(10000);
    }

    @Test(priority = 4)
    void layersDropdown() throws InterruptedException {

        Thread.sleep(5000);

        WebElement dropdownTrigger = driver.findElement(By.cssSelector("div.title"));
        dropdownTrigger.click();
        Thread.sleep(5000);


        // Find the dropdown option by visible text 'clicked location'
        WebElement clickedLocation = driver.findElement(By.xpath("//span[@class='name expand' and text()='clicked location']"));
        clickedLocation.click();
        Thread.sleep(3000);


        // Clicking the option named 'SST Composite'
        WebElement sstComposite = driver.findElement(By.xpath("//span[@class='name expand' and text()='SST Composite']"));
        sstComposite.click();
        Thread.sleep(3000);

        // Clicking location option again
        clickedLocation.click();
        Thread.sleep(3000);


        // Clicking the option named 'SST Composite' again
        sstComposite.click();
        Thread.sleep(3000);


    }

    @Test(priority = 5)
    void headerMenuButtons() throws InterruptedException {
        //<i id="header-menu-button" class="material-icons">more_vert</i>
        Thread.sleep(5000);
        WebElement menuButton = driver.findElement(By.id("header-menu-button"));
        hoverOver(menuButton);
        menuButton.click();
        Thread.sleep(4000);
        menuButton.click();
        Thread.sleep(4000);
    }


    @AfterClass
    void tearDown() {
        driver.quit();
    }

    // Utility functions
    void hoverOver(WebElement elm) throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(elm).perform();
    }

}

/* Scratch session:
 @Test  (priority = 5)
    void testInputBox() throws InterruptedException {
        Thread.sleep(1000);
        // Input Box is inside shadow DOM

        The #shadow-root you're seeing in the DOM indicates that the element is within a Shadow DOM. Shadow DOM is a web standard that enables encapsulation of style and markup in web components.

Selenium has the ability to interact with elements inside a Shadow DOM starting from version 4.0. To access elements within a Shadow DOM, you have to use JavaScript to retrieve them or use the shadowRoot locator strategy.

/html/body/header/div[2]/ee-search-box//div[1]/input
// Step 1: Find the shadow host
WebElement shadowHost = driver.findElement(By.cssSelector("ee-search-box"));

// Step 2: Get the shadow root using getShadowRoot()
ShadowRoot shadowRoot = shadowHost.getShadowRoot();

// Step 3: Find the search input within the shadow root
WebElement searchInput = shadowRoot.findElement(By.cssSelector(".search-textbox"));

// Step 4: Send the search query
        searchInput.sendKeys("Cuba");
    }


@Test  (priority = 7)
void testInputBox() throws InterruptedException {
    Thread.sleep(1000);

    WebElement shadowHost = driver.findElement(By.xpath("/html/body/header/div[2]/ee-search-box//div[1]/input"));

    hoverOver(shadowHost);
    shadowHost.click();
    Thread.sleep(3000);
    shadowHost.sendKeys("Cuba");
}

   @Test(priority = 6)
    void mapButton() throws InterruptedException {
        ////*[@id="B2D0E09A-5587-490F-8AD4-C0CD9A9A445A"]
        WebElement mapBtn = driver.findElement(By.xpath("//*[@id=\"B2D0E09A-5587-490F-8AD4-C0CD9A9A445A\"]"));
        hoverOver(mapBtn);
        mapBtn.click();
        Thread.sleep(3000);
        ////*[@id="content"]/div/div[1]/div/div/div/div[1]/div/div/div/div/div[3]/div[5]/div[2]/div[1]/ul/li
        WebElement checkTerrain = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div/div[1]/div/div/div/div/div[3]/div[5]/div[2]/div[1]/ul/li"));
        checkTerrain.click();
        Thread.sleep(3000);
        checkTerrain.click();
    }
*/

