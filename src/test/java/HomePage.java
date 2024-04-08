import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class HomePage {
    private WebDriver driver;
    String currentDropdownName;
    String currentElementLink;// for navBar dropdowns
    String currentLink;// for nabVarLinks

    @BeforeClass
    void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @Test(priority = 1)
    void navbarPlatform() throws InterruptedException {

        driver.navigate().to("https://earthengine.google.com/");


        // Accessing the "Platform" dropdown menu
        currentDropdownName = "Platform";

            //Overview
        currentElementLink = "ul.dropdown a[href*='/platform']";
        testingNavBarDropdownElements(currentDropdownName,currentElementLink);

        //Code Editor
        currentElementLink = "ul.dropdown a[href*='code.earthengine.google.com']";
        testingNavBarDropdownElements(currentDropdownName,currentElementLink);

        //Documentation
        currentElementLink = "ul.dropdown a[href*='developers.google.com/earth-engine/']";
        testingNavBarDropdownElements(currentDropdownName,currentElementLink);

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




    // Utility Methods
    public void testingNavBarDropdownElements(String dropdownName, String elementLink) throws InterruptedException {
        WebElement platform = driver.findElement(By.linkText(dropdownName));
        Actions action = new Actions(driver);
        action.moveToElement(platform).perform();
        Thread.sleep(3000);

        WebElement linkToClick = driver.findElement(By.cssSelector(elementLink));
        action.moveToElement(linkToClick).perform();
        Thread.sleep(2000);

        // Store the main window handle before clicking
        String mainWindowHandle = driver.getWindowHandle();

        linkToClick.click();
        Thread.sleep(3000); // Allow time for new tab to open

        // Check if a new tab is opened
        if (driver.getWindowHandles().size() > 1) {
            for (String windowHandle : driver.getWindowHandles()) {
                if (!windowHandle.equals(mainWindowHandle)) {
                    driver.switchTo().window(windowHandle);
                    // Handle actions in the new tab
                        Thread.sleep(3000);
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
        Thread.sleep(3000);

        // Store the main window handle before clicking
        String mainWindowHandle = driver.getWindowHandle();

        current_element.click();
        Thread.sleep(3000);

        if (driver.getWindowHandles().size() > 1) {
            for (String windowHandle : driver.getWindowHandles()) {
                if (!windowHandle.equals(mainWindowHandle)) {
                    driver.switchTo().window(windowHandle);
                    // Handle actions in the new tab
                    Thread.sleep(3000);
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



 */