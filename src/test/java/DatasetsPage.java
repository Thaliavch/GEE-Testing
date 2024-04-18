import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class DatasetsPage {
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
        driver.navigate().to("https://developers.google.com/earth-engine/datasets/");

    }
    @Test(priority = 1)
    void search() throws InterruptedException {
        WebElement inputBox = driver.findElement(By.xpath("/html/body/section/devsite-header/div/div[1]/div/div/div[2]/devsite-search/form/div[1]/div/input"));
        inputBox.click();
        Thread.sleep(1000);

        inputBox.sendKeys("climate");
        Thread.sleep(2000);
        inputBox.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        driver.navigate().back();
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    void signInBtn() throws InterruptedException {
    WebElement signIn = driver.findElement(By.partialLinkText("Sign in"));
    hoverOver(signIn);
    signIn.click();
    Thread.sleep(3000);
    driver.navigate().back();
    Thread.sleep(2000);

    }

    @Test(priority = 3)
    void navBar() throws InterruptedException {
        String homeLink = "Home";
        String viewDatasets = "View all datasets";
        String browseTags = "Browse by tags";
        String landsat = "Landsat";
        String modis = "MODIS";
        String sentinel = "Sentinel";
        String publisher = "Publisher";
        String community = "Community";
        String apiDocs = "API Docs";

        testingNavBarLinks(homeLink);
        testingNavBarLinks(viewDatasets);
        testingNavBarLinks(browseTags);
        testingNavBarLinks(landsat);
        testingNavBarLinks(modis);
        testingNavBarLinks(sentinel);
        testingNavBarLinks(publisher);
        testingNavBarLinks(community);
        testingNavBarLinks(apiDocs);

    }

    @Test(priority = 4)
    void datasetBtn() throws InterruptedException {
        WebElement btn = driver.findElement(By.xpath("/html/body/section/section/main/devsite-content/article/div[2]/section[1]/div/div/div/div/div/div/section/div/div/div/a"));
        hoverOver(btn);
        btn.click();
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    void datasetBtns() throws InterruptedException {
        String btn1 = "Explore temperature data";
        String btn2 = "Explore climate data";
        String btn3 = "Explore atmosphere data";
        String btn4 = "Explore weather data";
        String btn5 = "Explore Landsat";
        String btn6 = "Explore Sentinel";
        String btn7 = "Explore MODIS";
        String btn8 = "Explore high-resolution data";
        String btn9 = "Explore elevation data";
        String btn10 = "Explore land cover data";
        String btn11 = "Explore cropland data";
        String btn12 = "Explore other geophysical data";

        scrollDown(1000);
        testingByPartialLinkText(btn1);
        scrollDown(1000);
        testingByPartialLinkText(btn2);
        scrollDown(1500);
        testingByPartialLinkText(btn3);
        scrollDown(1500);
        testingByPartialLinkText(btn4);
        scrollDown(2000);
        testingByPartialLinkText(btn5);
        scrollDown(2000);
        testingByPartialLinkText(btn6);
        scrollDown(2500);
        testingByPartialLinkText(btn7);
        scrollDown(3500);
        testingByPartialLinkText(btn8);
        scrollDown(3000);
        testingByPartialLinkText(btn9);
        scrollDown(3000);
        testingByPartialLinkText(btn10);
        scrollDown(3500);
        testingByPartialLinkText(btn11);
        scrollDown(3500);
        testingByPartialLinkText(btn12);

    }

    @Test(priority = 6)
    void socialMediaLinks1() throws InterruptedException {
        String link1 = "GitHub";
        String link2 = "Medium";
        String link3 = "GIS Stack Exchange";
        String link4 = "Twitter";
        String link5 = "Videos";

        scrollDown(4000);
        testingByPartialLinkText(link1);
        scrollDown(4000);
        testingByPartialLinkText(link2);
        scrollDown(4000);
        testingByPartialLinkText(link3);
        scrollDown(4000);
        testingByPartialLinkText(link4);
        scrollDown(4000);
        testingByPartialLinkText(link5);
    }
    @Test(priority = 7)
    void connectLinks() throws InterruptedException {
        String link1 = "Blog";
        String link2 = "Instagram";
        String link3 = "LinkedIn";
        String link4 = "X (Twitter)";
        String link5 = "YouTube";

        scrollDown(4000);
        testingByPartialLinkText(link1);
        scrollDown(4000);
        testingByPartialLinkText(link2);
        scrollDown(4000);
        testingByPartialLinkText(link3);
        scrollDown(4000);
        testingByPartialLinkText(link4);
        scrollDown(4000);
        testingByPartialLinkText(link5);
    }
    @Test(priority = 8)
    void programsLinks() throws InterruptedException {
        String link1 = "Women Techmakers";
        String link2 = "Google Developer Groups";
        String link3 = "Google Developer Experts";
        String link4 = "Accelerators";
        String link5 = "Google Developer Student Clubs";

        scrollDown(4000);
        testingByPartialLinkText(link1);
        scrollDown(4000);
        testingByPartialLinkText(link2);
        scrollDown(4000);
        testingByPartialLinkText(link3);
        scrollDown(4000);
        testingByPartialLinkText(link4);
        scrollDown(4000);
        testingByPartialLinkText(link5);

    }
    @Test(priority = 9)
    void developerConsolesLinks() throws InterruptedException {
        String link1 = "Google API Console";
        String link2 = "Google Cloud Platform Console";
        String link3 = "Google Play Console";
        String link4 = "Firebase Console";
        String link5 = "Actions on Google Console";
        String link6 = "Cast SDK Developer Console";
        String link7 = "Chrome Web Store Dashboard";

        scrollDown(4000);
        testingByPartialLinkText(link1);
        scrollDown(4000);
        testingByPartialLinkText(link2);
        scrollDown(4000);
        testingByPartialLinkText(link3);
        scrollDown(4000);
        testingByPartialLinkText(link4);
        scrollDown(4000);
        testingByPartialLinkText(link5);
        scrollDown(4000);
        testingByPartialLinkText(link6);
        scrollDown(4000);
        testingByPartialLinkText(link7);
    }
    @Test(priority = 10)
    void googleForDevelopersLinks() throws InterruptedException {
        String link1 = "Android";
        String link2 = "Chrome";
        String link3 = "Firebase";
        String link4 = "Google Cloud Platform";
        String link5 = "All products";

        scrollDown(4000);
        testingByPartialLinkText(link1);
        scrollDown(4000);
        //-------
        testingLinkWithLinkText(link2);
        scrollDown(4000);
        testingLinkWithLinkText(link3);
        scrollDown(4000);
        testingLinkWithLinkText(link4);
        scrollDown(4000);
        //------------

        testingByPartialLinkText(link5);

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
        driver.navigate().to("https://developers.google.com/earth-engine/datasets/");
        Thread.sleep(2000);

    }

    void testingByPartialLinkText(String text) throws InterruptedException {
        //String mainWindowHandle = driver.getWindowHandle();
        WebElement btn = driver.findElement(By.partialLinkText(text));


        Actions action = new Actions(driver);
        action.moveToElement(btn).perform();
        Thread.sleep(1500);

        btn.click();
        Thread.sleep(3000);

        driver.navigate().back();
        //driver.switchTo().window(mainWindowHandle);
    }

    private void testingLinkWithLinkText(String text) throws InterruptedException {
        String mainWindowHandle = driver.getWindowHandle();
        WebElement btn = driver.findElement(By.linkText(text));


        Actions action = new Actions(driver);
        action.moveToElement(btn).perform();
        Thread.sleep(1500);

        btn.click();
        Thread.sleep(3000);

        driver.navigate().back();
    }
    void scrollDown(int dist) throws InterruptedException {
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        exe.executeScript("window.scroll(0, arguments[0]);", dist); // Correctly passing dist
        Thread.sleep(2000); // It's better to use explicit waits rather than Thread.sleep
    }

    private void hoverOver(WebElement elm) throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(elm).perform();
    }


    @AfterClass
    void tearDown() throws InterruptedException {
        driver.quit();
    }

}
/* Scratch Section
@Test(priority = 2)
    void language() throws InterruptedException {
        // xpth: //button[@class='icon-language']

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-haspopup='true' and @aria-controls='language-menu']")));


        //WebElement btn = driver.findElement(By.xpath("//button[text()='Language']"));
        hoverOver(btn);
        btn.click();
        Thread.sleep(3000);

        WebElement spn = driver.findElement(By.partialLinkText("Español"));
        hoverOver(spn);
        spn.click();
        Thread.sleep(5000);

        hoverOver(btn);
        btn.click();
        Thread.sleep(3000);
        WebElement eng = driver.findElement(By.partialLinkText("English"));
        Thread.sleep(3000);


    }
 */