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
import java.util.Set;


public class HomePage {
    private WebDriver driver;
    String currentDropdownName;
    String currentElementLink;// for navBar dropdowns
    String currentLink;// for nabVarLinks

    @BeforeClass
    void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.navigate().to("https://earthengine.google.com/");

    }

    @Test(priority = 1)
    void navbarPlatform() throws InterruptedException {

        // Accessing the "Platform" dropdown menu
        currentDropdownName = "Platform";

        //Overview
        currentElementLink = "ul.dropdown a[href*='/platform']";
        testingNavBarDropdownElements(currentDropdownName, currentElementLink);

        //Code Editor
        currentElementLink = "ul.dropdown a[href*='code.earthengine.google.com']";
        testingNavBarDropdownElements(currentDropdownName, currentElementLink);

        //Documentation
        currentElementLink = "ul.dropdown a[href*='developers.google.com/earth-engine/']";
        testingNavBarDropdownElements(currentDropdownName, currentElementLink);

    }

    @Test(priority = 2)
    void navbarRest() throws InterruptedException {

        // Dataset
        currentLink = "Datasets";
        testingNavBarLinks(currentLink);

        // Noncommercial
        currentLink = "Noncommercial";
        testingNavBarLinks(currentLink);

        // Commercial
        currentLink = "Commercial";
        testingNavBarLinks(currentLink);

        // Timelapse
        currentLink = "Timelapse";
        testingNavBarLinks(currentLink);

        //Case Studies
        currentLink = "Case Studies";
        testingNavBarLinks(currentLink);

        //FAQ
        currentLink = "FAQ";
        testingNavBarLinks(currentLink);

        //Get Started
        currentLink = "Get Started";
        testingNavBarLinks(currentLink);


    }

    @Test(priority = 3)
    void videoButton() throws InterruptedException {
        WebElement youtube_button = driver.findElement(By.cssSelector("a.video-button.light-button"));
        youtube_button.click();
        Thread.sleep(3000);


        // Assuming WebDriver has already been initialized as `driver`
        driver.get("https://earthengine.google.com/");

    }

    @Test(priority = 4)
    void learnMoreButton() throws InterruptedException {

        scrollDown(1000);
        String link_text = "Learn More";
        testingButtons(link_text);

    }

    @Test(priority = 5)
    void timeLapseButton() throws InterruptedException {

        scrollDown(2000);
        String link_text = "Explore Timelapse";
        testingButtons(link_text);
    }

    @Test(priority = 6)
    void datasetsButton() throws InterruptedException {

        scrollDown(3000);
        String link_text = "Explore Datasets";
        testingButtons(link_text);
    }

    @Test(priority = 7)
    void apiButton() throws InterruptedException {

        scrollDown(4000);
        String link_text = "Explore The API";
        testingButtons(link_text);
    }

    @Test(priority = 8)
    void codeEditorButton() throws InterruptedException {// for the code editor it opens a new tab

        scrollDown(3500);
        String link_text = "Learn About The Code Editor";
        //testingButtons(link_text);

        String mainWindow = driver.getWindowHandle();
        WebElement codeBtn = driver.findElement(By.partialLinkText(link_text));
        codeBtn.click();


        // Wait for the new tab to open and switch to it
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        Thread.sleep(2000);
        // Close the new tab and switch back to the main window
        driver.close();
        driver.switchTo().window(mainWindow);
    }

    @Test(priority = 9)
    void caseStudiesButton() throws InterruptedException {

        scrollDown(4000);
        String link_text = "See Case Studies";
        testingButtons(link_text);
    }

    @Test(priority = 10)
    void signUpButton() throws InterruptedException {

        scrollDown(5000);
        String link_text = "Sign Up Now";
        testingButtons(link_text);
    }

    // Utility Methods
    public void testingNavBarDropdownElements(String dropdownName, String elementLink) throws InterruptedException {
        WebElement platform = driver.findElement(By.linkText(dropdownName));
        Actions action = new Actions(driver);
        action.moveToElement(platform).perform();
        Thread.sleep(1500);

        WebElement linkToClick = driver.findElement(By.cssSelector(elementLink));
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

        // Return to the home page
        driver.navigate().to("https://earthengine.google.com/");
        Thread.sleep(3000);
    }

    public void testingNavBarLinks(String element_name) throws InterruptedException {
        WebElement current_element = driver.findElement(By.linkText(element_name));
        Actions action = new Actions(driver);
        action.moveToElement(current_element).perform();
        Thread.sleep(1500);

        // Store the main window handle before clicking
        String mainWindowHandle = driver.getWindowHandle();

        current_element.click();
        Thread.sleep(1500);

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
        // Return to the home page
        driver.navigate().to("https://earthengine.google.com/");
        Thread.sleep(2000);

    }

    void testingButtons(String text) throws InterruptedException {
        String mainWindowHandle = driver.getWindowHandle();
        WebElement btn = driver.findElement(By.partialLinkText(text));


        Actions action = new Actions(driver);
        action.moveToElement(btn).perform();
        Thread.sleep(1500);

        btn.click();
        Thread.sleep(3000);

        driver.navigate().back();
        //driver.switchTo().window(mainWindowHandle);
    }
    void scrollDown(int dist) throws InterruptedException {
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        exe.executeScript("window.scroll(0, arguments[0]);", dist); // Correctly passing dist
        Thread.sleep(2000); // It's better to use explicit waits rather than Thread.sleep
    }

    @AfterClass
    void tearDown() throws InterruptedException {
        driver.quit();
    }


}
/* Scratch Section
public void testingNavBarElements(String dropdown_name, String element_link) throws InterruptedException {
        // Hovering over Platform link to display drop down menu:

        WebElement platform = driver.findElement(By.linkText(dropdown_name));
        // Create an instance of Actions class
        Actions action = new Actions(driver);
        // Perform the mouse hover action on the "Platform" link
        action.moveToElement(platform).perform();
        Thread.sleep(3000);

        WebElement overviewLink = driver.findElement(
                By.cssSelector(element_link));//"ul.dropdown a[href*='real link from web']"

        action.moveToElement(overviewLink).perform();
        Thread.sleep(2000);
        overviewLink.click();
        Thread.sleep(3000);
        // Going back to Home page
        driver.navigate().to("https://earthengine.google.com/");
        Thread.sleep(3000);

    }




     WebElement overviewLink = driver.findElement(
                By.cssSelector("ul.dropdown a[href*='/platform']"));

        action.moveToElement(overviewLink).perform();
        Thread.sleep(2000);
        overviewLink.click();
        Thread.sleep(3000);
        // Going back to Home page
        driver.navigate().to("https://earthengine.google.com/");

            //Code Editor
        WebElement codeEditorLink = driver.findElement(
                By.cssSelector("ul.dropdown a[href*='code.earthengine.google.com']"));

        action.moveToElement(codeEditorLink).perform();
        Thread.sleep(2000);
        codeEditorLink.click();
        Thread.sleep(3000);
            // Going back to Home page
        driver.navigate().back();
 //Documentation

// For youtube method

 // Need to switch to iframe because youtube video is embedded
        // Switch to the iframe
        driver.switchTo().frame("ytplayer");

        WebElement play_button = driver.findElement(By.id("ytp-id-36"));
        play_button.click();

        // Switch back to the main document
        driver.switchTo().defaultContent();



 */